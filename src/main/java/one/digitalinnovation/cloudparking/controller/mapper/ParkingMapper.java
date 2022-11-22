package one.digitalinnovation.cloudparking.controller.mapper;

import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDto;
import one.digitalinnovation.cloudparking.controller.dto.ParkingDto;
import one.digitalinnovation.cloudparking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDto toParkingDto(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDto.class);
    }

    public List<ParkingDto> toParkingDtoList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingDto).collect(Collectors.toList());
    }

    public Parking toParking(ParkingDto parkingDto) {
        return MODEL_MAPPER.map(parkingDto, Parking.class);
    }

    public Parking toParkingCreate(ParkingCreateDto parkingDto) {
        return MODEL_MAPPER.map(parkingDto, Parking.class);
    }
}
