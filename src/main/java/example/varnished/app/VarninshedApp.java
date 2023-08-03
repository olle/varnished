package example.varnished.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import example.varnished.infra.repo.RepoConfig;
import example.varnished.web.WebConfig;

/**
 * The default profile, does not auto-configure JDBC, even though there are triggering assets on the classpath. This is
 * so that we are able to run most unit and module testing with injected test dummies or mocks - as desirable. The
 * Frobulating application will be a delight to develop and try out locally, with the option to run a full
 * container-setup and the production-services using profiles.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class VarninshedApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(VarninshedApp.class, args);
    }

    @Configuration
    @Import({ WebConfig.class, RepoConfig.class })
    public static class Bootstrap {
        // OK
    }
}
