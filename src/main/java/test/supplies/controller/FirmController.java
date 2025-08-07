package test.supplies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.supplies.dto.FirmDto;
import test.supplies.service.FirmService;

import java.util.List;

@RestController
@RequestMapping(path = "/supplies/firm")
public class FirmController implements Controller<FirmDto> {
    FirmService firmService;
    @Autowired
    public FirmController(FirmService firmService) {
        this.firmService = firmService;
    }

    @Override
    public FirmDto add(FirmDto firmDto) {
        return firmService.add(firmDto);
    }

    @Override
    public FirmDto get(Integer id) {
        return firmService.get(id);
    }

    @Override
    public FirmDto update(Integer id, FirmDto firmDto) {
        return firmService.update(id, firmDto);
    }

    @Override
    public List<FirmDto> getAll() {
        return firmService.getAll();
    }

    @Override
    public void delete(Integer id) {
        firmService.delete(id);
    }

}
