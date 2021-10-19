package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.base.service.impl.BaseServiceImpl;
import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.domain.Sale;
import ir.maktab.ticket.repository.SaleRepository;
import ir.maktab.ticket.service.SaleService;

public class SaleServiceImpl extends BaseServiceImpl<Sale, Long, SaleRepository> implements SaleService {
    public SaleServiceImpl(SaleRepository repository) {
        super(repository);
    }

    @Override
    public Sale findFlightSale(Flight flight) {
        return repository.findFlightSale(flight);
    }
}
