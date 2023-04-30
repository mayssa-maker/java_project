package DAO;
import java.util.ArrayList;
import java.util.List;

import Main.Models.Hotel;

public class HotelDAO {
    private static List<Hotel> hotels = new ArrayList<>();

    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public void updateHotels(Hotel hotel) {
        int index = hotels.indexOf(hotel);
        if (index >= 0) {
            hotels.set(index, hotel);
        }
    }

    public static void deleteHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotels;
    }

    public Hotel getChambreByNom(String nom) {
        for (Hotel hotel: hotels) {
            if (hotel.getNom() == nom) {
                return hotel;
            }
        }
        return null;
    }
}


