package test.supplies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.supplies.dto.WaybillDto;
import test.supplies.service.WaybillService;

import java.util.List;

@RestController
@RequestMapping(path = "/supplies/waybill")
public class WaybillController implements Controller<WaybillDto> {

    WaybillService waybillService;

    public WaybillController(WaybillService waybillService) {
        this.waybillService = waybillService;
    }

    @Override
    public WaybillDto add(WaybillDto waybillDto) {
        return waybillService.add(waybillDto);
    }

    @Override
    public WaybillDto get(Integer id) {
        return waybillService.get(id);
    }

    @Override
    public WaybillDto update(Integer id, WaybillDto waybillDto) {
        return waybillService.update(id, waybillDto);
    }

    @Override
    public List<WaybillDto> getAll() {
        return waybillService.getAll();
    }

    @Override
    public void delete(Integer id) {
        waybillService.delete(id);
    }
}
