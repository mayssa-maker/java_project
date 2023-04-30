package Main.UI;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.App;
import Main.Models.Chambre;

import DAO.*;

public class ManageChambresFrame extends JFrame {
    private ChambreDAO chambreDAO = new ChambreDAO();

    private JTextField txtNumero = new JTextField(10);
    private JTextField txtType = new JTextField(10);
    private JTextField txtTarif= new JTextField(10);
    private JTextField txtHotelName= new JTextField(10);
    private JButton btnSave = new JButton("Save");
    private JButton btnAdd = new JButton("Add");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnLoad = new JButton("Load");
    private JButton returnButton = new JButton("Return to Main Frame");

    // Create a new JTable with column names and zero rows
    String[] columnNames = {"numero", "type", "tarif","hotelname"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    JTable tblChambres = new JTable(model);

    

    public ManageChambresFrame() {
        JFrame frame = new JFrame("Hotel Management System - Manage Chambres");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(new JLabel("numero:"));
        inputPanel.add(txtNumero);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(txtType);
        inputPanel.add(new JLabel("Tarif:"));
        inputPanel.add(txtTarif);
        inputPanel.add(new JLabel("HotelName:"));
        inputPanel.add(txtHotelName);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnLoad);
        buttonPanel.add(returnButton);

        formPanel.add(inputPanel, BorderLayout.NORTH);
        formPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(formPanel, BorderLayout.NORTH);

        // Chambre table
        JScrollPane scrollPane = new JScrollPane(tblChambres);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Load all chambres on startup
        loadChambres();

        // Add event listeners
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addChambre();
            }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addChambre();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteChambre();
            }
        });

        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadChambres();
            }
        });
        returnButton.addActionListener(e -> {
            // create a new instance of the main frame and make it visible
             App mainFrame = new App();
             mainFrame.setVisible(true);
             // dispose of the current frame
             frame.setVisible(false);
});
        frame.setVisible(true);
    }

    private void loadChambres() {
        // Clear the table before loading new data
        model.setRowCount(0);

        // Get all chambres from the DAO
        List<Chambre> chambres = chambreDAO.getAllChambres();

        // Add each chambre to the table
        for (Chambre chambre : chambres) {
            Object[] rowData = {chambre.getNumero(), chambre.getType(), chambre.getTarif(),chambre.getHotel()};
            model.addRow(rowData);
        }
    }

    private void addChambre() {
        // Create a new chambre from the input fields
        String numerostr = txtNumero.getText();
        String type = txtType.getText();
        String tarifstr = txtTarif.getText();
        String hotel = txtHotelName.getText();
         // Parse the numeric values
        int numero = Integer.parseInt(numerostr);
        double tarif = Double.parseDouble(tarifstr);

        Chambre chambre = new Chambre(numero,type,tarif,hotel);

        // Add the chambre to the DAO
        chambreDAO.addChambre(chambre);

    // Add the chambre to the table
    Object[] rowData = {chambre.getNumero(), chambre.getType(), chambre.getTarif(),chambre.getHotel()};
    model.addRow(rowData);

    // Clear the input fields
    
      txtNumero.setText("");
      txtType.setText("");
      txtTarif.setText("");
      txtHotelName.setText("");
}

private void deleteChambre() {
    // Get the selected row index
    int rowIndex = tblChambres.getSelectedRow();

    // Check if a row is selected
    if (rowIndex < 0) {
        return;
    }

    // Get the chambre from the selected row
    String numerostr= (String) model.getValueAt(rowIndex, 0);
    String type = (String) model.getValueAt(rowIndex, 1);
    String tarifstr = (String) model.getValueAt(rowIndex, 2);
    String hotelname = (String) model.getValueAt(rowIndex, 3);
    int numero = Integer.parseInt(numerostr);
    double tarif = Double.parseDouble(tarifstr);
    Chambre chambre = new Chambre(numero, type, tarif,hotelname);

    // Remove the chambre from the DAO
    chambreDAO.deleteChambre(chambre);

    // Remove the chambre from the table
    model.removeRow(rowIndex);
}

public static void main(String[] args) {
    ManageChambresFrame frame = new ManageChambresFrame();
    frame.setVisible(true);
}
}
