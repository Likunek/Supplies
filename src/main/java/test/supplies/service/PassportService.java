package test.supplies.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.supplies.dto.PassportDto;
import test.supplies.dto.TransportDto;
import test.supplies.exception.ObjectNotFoundException;
import test.supplies.mapper.PassportMapper;
import test.supplies.model.Firm;
import test.supplies.model.Passport;
import test.supplies.model.Type;
import test.supplies.model.View;
import test.supplies.repository.FirmRepository;
import test.supplies.repository.PassportRepository;
import test.supplies.repository.TypeRepository;
import test.supplies.repository.ViewRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassportService implements SuppliesService<PassportDto> {
    private final PassportRepository passportRepository;
    private final FirmRepository firmRepository;
    private final TypeRepository typeRepository;
    private final ViewRepository viewRepository;

    @Override
    public PassportDto add(PassportDto passportDto) {
        Firm firm = firmRepository.findById(passportDto.getFirm()).orElseThrow(() ->
                new ObjectNotFoundException("Firm not found"));
        Type type = typeRepository.findById(passportDto.getType()).orElseThrow(() ->
                new ObjectNotFoundException("Type not found"));
        return PassportMapper.toPassportDto(passportRepository.save(PassportMapper.toPassport(passportDto, type, firm)));
    }

    @Override
    @Transactional(readOnly = true)
    public PassportDto get(Integer id) {
       return PassportMapper.toPassportDto(passportRepository.findById(id).orElseThrow(() ->
               new ObjectNotFoundException("Passport not found")));
    }

    public TransportDto getTransport(Integer id) {
        Passport passport = passportRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Passport not found"));
        Firm firm = firmRepository.findById(passport.getFirm().getId()).orElseThrow(() ->
                new ObjectNotFoundException("Firm not found"));
        Type type = typeRepository.findById(passport.getType().getId()).orElseThrow(() ->
                new ObjectNotFoundException("Type not found"));
        View view = viewRepository.findById(type.getView().getId()).orElseThrow(() ->
                new ObjectNotFoundException("View not found"));
        return PassportMapper.toTransport(PassportMapper.toPassportDto(passport), firm, type, view);
    }

    @Override
    public PassportDto update(Integer id, PassportDto passportDto) {
        Firm firm = firmRepository.findById(passportDto.getFirm()).orElseThrow(() ->
                new ObjectNotFoundException("Firm not found"));
        Type type = typeRepository.findById(passportDto.getType()).orElseThrow(() ->
                new ObjectNotFoundException("Type not found"));
        passportRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Passport not found"));
        passportDto.setId(id);
        return PassportMapper.toPassportDto(passportRepository.save(PassportMapper.toPassport(passportDto, type, firm)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PassportDto> getAll() {
        return passportRepository.findAll().stream().map(PassportMapper :: toPassportDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        get(id);
        passportRepository.deleteById(id);
    }
}
