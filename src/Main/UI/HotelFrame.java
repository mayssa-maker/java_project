package Main.UI;

import Main.Models.Chambre;
import Main.Models.Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelFrame extends JFrame {

    private JLabel nomLabel;
    private JLabel adresseLabel;
    private JTextField nomField;
    private JTextField adresseField;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton loadChambresButton;
    private JTextArea chambresArea;

    private Hotel hotel;

    public HotelFrame(Hotel hotel) {
        this.hotel = hotel;

        // Configure window
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create UI components
        nomLabel = new JLabel("Nom:");
        adresseLabel = new JLabel("Adresse:");
        nomField = new JTextField(hotel.getNom(), 20);
        adresseField = new JTextField(hotel.getAdresse(), 20);
        saveButton = new JButton("Enregistrer");
        cancelButton = new JButton("Annuler");
        loadChambresButton = new JButton("Chambres");
        chambresArea = new JTextArea(15, 40);
        chambresArea.setEditable(false);

        // Add UI components to window
        add(nomLabel);
        add(nomField);
        add(adresseLabel);
        add(adresseField);
        add(saveButton);
        add(cancelButton);
        add(loadChambresButton);
        add(new JScrollPane(chambresArea));

        // Register event handlers
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHotel();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        loadChambresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadChambres();
            }
        });
    }

    private void saveHotel() {
        // Update hotel with input values
        hotel.setNom(nomField.getText());
        hotel.setAdresse(adresseField.getText());

        // Close window
        dispose();
    }

    private void loadChambres() {
        // Get chambres from hotel
        Chambre[] chambres = hotel.getChambres();

        // Display chambres in text area
        chambresArea.setText("");
        for (Chambre chambre : chambres) {
            chambresArea.append("Numéro: " + chambre.getNumero() + ", Type: " + chambre.getType() + ", Tarif: " + chambre.getTarif() + "\n");
        }
    }
}

