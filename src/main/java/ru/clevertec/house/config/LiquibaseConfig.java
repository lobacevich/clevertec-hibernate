package ru.clevertec.house.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase(@Value("${liquibase.changelog_path}") String changelogPath,
                                     @Value("${liquibase.should_run}") boolean shouldRun) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setShouldRun(shouldRun);
        liquibase.setDataSource(dataSource);
        liquibase.setDropFirst(true);
        liquibase.setChangeLog(changelogPath);

        return liquibase;
    }
}
