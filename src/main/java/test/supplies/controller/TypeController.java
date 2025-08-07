package test.supplies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.supplies.dto.TypeDto;
import test.supplies.service.TypeService;

import java.util.List;

@RestController
@RequestMapping(path = "/supplies/type")
public class TypeController implements Controller<TypeDto> {

    TypeService typeService;
    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public TypeDto add(TypeDto typeDto) {
        return typeService.add(typeDto);
    }

    @Override
    public TypeDto get(Integer id) {
        return typeService.get(id);
    }

    @Override
    public TypeDto update(Integer id, TypeDto typeDto) {
        return typeService.update(id, typeDto);
    }

    @Override
    public List<TypeDto> getAll() {
        return typeService.getAll();
    }

    @Override
    public void delete(Integer id) {
       typeService.delete(id);
    }
}
