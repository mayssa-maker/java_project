package Main.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.App;
import Main.Models.Hotel;
import DAO.HotelDAO;

public class ManageHotelsFrame extends JFrame {
    private HotelDAO hotelDAO = new HotelDAO();

    private JTextField txtNom = new JTextField(10);
    private JTextField txtAdresse = new JTextField(10);
    private JButton btnSave = new JButton("Save");
    private JButton btnAdd = new JButton("Add");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnLoad = new JButton("Load");
    private JButton btnViewRooms = new JButton("View Rooms");
    private JButton returnButton = new JButton("Return to Main Frame");
    // Create a new JTable with column names and zero rows
    String[] columnNames = {"Nom", "Adresse"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    JTable tblHotels= new JTable(model);
  
    

    public ManageHotelsFrame() {
        JFrame frame = new JFrame("Hotel Management System - Manage Hotels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(new JLabel("Nom:"));
        inputPanel.add(txtNom);
        inputPanel.add(new JLabel("Adresse:"));
        inputPanel.add(txtAdresse);
  
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnViewRooms);
        buttonPanel.add(returnButton);
        formPanel.add(inputPanel, BorderLayout.NORTH);
        formPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(formPanel, BorderLayout.NORTH);

        // Hotels table
        JScrollPane scrollPane = new JScrollPane(tblHotels);
        frame.add(scrollPane, BorderLayout.CENTER);


        // Load all hotels on startup
        loadHotels();

  

        // Add event listeners
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addHotel();
            }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addHotel();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteHotel();
            }

        });

        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadHotels();
            }
        });
    
    
    btnViewRooms.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int row = tblHotels.getSelectedRow();
            List<Hotel> hotels = hotelDAO.getAllHotels();

            if (row >= 0) {
                Hotel hotel = hotels.get(row);
                HotelFrame hotelFrame = new HotelFrame(hotel);
                hotelFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(ManageHotelsFrame.this, "Please select a hotel.");
            }
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
    private void loadHotels() {
        // Clear the table before loading new data
        model.setRowCount(0);

        // Get all hotelss from the DAO
        List<Hotel> hotels = hotelDAO.getAllHotels();

        // Add each hotel to the table
        for (Hotel hotel : hotels) {
            Object[] rowData = {hotel.getNom(), hotel.getAdresse()};
            model.addRow(rowData);
        }
    }
   

    private void addHotel() {
        // Create a new hotel from the input fields
        String nom= txtNom.getText();
        String adresse= txtAdresse.getText();
        

        Hotel hotel = new Hotel(nom,adresse);

        // Add the hotel to the DAO
        HotelDAO.addHotel(hotel);
           
   

    // Add the hotel to the table
    Object[] rowData =  {hotel.getNom(), hotel.getAdresse()};
    model.addRow(rowData);

    // Clear the input fields
    txtNom.setText("");
    txtAdresse.setText("");
   
}

private void deleteHotel() {
    // Get the selected row index
    int rowIndex = tblHotels.getSelectedRow();

    // Check if a row is selected
    if (rowIndex < 0) {
        return;
    }

    // Get the hotel from the selected row
    String nom = (String) model.getValueAt(rowIndex, 0);
    String adresse = (String) model.getValueAt(rowIndex, 1);
    Hotel hotel = new Hotel(nom, adresse);

    // Remove the hotel from the DAO
    HotelDAO.deleteHotel(hotel);

    // Remove the hotel from the table
    model.removeRow(rowIndex);
}

public static void main(String[] args) {
    ManageHotelsFrame frame = new ManageHotelsFrame();
    frame.setVisible(true);
}
}
