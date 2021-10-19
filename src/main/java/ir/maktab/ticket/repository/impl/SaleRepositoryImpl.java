package ir.maktab.ticket.repository.impl;

import ir.maktab.ticket.base.repository.BaseRepositoryImpl;
import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.domain.Sale;
import ir.maktab.ticket.repository.SaleRepository;

import javax.persistence.EntityManager;

public class SaleRepositoryImpl extends BaseRepositoryImpl<Sale, Long> implements SaleRepository {

    public SaleRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Sale> getEntityClass() {
        return Sale.class;
    }

    @Override
    public Sale findFlightSale(Flight flight) {
        return entityManager.createQuery(
                "FROM Sale s WHERE s.flight = :flightId", Sale.class
        ).setParameter("flightId", flight).getSingleResult();
    }
}
