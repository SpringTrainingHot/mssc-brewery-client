package com.taranenkoant.msscbreweryclient.web.client;

import com.taranenkoant.msscbreweryclient.web.model.BeerDTO;
import com.taranenkoant.msscbreweryclient.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beerDTO){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1 , beerDTO);
    }

    public void updateBeer(UUID id, BeerDTO beerDTO){
        restTemplate.put(apihost + BEER_PATH_V1 + "/" + id.toString(), beerDTO);
    }

    public void deleteBeer(UUID id){
        restTemplate.delete(apihost + BEER_PATH_V1 + "/" + id.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerDTO getCustomerById(UUID id){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + id.toString(), CustomerDTO.class);
    }

    public URI saveNewCustomer(UUID id, CustomerDTO customerDTO){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDTO);
    }

    public void updateCustomer(UUID id, CustomerDTO customerDTO){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + id.toString(), customerDTO);
    }

    public void deleteCustomer(UUID id){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + id.toString());
    }
}
