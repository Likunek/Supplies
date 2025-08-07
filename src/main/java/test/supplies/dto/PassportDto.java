package test.supplies.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassportDto {
    private Integer id;
    @NotNull
    private String number;
    private int type;
    private int firm;
    @NotNull
    private double tonnage;
    @NotNull
    private double normExpense;
    private String dateEnd;
}

