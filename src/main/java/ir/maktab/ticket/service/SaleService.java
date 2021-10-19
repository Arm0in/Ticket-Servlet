package ir.maktab.ticket.service;


import ir.maktab.ticket.base.service.BaseService;
import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.domain.Sale;

public interface SaleService extends BaseService<Sale, Long> {
    Sale findFlightSale(Flight flight);
}
