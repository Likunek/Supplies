package test.supplies.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViewDto {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String fullName;
}
