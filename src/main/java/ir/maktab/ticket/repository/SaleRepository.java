package ir.maktab.ticket.repository;

import ir.maktab.ticket.base.repository.BaseRepository;
import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.domain.Sale;

public interface SaleRepository extends BaseRepository<Sale, Long> {
    Sale findFlightSale(Flight flight);
}
