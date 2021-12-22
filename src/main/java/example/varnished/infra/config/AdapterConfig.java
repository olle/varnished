package example.varnished.infra.config;

import example.varnished.app.greeting.Greetings;

import example.varnished.web.IndexWebAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AdapterConfig {

    @Bean
    Greetings greetings() {

        return new Greetings();
    }


    @Bean
    IndexWebAdapter indexWebAdapter(Greetings greetings) {

        return new IndexWebAdapter() {

            @Override
            public String fetchGreeting() {

                return greetings.fetch();
            }
        };
    }
}
