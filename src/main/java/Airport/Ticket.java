package Airport;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID")
    private Passenger passenger;

    public Ticket() {
    }

    public Ticket(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


}
