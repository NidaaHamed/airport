import Airport.Airport;
import Airport.Passenger;
import Airport.Ticket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Airport airport = new Airport(1, "Cairo");

        Passenger ahmed = new Passenger(1, "Ahmed Mahmoud");
        ahmed.setAirport(airport);

        Passenger mostafa = new Passenger(2, "Mostafa Mahmoud");
        mostafa.setAirport(airport);

        airport.addPassenger(ahmed);
        airport.addPassenger(mostafa);

        Ticket ticket1 = new Ticket(1, "aa1234");
        ticket1.setPassenger(ahmed);

        Ticket ticket2 = new Ticket(2, "bb5678");
        ticket2.setPassenger(ahmed);

        ahmed.addTicket(ticket1);
        ahmed.addTicket(ticket2);

        Ticket ticket3 = new Ticket(3, "cc0987");
        ticket3.setPassenger(mostafa);
        mostafa.addTicket(ticket3);

        em.persist(airport);
        em.persist(ahmed);
        em.persist(mostafa);

        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);

        em.getTransaction().commit();

        emf.close();


    }
}
