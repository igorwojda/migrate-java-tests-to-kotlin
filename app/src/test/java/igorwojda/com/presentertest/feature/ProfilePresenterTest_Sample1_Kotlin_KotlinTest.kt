package com.babylon.v2.home.presenter

import com.nhaarman.mockito_kotlin.verify
import igorwojda.com.presentertest.feature.profile.ProfilePresenter
import igorwojda.com.presentertest.feature.profile.ProfileView
import io.kotlintest.TestCaseContext
import io.kotlintest.specs.BehaviorSpec
import org.greenrobot.eventbus.EventBus
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ProfilePresenterTest_Sample1_Kotlin_KotlinTest : BehaviorSpec() {
    private lateinit var profilePresenter: ProfilePresenter<ProfileView>
    @Mock lateinit var mockView: ProfileView
    @Mock lateinit var mockEventBus: EventBus

    override val oneInstancePerTest = false

    override fun interceptTestCase(context: TestCaseContext, test: () -> Unit) {
        MockitoAnnotations.initMocks(this)

        profilePresenter = ProfilePresenter(mockEventBus)

        test() // don't forget to call test()!
    }

    init {

        Given("ProfilePresenter") {
            When("take view") {
                profilePresenter.takeView(mockView)

                Then("register event bus") {
                    verify(mockEventBus).register(profilePresenter)
                }
            }

            When("drop view") {
                profilePresenter.dropView()

                Then("unregister event bus") {
                    verify(mockEventBus).unregister(profilePresenter)
                }
            }
        }

    }
}