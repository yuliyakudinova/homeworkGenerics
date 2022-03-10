package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tickets implements Comparable<Tickets>{
    private int id;
    private int price;
    private String departureAirport;
    private  String arrivalAirport;
    private int flightTime;

    @Override
    public int compareTo(Tickets o) {
        return id - o.id;
    }
}
