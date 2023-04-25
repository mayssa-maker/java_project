public class Hotel {
    private String nom;
    private String adresse;
    private Chambre[] chambres;

    public Hotel(String nom, String adresse, Chambre[] chambres) {
        this.nom = nom;
        this.adresse = adresse;
        this.chambres = chambres;
    }

    public Hotel(String string, String string2) {
    }

    public Hotel(String hotelName) {
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Chambre[] getChambres() {
        return chambres;
    }
    
}
