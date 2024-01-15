package ru.clevertec.house.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import ru.clevertec.house.mapper.HouseMapper;
import ru.clevertec.house.mapper.HouseMapperImpl;
import ru.clevertec.house.mapper.PersonMapper;
import ru.clevertec.house.mapper.PersonMapperImpl;

import java.util.Objects;
import java.util.Properties;

@Configuration
@ComponentScan("ru.clevertec.house")
@PropertySource("classpath:application.yml")
public class SpringConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        Properties yamlObject = Objects.requireNonNull(yaml.getObject(), "Property not found");
        propertyConfigurer.setProperties(yamlObject);

        return propertyConfigurer;
    }

    @Bean
    public HouseMapper houseMapper() {
        return new HouseMapperImpl();
    }

    @Bean
    public PersonMapper personMapper() {
        return new PersonMapperImpl();
    }
}
