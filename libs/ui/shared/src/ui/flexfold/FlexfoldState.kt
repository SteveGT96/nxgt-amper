package ui.flexfold

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.core.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration


data class FlexfoldState(
    val offset: Float,
    val animatedOffset: Float,
    val lazyState: LazyListState,
    val scrollableState: ScrollableState,
    val scrollableInteractionSource: MutableInteractionSource,
    val headerVisible: Boolean,
    val isLandscape: Boolean
)

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun rememberFlexfoldState(size: Float = 200f): FlexfoldState {

    val interactionSource = remember { MutableInteractionSource() }
    val offset = remember { mutableStateOf(size) }
    val lazyState = rememberLazyListState()
    val scrolled = remember { mutableStateOf(0f) }
    val isScrolled by interactionSource.collectIsDraggedAsState()
    var animatingState by remember { mutableStateOf(true) }
    val scrollableState = rememberScrollableState {
        val step = it / 4
        if (step < 0) {
            if ((offset.value + step) >= 0) {
                offset.value += step
            } else offset.value = 0f
        } else {
            if ((offset.value + step) <= size) {
                offset.value += step
            } else offset.value = size
        }
        if (it < 0) {
            if (offset.value < size / 2) {
                animatingState = false
            }
        } else {
            if (offset.value > size / 2) {
                animatingState = true
            }
        }
        scrolled.value = it
        it
    }
    val transition = updateTransition(targetState = isScrolled, "")
    val animatedOffset by transition.animateFloat(label = "") {
        when (isScrolled) {
            true -> offset.value
            else -> {
                if (scrolled.value < 0) {
                    if (offset.value < size / 2) {
                        return@animateFloat 0f
                    } else return@animateFloat size
                } else {
                    if (offset.value > size / 2) {
                        return@animateFloat size
                    } else return@animateFloat 0f
                }
            }
        }
    }
    val isLandscape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

    return remember(
        offset, animatedOffset, lazyState, scrollableState, interactionSource, animatingState
    ) {
        FlexfoldState(
            offset.value,
            animatedOffset,
            lazyState,
            scrollableState,
            interactionSource,
            animatingState,
            isLandscape
        )
    }
}