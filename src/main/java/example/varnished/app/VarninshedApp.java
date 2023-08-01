package example.varnished.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import example.varnished.web.WebConfig;

@SpringBootApplication
public class VarninshedApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(VarninshedApp.class, args);
    }

    @Configuration
    @Import({ WebConfig.class })
    public static class Bootstrap {
        // OK
    }
}
