package application.controller;

import application.entities.GenericEntity;
import application.repositories.GenericRepository;
import application.utilities.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T extends GenericEntity<T>> {


    private final Class<T> type;
    private GenericRepository<T> repository;

    public GenericController(GenericRepository<T> repository, Class<T> type) {
        this.repository = repository;
        this.type = type;
    }

    @GetMapping("/{id}")
    public T getOne(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id , type));
    }

    @GetMapping("")
    public List<T> getAllEntities() {
        return repository.findAll();
    }

    @PostMapping("")
    public T newEntitiy (@RequestBody T entity) {
        return repository.save(entity);
    }
    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public T save(T entity) {
        return repository.save(entity);
    }
}
