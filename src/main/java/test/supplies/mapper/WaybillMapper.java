package test.supplies.mapper;

import test.supplies.dto.WaybillDto;
import test.supplies.model.Passport;
import test.supplies.model.Waybill;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WaybillMapper {
    static public Waybill toWaybill(WaybillDto waybillDto, Passport passport) {
        Waybill waybill = new Waybill();
        waybill.setId(waybillDto.getId());
        waybill.setPts(passport);
        waybill.setData(waybillDto.getData());
        waybill.setDateOfIssue(LocalDate.parse(waybillDto.getDateOfIssue(), DateTimeFormatter.ofPattern("yyyy.MM.dd")));
        waybill.setDateOfDelivery(LocalDate.parse(waybillDto.getDateOfDelivery(), DateTimeFormatter.ofPattern("yyyy.MM.dd")));
        waybill.setTimeBegin(LocalTime.parse(waybillDto.getTimeBegin(), DateTimeFormatter.ofPattern("h[:mm]a")));
        waybill.setTimeEnd(LocalTime.parse(waybillDto.getTimeEnd(), DateTimeFormatter.ofPattern("h[:mm]a")));
        waybill.setWorkTime(waybillDto.getWorkTime());
        waybill.setDowntime(waybillDto.getDowntime());
        waybill.setDowntimeForThoseReasons(waybillDto.getDowntimeForThoseReasons());
        waybill.setDowntimeDueToLoading(waybillDto.getDowntimeDueToLoading());
        waybill.setExitSpeed(waybillDto.getExitSpeed());
        waybill.setEntranceSpeed(waybillDto.getEntranceSpeed());
        waybill.setFuelType(waybillDto.getFuelType());
        waybill.setFuelQuantityAtDeparture(waybillDto.getFuelQuantityAtDeparture());
        waybill.setFuelIssued(waybillDto.getFuelIssued());
        waybill.setFuelDeposited(waybillDto.getFuelDeposited());
        waybill.setFuelQuantityAtEntrance(waybillDto.getFuelQuantityAtEntrance());
        waybill.setCargoVolume(waybillDto.getCargoVolume());
        waybill.setTotalTransportedCargoVolume(waybillDto.getTotalTransportedCargoVolume());
        return waybill;
    }

    static public WaybillDto toWaybillDto(Waybill waybill) {
        return WaybillDto
                .builder()
                .id(waybill.getId())
                .uin(waybill.getPts().getId())
                .data(waybill.getData())
                .dateOfIssue(waybill.getDateOfIssue().toString())
                .dateOfDelivery(waybill.getDateOfDelivery().toString())
                .timeBegin(waybill.getTimeBegin().toString())
                .timeEnd(waybill.getTimeEnd().toString())
                .workTime(waybill.getWorkTime())
                .downtime(waybill.getDowntime())
                .downtimeForThoseReasons(waybill.getDowntimeForThoseReasons())
                .downtimeDueToLoading(waybill.getDowntimeDueToLoading())
                .exitSpeed(waybill.getExitSpeed())
                .entranceSpeed(waybill.getEntranceSpeed())
                .fuelType(waybill.getFuelType())
                .fuelQuantityAtDeparture(waybill.getFuelQuantityAtDeparture())
                .fuelIssued(waybill.getFuelIssued())
                .fuelDeposited(waybill.getFuelDeposited())
                .fuelQuantityAtEntrance(waybill.getFuelQuantityAtEntrance())
                .CargoVolume(waybill.getCargoVolume())
                .totalTransportedCargoVolume(waybill.getTotalTransportedCargoVolume())
                .build();
    }
}
