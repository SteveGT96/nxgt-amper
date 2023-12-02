import android.content.Context
import org.koin.core.module.Module
import org.koin.dsl.module

fun sharedModule(context: Context): Module {
	return module {
		single { context }
	}
}