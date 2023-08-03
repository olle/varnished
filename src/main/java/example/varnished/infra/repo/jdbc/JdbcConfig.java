package example.varnished.infra.repo.jdbc;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Profile("jdbc")
@Configuration
public class JdbcConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.alpha")
    public DataSourceProperties alphaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.alpha.hikari")
    public DataSource alphaDataSource() {
        return alphaDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcTemplate alphaTemplate() {
        return new JdbcTemplate(alphaDataSource());
    }

    @Bean
    @ConfigurationProperties("spring.datasource.omega")
    public DataSourceProperties omegaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.omega.hikari")
    public DataSource omegaDataSource() {
        return omegaDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcTemplate omegaTemplate() {
        return new JdbcTemplate(omegaDataSource());
    }

}
