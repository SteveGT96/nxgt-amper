package ui.flexfold

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Flexfold(
    headerSize: Float = 220f,
    title: @Composable () -> Unit = {},
    header: @Composable () -> Unit = {},
    content: LazyListScope.() -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
) {
    val state = rememberFlexfoldState(headerSize)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state.scrollableState,
                Orientation.Vertical,
                interactionSource = state.scrollableInteractionSource,
                enabled = if (state.isLandscape) false else (
                        state.lazyState.firstVisibleItemIndex == 0 && state.lazyState.firstVisibleItemScrollOffset <= 0
                        )
            )
    ) {
        Row(
            Modifier
                .height(if (state.isLandscape) 0.dp else state.animatedOffset.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(Modifier.alpha(if (state.isLandscape) 0f else state.animatedOffset / headerSize)) {
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    header()
                }
            }
        }
        LazyColumn(
            Modifier
                .weight(1f)
                .fillMaxWidth(),
            state = state.lazyState,
            userScrollEnabled = if (state.isLandscape) true else (state.offset <= 0f)
        ) {
            stickyHeader {
                TopAppBar(
                    navigationIcon = navigationIcon,
                    title = {
                        Box(Modifier.alpha(if (state.isLandscape) 1f else (headerSize - state.animatedOffset) / headerSize)) {
                            Column(
                                Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                title()
                            }
                        }
                    },
                    actions = actions
                )
            }
            content()
        }
    }
}