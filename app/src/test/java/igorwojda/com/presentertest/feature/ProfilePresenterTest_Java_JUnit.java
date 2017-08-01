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

import static com.nhaarman.mockito_kotlin.BDDMockitoKt.then;
import static org.mockito.Mockito.verify;

public class ProfilePresenterTest_Java_JUnit {
    private ProfilePresenter profilePresenter;
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock EventBus mockEventBus;
    @Mock ProfileView mockView;

    @Before
    public void setUp() {
        profilePresenter = new ProfilePresenter(mockEventBus);
    }

    @Test
    public void when_take_view_register_event_bus() {
        // given
        profilePresenter.takeView(mockView);

        // then
        then(mockEventBus).should().register(profilePresenter);
    }

    @Test
    public void when_take_view_unregister_event_bus() {
        // given
        profilePresenter.dropView();

        // then
        verify(mockEventBus).unregister(profilePresenter);
    }
}
