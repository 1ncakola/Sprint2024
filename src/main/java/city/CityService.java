package city;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    private  CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id){
        return cityRepository.findById(id);
    }

    public City createCity(City city){
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city){
        if(cityRepository.existsById(id)){
            city.setId(id);
            return cityRepository.save(city);
        }
        return null;
    }

    public void deleteCity(Long id){
        cityRepository.deleteById(id);
    }
}
