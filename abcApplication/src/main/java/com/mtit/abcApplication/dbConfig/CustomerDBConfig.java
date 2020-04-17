package com.mtit.abcApplication.dbConfig;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
        (entityManagerFactoryRef = "CustomerEntityManagerFactory",
                transactionManagerRef = "CustomerTransactionManager", basePackages ={"com.mtit.abcApplication.Customer.repo"})
        //        transactionManagerRef = "CustomerTransactionManager", basePackages ={"com.mtit.abcApplication.repository"})

public class CustomerDBConfig {

//    @Primary
    @Bean(name = "CustomerDataSource")
    @ConfigurationProperties(prefix = "spring.customer.datasource")

    public DataSource dataSource(){

        return DataSourceBuilder.create().build();
    }

//    @Primary
    @Bean(name = "CustomerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean CustomerEntityManagerFactory
            (EntityManagerFactoryBuilder builder, @Qualifier("CustomerDataSource") DataSource dataSource) {

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        return builder.dataSource(dataSource).properties(properties)
             //   .packages("com.mtit.abcApplication.entity").persistenceUnit("Customer").build();
                .packages("com.mtit.abcApplication.Customer.Domain").persistenceUnit("Customer").build();

    }

//    @Primary
    @Bean(name = "CustomerTransactionManager")
    public PlatformTransactionManager CustomerTransactionManager(
            @Qualifier("CustomerEntityManagerFactory") EntityManagerFactory CustomerEntityManagerFactory) {
        return new JpaTransactionManager(CustomerEntityManagerFactory);

    }
}
