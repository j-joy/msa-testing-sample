package jjoy.msatestingsample.bakeryservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BakeryServiceController {

    @GetMapping(value = "/bread/{breadName}")
    public Bread bread(@PathVariable String breadName){
        return new Bread(breadName);
    }
}
