package com.example.JavaTemplate;

import com.example.JavaTemplate.OuterLayer.outerLayer;
import com.health.HealthIndicator101.Healthindicator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class JavaTemplateApplication implements CommandLineRunner {
		public static void main(String[] args) {

		SpringApplication.run(JavaTemplateApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		outerLayer layer = new outerLayer();
		layer.mainController();
	}

}
