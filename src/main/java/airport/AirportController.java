package airport;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class AirportController {
    private final AirportRepository airportRepository;

    public AirportController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @GetMapping
    public List<Airport> getAllAirport() {
        return airportRepository.findAll();
    }

    @PostMapping
    public Airport createCity(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    @PutMapping("/{id}")
    public Airport updateCity(@PathVariable Long id, @RequestBody Airport airport) {
        airport.setId(id);
        return airportRepository.save(airport);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        airportRepository.deleteById(id);
    }
}
