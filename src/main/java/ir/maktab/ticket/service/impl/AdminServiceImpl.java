package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.base.service.impl.BaseServiceImpl;
import ir.maktab.ticket.domain.Admin;
import ir.maktab.ticket.repository.AdminRepository;
import ir.maktab.ticket.service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository> implements AdminService {
    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

}
