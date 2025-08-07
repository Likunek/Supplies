package test.supplies.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.supplies.dto.TypeDto;
import test.supplies.exception.ObjectNotFoundException;
import test.supplies.mapper.TypeMapper;
import test.supplies.model.View;
import test.supplies.repository.TypeRepository;
import test.supplies.repository.ViewRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeService implements SuppliesService<TypeDto> {

    private final TypeRepository typeRepository;
    private final ViewRepository viewRepository;

    @Override
    public TypeDto add(TypeDto typeDto) {
        View view = viewRepository.findById(typeDto.getView()).orElseThrow(() ->
                new ObjectNotFoundException("View not found"));
        return TypeMapper.toTypeDto(typeRepository.save(TypeMapper.toType(typeDto, view)));
    }

    @Override
    @Transactional(readOnly = true)
    public TypeDto get(Integer id) {
        return TypeMapper.toTypeDto(typeRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Type not found")));
    }

    @Override
    public TypeDto update(Integer id, TypeDto typeDto) {
        View view = viewRepository.findById(typeDto.getView()).orElseThrow(() ->
                new ObjectNotFoundException("View not found"));
        typeRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Type not found"));
        typeDto.setId(id);
        return TypeMapper.toTypeDto(typeRepository.save(TypeMapper.toType(typeDto, view)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeDto> getAll() {
        return typeRepository.findAll().stream().map(TypeMapper :: toTypeDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
         get(id);
         viewRepository.deleteById(id);
    }
}
