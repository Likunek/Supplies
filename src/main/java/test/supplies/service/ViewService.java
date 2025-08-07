package test.supplies.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.supplies.dto.ViewDto;
import test.supplies.exception.ObjectNotFoundException;
import test.supplies.mapper.ViewMapper;
import test.supplies.repository.ViewRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ViewService implements SuppliesService<ViewDto> {

    private final ViewRepository viewRepository;

    @Override
    public ViewDto add(ViewDto viewDto) {
        return ViewMapper.toViewDto(viewRepository.save(ViewMapper.toView(viewDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public ViewDto get(Integer id) {
        return ViewMapper.toViewDto(viewRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("View not found")));
    }

    @Override
    public ViewDto update(Integer id, ViewDto viewDto) {
        viewRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("View not found"));
        viewDto.setId(id);
        return ViewMapper.toViewDto(viewRepository.save(ViewMapper.toView(viewDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ViewDto> getAll() {
        return viewRepository.findAll().stream().map(ViewMapper:: toViewDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        get(id);
        viewRepository.deleteById(id);
    }
}
