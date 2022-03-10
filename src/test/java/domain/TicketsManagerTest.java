package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {

    private final TicketsRepository repository = new TicketsRepository();
    private final TicketsManager manager = new TicketsManager(repository);

    private final Tickets first = new Tickets(111, 6300, "VOZ", "SVO", 120);
    private final Tickets second = new Tickets(112, 10200, "KZN", "VKO", 200);
    private final Tickets third = new Tickets(113, 58400, "GDZ", "VVO", 620);
    private final Tickets fourth = new Tickets(114, 12800, "IWA", "IKT", 380);
    private final Tickets fifth = new Tickets(115, 24000, "VOZ", "SVO", 130);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void searchBySomeTickets() {
        Tickets[] expected = new Tickets[]{first, fifth};
        Tickets[] actual = manager.searchBy("VOZ", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByOneTicket() {
        Tickets[] expected = new Tickets[]{third};
        Tickets[] actual = manager.searchBy("GDZ", "VVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNoOne() {
        Tickets[] expected = new Tickets[]{};
        Tickets[] actual = manager.searchBy("IWA", "VOZ");
        assertArrayEquals(expected, actual);
    }


}