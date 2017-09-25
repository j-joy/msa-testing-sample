package jjoy.msatestingsample.coffeedelivery.rest;

import jjoy.msatestingsample.coffeedelivery.coffee.Coffee;
import jjoy.msatestingsample.coffeedelivery.coffee.CoffeeService;
import jjoy.msatestingsample.coffeedelivery.coffee.MorningCombo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CoffeeDeliveryController {

    private CoffeeService coffeeService;

    @Autowired
    public CoffeeDeliveryController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping(value="/coffees")
    public List<Coffee> getCoffeeList(){
        return Arrays.asList(new Coffee("Americano")
                , new Coffee("Caffee Latte")
                , new Coffee("Esspresso"));
    }

    @GetMapping(value = "/morningCombo")
    public MorningCombo getMorningCombo(){
        return coffeeService.getMornigCombo();
    }
}
