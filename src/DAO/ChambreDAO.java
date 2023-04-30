package DAO;

import java.util.ArrayList;
import java.util.List;

import Main.Models.Chambre;

public class ChambreDAO{
    private static List<Chambre> chambres = new ArrayList<>();

    public void addChambre(Chambre chambre) {
        chambres.add(chambre);
    }

    public void updateChambre(Chambre chambre) {
        int index = chambres.indexOf(chambre);
        if (index >= 0) {
            chambres.set(index, chambre);
        }
    }

    public void deleteChambre(Chambre chambre) {
        chambres.remove(chambre);
    }

    public List<Chambre> getAllChambres() {
        return chambres;
    }

    public Chambre getChambreByNumero(int numero) {
        for (Chambre chambre : chambres) {
            if (chambre.getNumero() == numero) {
                return chambre;
            }
        }
        return null;
    }
}

