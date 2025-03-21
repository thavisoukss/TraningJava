package com.bee.moveData;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
public class DatabaseConfig{

        // First DataSource (Primary database)
        @Value("${spring.datasource.primary.url}")
        private String primaryUrl;
        @Value("${spring.datasource.primary.username}")
        private String primaryUsername;
        @Value("${spring.datasource.primary.password}")
        private String primaryPassword;
        @Value("${spring.datasource.primary.driver-class-name}")
        private String primaryDriverClassName;

        // Second DataSource (Secondary database)
        @Value("${spring.datasource.secondary.url}")
        private String secondaryUrl;
        @Value("${spring.datasource.secondary.username}")
        private String secondaryUsername;
        @Value("${spring.datasource.secondary.password}")
        private String secondaryPassword;
        @Value("${spring.datasource.secondary.driver-class-name}")
        private String secondaryDriverClassName;

        // Primary DataSource Bean
        @Bean(name = "primaryDataSource")
        @Primary
        public DataSource primaryDataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(primaryDriverClassName);
            dataSource.setUrl(primaryUrl);
            dataSource.setUsername(primaryUsername);
            dataSource.setPassword(primaryPassword);
            return dataSource;
        }

        // Primary JdbcTemplate Bean
        @Bean(name = "primaryJdbcTemplate")
        @Primary
        public JdbcTemplate primaryJdbcTemplate() {
            return new JdbcTemplate(primaryDataSource());
        }

        // Secondary DataSource Bean
        @Bean(name = "secondaryDataSource")
        public DataSource secondaryDataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(secondaryDriverClassName);
            dataSource.setUrl(secondaryUrl);
            dataSource.setUsername(secondaryUsername);
            dataSource.setPassword(secondaryPassword);
            return dataSource;
        }

        // Secondary JdbcTemplate Bean
        @Bean(name = "secondaryJdbcTemplate")
        public JdbcTemplate secondaryJdbcTemplate() {
            return new JdbcTemplate(secondaryDataSource());
        }
}
