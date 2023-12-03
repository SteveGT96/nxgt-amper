package fixture

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import io.github.serpro69.kfaker.Faker
import room.model.User
import org.koin.core.annotation.Singleton

@Singleton
class UserFixture(faker: Faker) {
    val users = List(20) {
        User(
            faker.random.nextInt(0, 100), faker.name.firstName(), faker.internet.email(),
        )
    }
}

class UserListProvider : PreviewParameterProvider<List<User>> {
    override val values: Sequence<List<User>> = sequenceOf(
        UserFixture(Faker()).users
    )
}