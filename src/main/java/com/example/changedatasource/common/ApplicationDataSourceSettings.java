package com.example.changedatasource.common;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationDataSourceSettings {

    private final Environment environment;

    @Autowired
    public ApplicationDataSourceSettings(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource(){
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        dataSource.setPartitionCount(3);
        dataSource.setAcquireIncrement(5);
        return dataSource;
    }
}
