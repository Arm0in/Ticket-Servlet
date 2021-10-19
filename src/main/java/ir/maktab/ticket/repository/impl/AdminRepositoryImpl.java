package ir.maktab.ticket.repository.impl;



import ir.maktab.ticket.base.repository.BaseRepositoryImpl;
import ir.maktab.ticket.domain.Admin;
import ir.maktab.ticket.repository.AdminRepository;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long> implements AdminRepository {

    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
