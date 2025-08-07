package test.supplies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.supplies.dto.PassportDto;
import test.supplies.dto.TransportDto;
import test.supplies.service.PassportService;

import java.util.List;

@RestController
@RequestMapping(path = "/supplies/passport")
public class TransportController implements Controller<PassportDto>{

    PassportService passportService;

    public TransportController( PassportService passportService) {this.passportService = passportService;}

    @Override
    public PassportDto add(PassportDto passportDto) {
        return passportService.add(passportDto);
    }

    @Override
    public PassportDto get(Integer id) {
        return passportService.get(id);
    }

    @GetMapping("transport/{id}")
    public TransportDto getTransport(@PathVariable Integer id) {
        return passportService.getTransport(id);
    }

    @Override
    public PassportDto update(Integer id, PassportDto passportDto) {
        return passportService.update(id, passportDto);
    }

    @Override
    public List<PassportDto> getAll() {
        return passportService.getAll();
    }

    @Override
    public void delete(Integer id) {
       passportService.delete(id);
    }
}
