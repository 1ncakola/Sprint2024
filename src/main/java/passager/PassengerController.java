package passager;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    private final PassengerRepository passengerRepository;

    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @GetMapping
    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    @PostMapping
    public  Passenger createPassenger(@RequestBody Passenger passenger){
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger){
        passenger.setId(id);
        return passengerRepository.save(passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id){
        passengerRepository.deleteById(id);
    }
}
