
import java.time.LocalDate;


public class Reservation {
    private LocalDate dateDebut;
    private LocalDate dateFin;

    private int chambrenum;
    private Client client;
    private Hotel hotel;

    public Reservation(Hotel hotel,LocalDate dateDebut, LocalDate dateFin, int chambrenum, Client client) {
        this.hotel = hotel;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chambrenum = chambrenum;
        this.client = client;
        
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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public int getChambre() {
        return this.chambrenum;
    }

    public Client getClient() {
        return client;
    }

    public Hotel getHotel() {
    
        return this.hotel;
    }
}
