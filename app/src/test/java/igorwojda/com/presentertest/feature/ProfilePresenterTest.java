package igorwojda.com.presentertest.feature;

import igorwojda.com.presentertest.feature.profile.ProfilePresenter;
import igorwojda.com.presentertest.feature.profile.ProfileView;
import org.greenrobot.eventbus.EventBus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class ProfilePresenterTest {
    private ProfilePresenter profilePresenter;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock EventBus mockEventBus;
    @Mock ProfileView mockView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        profilePresenter = new ProfilePresenter(mockEventBus);
    }

    @Test
    public void when_take_view_then_register_event_bus() {
        // when
        profilePresenter.onTakeView(mockView);

        // then
        verify(mockEventBus).register(profilePresenter);
    }

    @Test
    public void when_drop_view_then_unregister_event_bus() {
        // given
        profilePresenter.onTakeView(mockView);

        // when
        profilePresenter.onDropView();

        // then
        verify(mockEventBus).unregister(profilePresenter);
    }

//    @Test
//    public void should_load_activity_tab_config_after_call_on_retry() {
//        //given
//        notificationsPresenter.takeView(mockNotificationsView);
//
//        //when
//        notificationsPresenter.onRetryButtonClicked();
//
//        //then
//        verify(mockEventBus).post(any(LoadHomeActivityContentEvent.class));
//    }
}
