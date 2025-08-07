package test.supplies.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.supplies.dto.WaybillDto;
import test.supplies.exception.ObjectNotFoundException;
import test.supplies.mapper.WaybillMapper;
import test.supplies.model.Passport;
import test.supplies.repository.PassportRepository;
import test.supplies.repository.WaybillRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WaybillService implements SuppliesService<WaybillDto> {
    private final WaybillRepository waybillRepository;
    private final PassportRepository passportRepository;

    @Override
    public WaybillDto add(WaybillDto waybillDto) {
        Passport passport = passportRepository.findById(waybillDto.getUin()).orElseThrow(() ->
                new ObjectNotFoundException("Passport not found"));
        return WaybillMapper.toWaybillDto(waybillRepository.save(WaybillMapper.toWaybill(waybillDto, passport)));
    }

    @Override
    @Transactional(readOnly = true)
    public WaybillDto get(Integer id) {
        return WaybillMapper.toWaybillDto(waybillRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Waybill not found")));
    }

    @Override
    public WaybillDto update(Integer id, WaybillDto waybillDto) {
        Passport passport = passportRepository.findById(waybillDto.getUin()).orElseThrow(() ->
                new ObjectNotFoundException("Passport not found"));
        waybillRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Waybill not found"));
        waybillDto.setId(id);
        return WaybillMapper.toWaybillDto(waybillRepository.save(WaybillMapper.toWaybill(waybillDto, passport)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WaybillDto> getAll() {
        return waybillRepository.findAll().stream().map(WaybillMapper :: toWaybillDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
       get(id);
       waybillRepository.deleteById(id);
    }
}
