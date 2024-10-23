package passager;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger createPassenger(Passenger passenger){
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passenger) {
        if (passengerRepository.existsById(id)) {
            passenger.setId(id);
            return passengerRepository.save(passenger);
        }
        return null;
    }

    public void deletePassenger (Long id) {
        passengerRepository.deleteById(id);
    }
}
