package ir.maktab.ticket.repository.impl;



import ir.maktab.ticket.base.repository.BaseRepositoryImpl;
import ir.maktab.ticket.domain.AirLine;
import ir.maktab.ticket.repository.AirLineRepository;

import javax.persistence.EntityManager;

public class AirLineRepositoryImpl extends BaseRepositoryImpl<AirLine, Long> implements AirLineRepository {

    public AirLineRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<AirLine> getEntityClass() {
        return AirLine.class;
    }

    @Override
    public AirLine getAirLineByUsername(String username) {
        return entityManager.createQuery(
                "FROM AirLine a WHERE a.username = :username", AirLine.class
        ).setParameter("username", username).getSingleResult();
    }
}
