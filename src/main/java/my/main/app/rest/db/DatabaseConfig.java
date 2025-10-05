package my.main.app.rest.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.dbcp2.url}")
    private String url;
    @Value("${spring.datasource.hikari.username}")
    private String username;
    @Value("${spring.datasource.hikari.password}")
    private String password;
    @Value("${spring.liquibase.change-log}")
    private String changeLog;

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public SpringLiquibase springLiquibase(HikariDataSource hikariDataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog(changeLog);
        springLiquibase.setDataSource(hikariDataSource);
        return springLiquibase;
    }

}
