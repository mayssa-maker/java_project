package DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import Main.Models.Reservation;

public class ReservationDAO {
    private static List<Reservation> reservations = new ArrayList<>();

    public static void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public static void updateReservation(Reservation reservation) {
        int index = reservations.indexOf(reservation);
        if (index >= 0) {
            reservations.set(index, reservation);
        }
    }

    public static void deleteReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public static List<Reservation> getAllReservations() {
        return reservations;
    }

 

    public List<Reservation> getReservationsByClientmail(String clientmail) {
        List<Reservation> clientReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getClientmail() == clientmail) {
                clientReservations.add(reservation);
            }
        }
        return clientReservations;
    }

    public List<Reservation> getReservationsByChambreId(int chambrenum) {
        List<Reservation> chambreReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getChambrenum() == chambrenum) {
                chambreReservations.add(reservation);
            }
        }
        return chambreReservations;
    }

    public List<Reservation> getReservationsByDates(LocalDate checkInDate, LocalDate checkOutDate) {
        List<Reservation> reservationsInRange = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getDateDebut().compareTo(checkOutDate) < 0
                    && reservation.getDateFin().compareTo(checkInDate) > 0) {
                reservationsInRange.add(reservation);
            }
        }
        return reservationsInRange;
    }
}
