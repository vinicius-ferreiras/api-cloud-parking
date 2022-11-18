package one.digitalinnovation.cloudparking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping
    public String Hello() {
        return "Hello World DIO";
    }

}
