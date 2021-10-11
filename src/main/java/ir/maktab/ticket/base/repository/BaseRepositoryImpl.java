package ir.maktab.ticket.base.repository;


import ir.maktab.ticket.base.domain.BaseEntity;


import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable>
        implements BaseRepository<E, ID> {

    protected final EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract Class<E> getEntityClass();


    @Override
    public E save(E e) {
        if (e.getId() == null) {
            entityManager.persist(e);
            return e;
        } else {
            return entityManager.merge(e);
        }
    }

    @Override
    public E findById(ID id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery(
                "from " + getEntityClass().getSimpleName(),
                getEntityClass()
        ).getResultList();
    }

    @Override
    public void delete(E e) {
        entityManager.remove(e);
    }

    @Override
    public boolean existsById(ID id) {
        return entityManager.createQuery(
                "select count(e.id) from " + getEntityClass().getSimpleName() +
                        "as e where e.id = :id",
                Long.class
        ).setParameter("id", id)
                .getSingleResult() == 1L;
    }

    @Override
    public Long countAll() {
        return entityManager.createQuery(
                "select count(e.id) from " + getEntityClass().getSimpleName() + "as e",
                Long.class
        ).getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
