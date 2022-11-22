package one.digitalinnovation.cloudparking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDto;
import one.digitalinnovation.cloudparking.controller.dto.ParkingDto;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDto>> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDto> result = parkingMapper.toParkingDtoList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find by ID")
    public ResponseEntity<ParkingDto> findById(@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        ParkingDto result = parkingMapper.toParkingDto(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ParkingDto> create(@RequestBody ParkingCreateDto parkingDto) {
        var parkingCreate = parkingMapper.toParkingCreate(parkingDto);
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDto(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
