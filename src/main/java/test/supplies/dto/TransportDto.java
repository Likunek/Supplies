package test.supplies.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransportDto {
    private String firm;
    private String type;
    private String view;
    private PassportDto passport;
}
