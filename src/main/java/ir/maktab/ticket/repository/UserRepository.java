package ir.maktab.ticket.repository;


import ir.maktab.ticket.base.repository.BaseRepository;
import ir.maktab.ticket.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {
    User getUserByUsername(String username);
}
