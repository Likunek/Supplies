package test.supplies.mapper;

import test.supplies.dto.TypeDto;
import test.supplies.model.Type;
import test.supplies.model.View;

public class TypeMapper {
    static public Type toType(TypeDto typeDto, View view) {
        Type type = new Type();
        type.setId(typeDto.getId());
        type.setName(typeDto.getName());
        type.setView(view);
        type.setSign(typeDto.getSign());
        return type;
    }

    static public TypeDto toTypeDto(Type type) {
        return TypeDto
                .builder()
                .id(type.getId())
                .name(type.getName())
                .view(type.getView().getId())
                .sign(type.getSign())
                .build();
    }
}
