package no.hvl.dat108.h23.g38.obl4.service;

import no.hvl.dat108.h23.g38.obl4.model.ModelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class AbstractService<Entity extends ModelEntity<ID>, ID> {

    protected final CrudRepository<Entity, ID> repository;

    protected AbstractService(CrudRepository<Entity, ID> repository) {
        this.repository = repository;
    }

    public Optional<Entity> readById(ID id) {
        return repository.findById(id);
    }

    public Iterable<Entity> readAll() {
        return repository.findAll();
    }

    public Entity create(Entity entity) throws EntityStateException {
        if (repository.findById(entity.getID()).isPresent())
            throw new EntityStateException("Entity " + entity + " already exists");

        return repository.save(entity);
    }

    public Entity update(Entity entity) throws EntityStateException {
        if (repository.findById(entity.getID()).isEmpty())
            throw new EntityStateException("Entity " + entity + " does not exist");

        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
