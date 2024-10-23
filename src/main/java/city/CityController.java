package city;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    @PostMapping
    public  City createCity(@RequestBody City city){
        return cityRepository.save(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City city){
        city.setId(id);
        return cityRepository.save(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id){
        cityRepository.deleteById(id);
    }
}
