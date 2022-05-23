package com.techreturners.movieapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}

	@Bean
	public GroupedOpenApi movieSearchGroup(){
		return GroupedOpenApi.builder()
				.group("movie-api-search")
				.pathsToMatch("/search*/**")
				.build();
	}

	@Bean
	public GroupedOpenApi userFavoriteManagerGroup(){
		return GroupedOpenApi.builder()
				.group("user-favorite-manager-api")
				.pathsToMatch("/userfavorite/**")
						.build();
	}

	@Bean
	public OpenAPI	movieSearchInfoApi(){
		return new OpenAPI().info(new Info().title("Movie Search API")
				.description("API to help you get movie recommendations !")
				.version("v1")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}
}
