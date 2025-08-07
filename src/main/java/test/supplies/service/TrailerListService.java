package test.supplies.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.supplies.dto.ListTrailerDto;
import test.supplies.exception.ObjectNotFoundException;
import test.supplies.mapper.TrailerListMapper;
import test.supplies.model.Passport;
import test.supplies.model.Waybill;
import test.supplies.repository.PassportRepository;
import test.supplies.repository.TrailerListRepository;
import test.supplies.repository.WaybillRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrailerListService implements SuppliesService<ListTrailerDto> {
    private final TrailerListRepository trailerListRepository;
    public final PassportRepository passportRepository;
    private final WaybillRepository waybillRepository;

    @Override
    public ListTrailerDto add(ListTrailerDto listTrailerDto) {
        Passport passport = passportRepository.findById(listTrailerDto.getIdTrailer()).orElseThrow(() ->
                new ObjectNotFoundException("Passport not found"));
        Waybill waybill = waybillRepository.findById(listTrailerDto.getIdWaybill()).orElseThrow(() ->
                new ObjectNotFoundException("Waybill not found"));
        return TrailerListMapper.toListTrailerDto(trailerListRepository
                .save(TrailerListMapper.toListTrailer(listTrailerDto, passport, waybill)));
    }

    @Override
    @Transactional(readOnly = true)
    public ListTrailerDto get(Integer id) {
        return TrailerListMapper.toListTrailerDto(trailerListRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("TrailerList not found")));
    }

    @Override
    public ListTrailerDto update(Integer id, ListTrailerDto listTrailerDto) {
        Passport passport = passportRepository.findById(listTrailerDto.getIdTrailer()).orElseThrow(() ->
                new ObjectNotFoundException("Passport not found"));
        Waybill waybill = waybillRepository.findById(listTrailerDto.getIdWaybill()).orElseThrow(() ->
                new ObjectNotFoundException("Waybill not found"));
        trailerListRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("TrailerList not found"));
        listTrailerDto.setId(id);
        return TrailerListMapper.toListTrailerDto(trailerListRepository
                .save(TrailerListMapper.toListTrailer(listTrailerDto, passport, waybill)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListTrailerDto> getAll() {
        return trailerListRepository.findAll().stream().map(TrailerListMapper :: toListTrailerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
       get(id);
       trailerListRepository.deleteById(id);
    }
}
