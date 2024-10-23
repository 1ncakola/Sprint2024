package airport;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirport(){
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id){
        return airportRepository.findById(id);
    }


}
