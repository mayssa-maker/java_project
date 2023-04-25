
public class Chambre {
    private int numero;
    private String type;
    private double tarif;
    private Hotel hotel;

    public Chambre(int numero, String type, double tarif,Hotel hotel ) {
        this.numero = numero;
        this.type = type;
        this.tarif = tarif;
        this.hotel = hotel;
    }

  

    public Chambre() {
    }



    public int getNumero() {
        return numero;
    }

    public String getType() {
        return type;
    }

    public double getTarif() {
        return tarif;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Chambre getReservation() {
        return null;
    }

    public void setNumero(int i) {
        this.numero=i;
    }

    public void setType(String t) {
        this.type=t;
    }

    public void setPrix(double d) {
        this.tarif=d;
    }

    public void setHotel(Hotel hotel1) {
        this.hotel=hotel1;
    }
    
}