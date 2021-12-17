package example.varnished.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.core.env.Profiles;


@SpringBootApplication
public class VarninshedApp {

    public static final Profiles DEV_PROFILE = Profiles.of("dev");

    public static void main(String[] args) throws Exception {

        SpringApplication.run(VarninshedApp.class, args);
    }
}
