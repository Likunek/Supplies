package test.supplies.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeDto {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Integer view;
    @NotNull
    private String sign;
}
