package one.digitalinnovation.cloudparking.controller;

import one.digitalinnovation.cloudparking.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @GetMapping
    public List<Parking> findAll() {
        var parking = new Parking();
        parking.setColor("Preto");
        parking.setLicense("MSA-1234");
        parking.setModel("Ford Focus");
        parking.setState("MG");

        return Arrays.asList(parking, parking);
    }

}
