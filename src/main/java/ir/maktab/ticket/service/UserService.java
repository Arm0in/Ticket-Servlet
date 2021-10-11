package ir.maktab.ticket.service;

import ir.maktab.ticket.base.service.BaseService;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.User;

public interface UserService extends BaseService<User, Long> {

    User getUserByUsername(String username);

    void login(String username, String password);
}
