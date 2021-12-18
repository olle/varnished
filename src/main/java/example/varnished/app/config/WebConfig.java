package example.varnished.app.config;

import example.varnished.web.Web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Web.class)
public class WebConfig {
}
