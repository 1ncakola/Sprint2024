package passager;

import aircraft.Aircraft;
import city.City;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn (name = "city_id")
    private City city;

    @ManyToOne
    @JoinTable(
            name = "passenger_aircraft",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    private List<Aircraft> aircraft;


    public Passenger(Long id, String firstName, String lastName, String phoneNumber,
                     City city, List<Aircraft> aircraft) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.aircraft = aircraft;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

}
