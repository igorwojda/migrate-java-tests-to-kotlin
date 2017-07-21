package igorwojda.com.presentertest.feature.profile;

import org.greenrobot.eventbus.EventBus;

public class ProfilePresenter<ProfileView> {

    private EventBus eventBus;

    public ProfilePresenter(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void onTakeView(ProfileView view) {
        eventBus.register(this);
    }

    public void onDropView() {
        eventBus.unregister(this);
    }
}
