
package com.springws.countries;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springws.countries.wsdl.GetCountryResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(CountryServiceClient countryServiceClient) {
		return args -> {
			String name = "India";

			if (args.length > 0) {
				name = args[0];
			}
			GetCountryResponse response = countryServiceClient.getCountryByName(name);
			System.out.println("Application.lookup()" + response.getCountry().getName() + " | "+response.getCountry().getName() + " | "+response.getCountry().getCapital() + " | "+response.getCountry().getCurrency() + " | "+response.getCountry().getPopulation());
		};
	}

}
