
package com.springws.countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.springws.countries.wsdl.Country;
import com.springws.countries.wsdl.GetCountryRequest;
import com.springws.countries.wsdl.GetCountryResponse;

public class CountryServiceClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryServiceClient.class);

	public GetCountryResponse getCountryByName(String name) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(name);
		log.info("Requesting COUNTERY detials for " + name);
		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/countries", request,
				new SoapActionCallback("http://localhost:8080/ws/countries/getCountry"));
		return response;
	}

	public void printResponse(GetCountryResponse response) {
		Country country = response.getCountry();
		log.info("country :: " + country);
	}

}
