package igorwojda.com.presentertest.feature.profile;

import org.greenrobot.eventbus.EventBus;

public class ProfilePresenter<VIEW extends ProfileView> {

    private EventBus eventBus;
    private VIEW view;

    public ProfilePresenter(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void onTakeView(VIEW view) {
        this.view = view;

        eventBus.register(this);
    }

    public void onDropView() {
        eventBus.unregister(this);
    }

    public void onLoadUserData() {
        view.showLoading();
    }
}
