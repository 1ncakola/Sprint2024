package aircraft;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository){
        this.aircraftRepository =  aircraftRepository;
    }

    public List<Aircraft> getAllAircraft(){
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftById(Long id){
        return aircraftRepository.findById(id);
    }

    public Aircraft createAircraft(Aircraft aircraft){
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        if (aircraftRepository.existsById(id)) {
            aircraft.setId(id);
            return aircraftRepository.save(aircraft);
        }
        return null;
    }

    public void deleteAircraft(Long id){
        aircraftRepository.deleteById(id);
    }
}
