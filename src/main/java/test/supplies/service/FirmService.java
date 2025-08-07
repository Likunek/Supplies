package test.supplies.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.supplies.dto.FirmDto;
import test.supplies.exception.ObjectNotFoundException;
import test.supplies.mapper.FirmMapper;
import test.supplies.repository.FirmRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FirmService implements SuppliesService<FirmDto> {

    private final FirmRepository firmRepository;

    @Override
    public FirmDto add(FirmDto firmDto) {
        return FirmMapper.toFirmDto(firmRepository.save(FirmMapper.toFirm(firmDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public FirmDto get(Integer id) {
        return FirmMapper.toFirmDto(firmRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Firm not found")));
    }

    @Override
    public FirmDto update(Integer id, FirmDto firmDto) {
        firmRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Firm not found"));
        firmDto.setId(id);
        return FirmMapper.toFirmDto(firmRepository.save(FirmMapper.toFirm(firmDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FirmDto> getAll() {
        return firmRepository.findAll().stream().map(FirmMapper :: toFirmDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        get(id);
        firmRepository.deleteById(id);
    }
}