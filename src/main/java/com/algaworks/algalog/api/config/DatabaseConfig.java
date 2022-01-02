package com.algaworks.algalog.api.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${datasource.config.url}")
    private String url;

    @Value("${datasource.config.username}")
    private String username;

    @Value("${datasource.config.password}")
    private String password;

    @Value("${datasource.config.driver-classname}")
    private String driverClassname;
    
    @Bean
    public DataSource datasource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(this.url);
        hikariConfig.setUsername(this.username);
        hikariConfig.setPassword(this.password);
        hikariConfig.setDriverClassName(this.driverClassname);
        return new HikariDataSource(hikariConfig);
    }
}
