package test.supplies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.supplies.dto.ViewDto;
import test.supplies.service.ViewService;

import java.util.List;

@RestController
@RequestMapping(path = "/supplies/view")
public class ViewController implements Controller<ViewDto> {

    ViewService viewService;
    @Autowired
    public ViewController( ViewService viewService) {
        this.viewService = viewService;
    }

    @Override
    public ViewDto add(ViewDto viewDto) {
        return viewService.add(viewDto);
    }

    @Override
    public ViewDto get(Integer id) {
        return viewService.get(id);
    }

    @Override
    public ViewDto update(Integer id, ViewDto viewDto) {
        return viewService.update(id, viewDto);
    }

    @Override
    public List<ViewDto> getAll() {
        return viewService.getAll();
    }

    @Override
    public void delete(Integer id) {
       viewService.delete(id);
    }
}
