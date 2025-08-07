package test.supplies.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SuppliesService<T> {
    @Transactional
    public T add(T t);
    @Transactional
    public T get(Integer id);
    @Transactional
    public T update(Integer id, T t);
    @Transactional
    public List<T> getAll();
    @Transactional
    public void delete(Integer id);
}
