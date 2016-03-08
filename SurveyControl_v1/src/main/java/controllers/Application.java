package controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@PropertySources(value = @PropertySource("classpath:/application.properties"))
@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories("entity")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
