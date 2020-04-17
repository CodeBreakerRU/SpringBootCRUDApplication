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

import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
        (entityManagerFactoryRef = "ProductEntityManagerFactory",
                transactionManagerRef = "ProductTransactionManager", basePackages ={"com.mtit.abcApplication.Product.repo"})

public class ProductDBConfig {

    @Primary
    @Bean(name = "ProductDataSource")
    @ConfigurationProperties(prefix = "spring.product.datasource")

    public DataSource dataSource() {

        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "ProductEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ProductEntityManagerFactory
            (EntityManagerFactoryBuilder builder, @Qualifier("ProductDataSource") DataSource dataSource) {

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        return builder.dataSource(dataSource).properties(properties)
                .packages("com.mtit.abcApplication.Product.Domain").persistenceUnit("Product").build();
    }

    @Primary
    @Bean(name = "ProductTransactionManager")
    public PlatformTransactionManager ProductTransactionManager(
            @Qualifier("ProductEntityManagerFactory") EntityManagerFactory ProductEntityManagerFactory) {
        return new JpaTransactionManager(ProductEntityManagerFactory);
    }
}
