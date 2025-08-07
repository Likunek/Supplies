package test.supplies.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WaybillDto {
    private Integer id;
    @NotNull
    private Integer uin;
    @NotNull
    private String data;
    @NotNull
    private String dateOfIssue;
    @NotNull
    private String dateOfDelivery;
    @NotNull
    private String timeBegin;
    @NotNull
    private String timeEnd;

    private double workTime;

    private double downtime;

    private double downtimeForThoseReasons;

    private double downtimeDueToLoading;

    private double exitSpeed;

    private double entranceSpeed;

    private String fuelType;

    private double fuelQuantityAtDeparture;

    private double fuelIssued;

    private double fuelDeposited;

    private double fuelQuantityAtEntrance;

    private double CargoVolume;

    private double totalTransportedCargoVolume;
}
