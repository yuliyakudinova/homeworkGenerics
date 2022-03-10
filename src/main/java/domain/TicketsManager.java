package domain;

import repository.TicketsRepository;

public class TicketsManager {

    private TicketsRepository repository;

    public TicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public void add(Tickets tickets) {
        repository.save(tickets);
    }

    public Tickets[] searchBy(String departureAirport, String arrivalAirport) {
        Tickets[] result = new Tickets[0];
        for (Tickets tickets : repository.findAll()) {
            if (tickets.getDepartureAirport().equals(departureAirport) && tickets.getArrivalAirport().equals(arrivalAirport)) {
                int lenght = result.length + 1;
                Tickets[] tmp = new Tickets[lenght];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = tickets;
                result = tmp;
            }
        }
        return result;
    }

}

