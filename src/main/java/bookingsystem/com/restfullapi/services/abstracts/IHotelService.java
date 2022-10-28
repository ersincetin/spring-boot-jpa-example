package bookingsystem.com.restfullapi.services.abstracts;

import bookingsystem.com.restfullapi.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelService {
    Hotel saveHotel(Hotel hotel);

    Optional<Hotel> getHotel(Integer id);

    List<Hotel> hotelList();

    Hotel updateHotel(Hotel hotel, Integer id);

    void deleteHotelById(Integer id);
}
