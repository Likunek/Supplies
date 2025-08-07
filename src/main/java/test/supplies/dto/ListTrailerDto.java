package test.supplies.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListTrailerDto {
    private Integer id;
    @NotNull
    private Integer idTrailer;
    @NotNull
    private double cargoVolume;
    @NotNull
    private Integer idWaybill;
}
