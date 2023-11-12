package isep.edu.sn.examen_spring_boot_semestre4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ExamenSpringBootSemestre4Application {

	public static void main(String[] args) {

		SpringApplication.run
				(ExamenSpringBootSemestre4Application.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override

			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/*")
						.allowedOrigins("*");
			}
		};
	}

}
