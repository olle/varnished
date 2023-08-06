package example.varnished.infra.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Logging extends Trait {

    default Logger logger() {
        return LoggerFactory.getLogger(getClass());
    }
}
