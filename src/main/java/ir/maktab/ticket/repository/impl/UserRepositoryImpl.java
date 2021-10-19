package ir.maktab.ticket.repository.impl;


import ir.maktab.ticket.base.repository.BaseRepositoryImpl;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.User;
import ir.maktab.ticket.repository.UserRepository;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery(
                "FROM User u WHERE u.username = :username", User.class
        ).setParameter("username", username).getSingleResult();
    }
}
