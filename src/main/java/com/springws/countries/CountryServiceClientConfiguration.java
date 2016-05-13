
package com.springws.countries;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryServiceClientConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.springws.countries.wsdl");
		return marshaller;
	}

	@Bean
	public CountryServiceClient  countryServiceClient(Jaxb2Marshaller marshaller) {
		CountryServiceClient client = new CountryServiceClient();
		client.setDefaultUri("http://localhost:8080/ws/countries");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
