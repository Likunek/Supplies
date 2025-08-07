package test.supplies.mapper;

import test.supplies.dto.ViewDto;
import test.supplies.model.View;

public class ViewMapper {
    static public View toView(ViewDto viewDto) {
        View view = new View();
        view.setId(view.getId());
        view.setName(viewDto.getName());
        view.setFullName(viewDto.getFullName());
        return view;
    }

    static public ViewDto toViewDto(View view) {
        return ViewDto
                .builder()
                .id(view.getId())
                .name(view.getName())
                .fullName(view.getFullName())
                .build();
    }
}
