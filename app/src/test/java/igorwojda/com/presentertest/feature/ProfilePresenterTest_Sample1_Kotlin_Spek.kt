package igorwojda.com.presentertest.feature

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import igorwojda.com.presentertest.feature.profile.ProfilePresenter
import igorwojda.com.presentertest.feature.profile.ProfileView
import org.greenrobot.eventbus.EventBus
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

//@RunWith(JUnitPlatform::class)
class ProfilePresenterTest_Sample1_Kotlin_Spek : Spek({

    val mockView by memoized { mock<ProfileView>() }
    val mockEventBus by memoized { mock<EventBus>() }

    val profilePresenter by memoized {
        ProfilePresenter<ProfileView>(mockEventBus)
    }

    given("ProfilePresenter") {

        on("take view") {
            profilePresenter.takeView(mockView)

            it("event bus") {
                verify(mockEventBus).register(profilePresenter)
            }
        }

        on("drop view") {
            profilePresenter.dropView()

            it("unregister event bus") {
                verify(mockEventBus).unregister(profilePresenter)
            }
        }
    }
})