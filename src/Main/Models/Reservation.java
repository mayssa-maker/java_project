package Main.Models;

import java.time.LocalDate;


public class Reservation {
    private LocalDate dateDebut;
    private LocalDate dateFin;

    private int chambrenum;
    private String clientmail;
    private String hotelname;

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public Reservation(String hotelname,LocalDate dateDebut, LocalDate dateFin, int chambrenum, String clientmail) {
        this.hotelname = hotelname;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chambrenum = chambrenum;
        this.clientmail = clientmail;
        
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setChambrenum(int chambrenum) {
        this.chambrenum = chambrenum;
    }

    public void setClientmail(String clientmail) {
        this.clientmail = clientmail;
    }

   

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public int getChambrenum() {
        return this.chambrenum;
    }

    public String getClientmail() {
        return clientmail;
    }

 
}
