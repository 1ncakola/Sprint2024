package aircraft;

import airport.Airport;
import jakarta.persistence.*;
import passager.Passenger;

import java.util.List;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String airlineName;
    private int numberOfPassengers;

    @ManyToMany (mappedBy = "aircraft")
    private List<Passenger> passenger;

    @ManyToMany
    @JoinTable(
            name = "aircraft_airport",
            joinColumns = @JoinColumn(name = "aircraft_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airports;

    public Aircraft(Long id, String name, String airlineName,
                    int numberOfPassengers, List<Passenger> passenger, List<Airport> airports) {
        this.id = id;
        this.name = name;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
        this.passenger = passenger;
        this.airports = airports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public List<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
