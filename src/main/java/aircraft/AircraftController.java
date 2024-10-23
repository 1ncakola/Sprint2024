package aircraft;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {
    private final AircraftRepository aircraftRepository;

    public AircraftController(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    @PostMapping
    public Aircraft createCity(@RequestBody Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @PutMapping("/{id}")
    public Aircraft updateCity(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        aircraft.setId(id);
        return aircraftRepository.save(aircraft);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        aircraftRepository.deleteById(id);
    }
}