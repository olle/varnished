package example.varnished.app.greeting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingsTest {

    @Test
    void ensureFirstVisitGreetingForDifferentUsers() throws Exception {

        var sut = new Greetings();

        sut.currentUserIdentifier = () -> "some-user-identifier";
        assertThat(sut.fetch()).isEqualTo("there, you");
        assertThat(sut.fetch()).isEqualTo("there, again");

        sut.currentUserIdentifier = () -> "other-user-identifier";
        assertThat(sut.fetch()).isEqualTo("there, you");
        assertThat(sut.fetch()).isEqualTo("there, again");
    }

    @Test
    void ensureReVisitGreetingForSameUser() {

        var sut = new Greetings();

        sut.currentUserIdentifier = () -> "some-user-identifier";

        assertThat(sut.fetch()).isEqualTo("there, you");
        assertThat(sut.fetch()).isEqualTo("there, again");
    }
}
