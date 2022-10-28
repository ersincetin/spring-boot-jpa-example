package bookingsystem.com.restfullapi.services.concretes;

import bookingsystem.com.restfullapi.repositories.HotelRepository;
import bookingsystem.com.restfullapi.entities.Hotel;
import bookingsystem.com.restfullapi.services.abstracts.IHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService implements IHotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    @Override
    public Optional<Hotel> getHotel(Integer id) {
        return this.hotelRepository.findById(id);
    }

    @Override
    public List<Hotel> hotelList() {
        return (List<Hotel>) this.hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(Hotel hotel, Integer id) {
        Hotel hotelDB = this.hotelRepository.findById(id).get();

        hotelDB.setName(hotel.getName());
        hotelDB.setStatus(hotel.getStatus());
        hotelDB.setExplanation(hotel.getExplanation());

        return hotelRepository.save(hotelDB);
    }

    @Override
    public void deleteHotelById(Integer id) {
        this.hotelRepository.deleteById(id);
    }
}
