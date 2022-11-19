package one.digitalinnovation.cloudparking.controller.mapper;

import one.digitalinnovation.cloudparking.controller.dto.ParkingDto;
import one.digitalinnovation.cloudparking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDto parkingDto(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDto.class);
    }

    public List<ParkingDto> toParkingDtoList(List<Parking> parkingList) {
        return parkingList.stream().map(this::parkingDto).collect(Collectors.toList());
    }
}
