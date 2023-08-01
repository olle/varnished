package example.varnished.infra.utils;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class AuthUtils {

    private AuthUtils() {

        // Hidden.
    }

    public static String getCurrentUserIdentifier() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof UsernamePasswordAuthenticationToken) {
            return ((UsernamePasswordAuthenticationToken) auth).getName();
        }

        return "";
    }
}
