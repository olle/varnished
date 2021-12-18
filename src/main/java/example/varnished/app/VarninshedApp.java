package example.varnished.app;

import example.varnished.infra.config.SecurityConfig;
import example.varnished.infra.config.WebConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@SpringBootApplication
public class VarninshedApp {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(VarninshedApp.class, args);
    }

    @Configuration
    @Import({ WebConfig.class, SecurityConfig.class })
    public static class Bootstrap {

        // OK
    }
}
