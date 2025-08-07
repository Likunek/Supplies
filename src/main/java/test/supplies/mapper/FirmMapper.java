package test.supplies.mapper;

import test.supplies.dto.FirmDto;
import test.supplies.model.Firm;

public class FirmMapper {

    static public Firm toFirm(FirmDto firmDto) {
        Firm firm = new Firm();
        firm.setId(firmDto.getId());
        firm.setName(firmDto.getName());
        firm.setLocation(firmDto.getLocation());
        return firm;
    }

    static public FirmDto toFirmDto(Firm firm) {
        return FirmDto
                .builder()
                .id(firm.getId())
                .name(firm.getName())
                .location(firm.getLocation())
                .build();
    }
}
