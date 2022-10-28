package bookingsystem.com.restfullapi.controllers;

import bookingsystem.com.restfullapi.entities.Hotel;
import bookingsystem.com.restfullapi.services.abstracts.IHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final IHotelService hotelService;

    @GetMapping()
    public List<Hotel> getAllHotel() {
        return this.hotelService.hotelList();
    }

    @GetMapping(value = "/{hotelId}")
    public Optional<Hotel> getUserBy(@PathVariable("hotelId") Integer hotelId) {
        return this.hotelService.getHotel(hotelId);
    }

    @PostMapping("/save")
    public Hotel saveHotel(@Valid @RequestBody Hotel hotel) {
        return this.hotelService.saveHotel(hotel);
    }

    @PutMapping("/update/{hotelId}")
    public Hotel updateHotel(@RequestBody Hotel hotel, @PathVariable("hotelId") Integer hotelId) {
        return this.hotelService.updateHotel(hotel, hotelId);
    }

    @DeleteMapping("/delete/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") Integer hotelId) {
        this.hotelService.deleteHotelById(hotelId);
    }
}
