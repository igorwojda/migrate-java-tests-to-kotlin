@file:Suppress("IllegalIdentifier")

package igorwojda.com.presentertest.feature

import com.nhaarman.mockito_kotlin.then
import com.nhaarman.mockito_kotlin.verify
import igorwojda.com.presentertest.feature.profile.ProfilePresenter
import igorwojda.com.presentertest.feature.profile.ProfileView
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class ProfilePresenterTest_Sample1_Kotlin_JUnit {
    @JvmField @Rule var mockitoRule = MockitoJUnit.rule()
    lateinit var profilePresenter: ProfilePresenter<ProfileView>
    @Mock lateinit var mockView: ProfileView
    @Mock lateinit var mockEventBus: EventBus

    @Before
    fun setUp() {
        profilePresenter = ProfilePresenter(mockEventBus)
    }

    @Test
    fun `when take view then register event bus`() {
        // given
        profilePresenter.takeView(mockView)

        // then
        then(mockEventBus).should().register(profilePresenter)
    }

    @Test
    fun `when take view register event bus when take view`() {
        // given
        profilePresenter.dropView()

        // then
        verify(mockEventBus).unregister(profilePresenter)
    }
}
