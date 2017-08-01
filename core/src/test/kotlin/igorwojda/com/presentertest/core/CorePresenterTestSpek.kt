package igorwojda.com.presentertest.core

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import igorwojda.com.presentertest.core.feature.profile.CorePresenter
import igorwojda.com.presentertest.core.feature.profile.CoreView
import org.greenrobot.eventbus.EventBus
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


//@RunWith(JUnitPlatform::class)
class CorePresenterTestSpek : Spek({

    val mockView by memoized { mock<CoreView>() }
    val mockEventBus by memoized { mock<EventBus>() }

    val profilePresenter by memoized {
        CorePresenter<CoreView>(mockEventBus)
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