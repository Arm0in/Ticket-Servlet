package ir.maktab.ticket.base.service.impl;


import ir.maktab.ticket.base.domain.BaseEntity;
import ir.maktab.ticket.base.repository.BaseRepository;
import ir.maktab.ticket.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>,
        ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        repository.getEntityManager().getTransaction().begin();
        e = repository.save(e);
        repository.getEntityManager().getTransaction().commit();
        return e;
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(E e) {
        repository.getEntityManager().getTransaction().begin();
        repository.delete(e);
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }
}
