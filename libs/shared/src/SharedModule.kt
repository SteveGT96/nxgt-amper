import android.content.Context
import helpers.apolloClient
import io.github.serpro69.kfaker.Faker
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import room.SharedDatabase
import room.repository.TokenRepository
import services.AuthService
import services.SizeClassService

fun sharedModule(context: Context): Module {
	return module {
		single { context }
		single { SharedDatabase.getDatabase(get()) }
		single { Faker() }
		singleOf(::TokenRepository)
		single { AuthService(get()) }
		single { apolloClient(get()) }
		singleOf(::SizeClassService)
	}
}