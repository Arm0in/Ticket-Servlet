package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.base.service.impl.BaseServiceImpl;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.User;
import ir.maktab.ticket.repository.UserRepository;
import ir.maktab.ticket.service.UserService;
import ir.maktab.ticket.util.SecurityContext;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }

    @Override
    public void login(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                SecurityContext.setCurrentUser(user);
            } else {
                throw new RuntimeException("Wrong Password!!!");
            }
        } else {
            throw new RuntimeException("not found!!!");
        }
    }

}
