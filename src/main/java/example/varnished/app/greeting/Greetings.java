package example.varnished.app.greeting;

import example.varnished.infra.utils.AuthUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class Greetings {

    protected Supplier<String> currentUserIdentifier = AuthUtils::getCurrentUserIdentifier;

    private final Set<String> known = new HashSet<>();

    public String fetch() {

        var userId = currentUserIdentifier.get();

        if (known.contains(userId)) {
            return "there, again";
        }

        known.add(userId);

        return "there, you";
    }
}
