package test.supplies.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Controller<T> {
    @PostMapping
    public T add(@Valid @RequestBody T t);
    @GetMapping("/{id}")
    public T get(@PathVariable Integer id);
    @PatchMapping("/{id}")
    public T update(@PathVariable Integer id, @Valid @RequestBody T t);
    @GetMapping
    public List<T> getAll();
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id);
}
