package test.supplies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.supplies.dto.ListTrailerDto;
import test.supplies.service.TrailerListService;

import java.util.List;

@RestController
@RequestMapping(path = "/supplies/trailer")
public class TrailerListController implements Controller<ListTrailerDto> {

    TrailerListService trailerListService;
    public  TrailerListController( TrailerListService trailerListService) {this.trailerListService = trailerListService;}
    @Override
    public ListTrailerDto add(ListTrailerDto listTrailerDto) {
        return trailerListService.add(listTrailerDto);
    }

    @Override
    public ListTrailerDto get(Integer id) {
        return trailerListService.get(id);
    }

    @Override
    public ListTrailerDto update(Integer id, ListTrailerDto listTrailerDto) {
        return trailerListService.update(id, listTrailerDto);
    }

    @Override
    public List<ListTrailerDto> getAll() {
        return trailerListService.getAll();
    }

    @Override
    public void delete(Integer id) {
        trailerListService.delete(id);
    }
}
