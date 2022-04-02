package com.gestao.sistemapolicial.config;

import com.gestao.sistemapolicial.AppConstants;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url(System.getenv(AppConstants.EnvVars.POLICIADB_URI));
        dataSourceBuilder.username(System.getenv(AppConstants.EnvVars.POLICIADB_USER));
        dataSourceBuilder.password(System.getenv(AppConstants.EnvVars.POLICIADB_PASS));
        return dataSourceBuilder.build();
    }

}
//"jdbc:postgresql://ec2-3-216-221-31.compute-1.amazonaws.com:5432/dcumt0our4s67m?user=lkqcjndnokjpyv&password=e344d77aa7f97a5f4fa7065ecb72217613fe3367d2e820f073008a7e4d6a607a"