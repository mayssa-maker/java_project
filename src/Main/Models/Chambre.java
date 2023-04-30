package Main.Models;

public class Chambre {
    private int numero;
    private String type;
    private double tarif;
    private String hotelName;

    public Chambre(int numero, String type, double tarif,String hotelName ) {
        this.numero = numero;
        this.type = type;
        this.tarif = tarif;
        this.hotelName = hotelName;
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

    public String getHotel() {
        return hotelName;
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

    public void setHotel(String hotel1) {
        this.hotelName=hotel1;
    }
    
}