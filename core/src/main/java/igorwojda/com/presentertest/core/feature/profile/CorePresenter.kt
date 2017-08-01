package igorwojda.com.presentertest.core.feature.profile

import org.greenrobot.eventbus.EventBus

class CorePresenter<VIEW : CoreView>(private val eventBus: EventBus) {
    private var view: VIEW? = null

    fun takeView(view: VIEW) {
        this.view = view

        eventBus.register(this)
    }

    fun dropView() {
        eventBus.unregister(this)
    }

    fun onLoadUserData() {
        view!!.showLoading()
    }
}
