package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.base.service.impl.BaseServiceImpl;
import ir.maktab.ticket.domain.AirLine;
import ir.maktab.ticket.repository.AirLineRepository;
import ir.maktab.ticket.service.AirLineService;

public class AirLineServiceImpl extends BaseServiceImpl<AirLine, Long, AirLineRepository> implements AirLineService {
    public AirLineServiceImpl(AirLineRepository repository) {
        super(repository);
    }

}
