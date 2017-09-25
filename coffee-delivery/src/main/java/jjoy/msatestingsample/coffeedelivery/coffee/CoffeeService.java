package jjoy.msatestingsample.coffeedelivery.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CoffeeService {

    private RestTemplate restTemplate;

    @Value(value="${msa.gateway}")
    private String gateway;

    @Autowired
    public CoffeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Coffee> getCoffeeList(){
        return Arrays.asList(new Coffee("Americano")
                , new Coffee("Caffee Latte")
                , new Coffee("Esspresso"));
    }

    public MorningCombo getMornigCombo() {

        Coffee coffee = new Coffee("Americano");
        ResponseEntity<Bread> breadResponseEntity = restTemplate.exchange(gateway + "/bread/bagel", HttpMethod.GET, null, Bread.class);
        Bread bread = breadResponseEntity.getBody();

        return new MorningCombo(coffee, bread);
    }
}
