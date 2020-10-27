package com.taranenkoant.msscbreweryclient.web.client;

import com.taranenkoant.msscbreweryclient.web.client.BreweryClient;
import com.taranenkoant.msscbreweryclient.web.model.BeerDTO;
import com.taranenkoant.msscbreweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDTO dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDTO beerDTO = BeerDTO.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(beerDTO);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer(){
        BeerDTO beerDTO = BeerDTO.builder().beerName("New Beer").build();

        client.updateBeer(UUID.randomUUID(), beerDTO);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerByIdTes(){
        CustomerDTO customerDTO = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
    }

    @Test
    void saveNewCustomerTest(){
        CustomerDTO customerDTO = CustomerDTO.builder().name("Ron Whisle").build();

        URI uri = client.saveNewCustomer(UUID.randomUUID(), customerDTO);
        assertNotNull(uri);
    }

    @Test
    void updateCustomerTest(){
        CustomerDTO customerDTO = CustomerDTO.builder().name("Ron Whisle").build();

        client.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void deleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}