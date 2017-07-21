package igorwojda.com.presentertest.feature;

import igorwojda.com.presentertest.feature.profile.ProfilePresenter;
import igorwojda.com.presentertest.feature.profile.ProfileView;
import org.greenrobot.eventbus.EventBus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
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
    public void given_take_view_when_drop_view_then_unregister_event_bus() {
        // given
        profilePresenter.onTakeView(mockView);

        // when
        profilePresenter.onDropView();

        // then
        verify(mockEventBus).unregister(profilePresenter);
    }

    @Test
    public void given_take_view_when_load_users_then_show_loading() {
        //given
        profilePresenter.onTakeView(mockView);

        //when
        profilePresenter.onLoadUserData();

        //then
        verify(mockView).showLoading();
    }
}
