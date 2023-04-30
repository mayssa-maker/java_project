
package Main.UI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDate;
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
import Main.Models.Reservation;
import DAO.ReservationDAO;
public class ManageReservationsFrame extends JFrame {

    private JTable table;
    private JLabel lblClientMail, lblChambreNumero, lblCheckin, lblCheckout,lblHotelName;
    private JTextField txtClientMail, txtChambreNumero, txtCheckin,txtCheckout,txtHotelName;
    private JButton btnAdd, btnUpdate, btnDelete;
    private JButton returnButton = new JButton("Return to Main Frame");
     // Create a new JTable with column names and zero rows
     String[] columnNames = {"Hotel name", "Client mail","Chambre numero","check-in","check-out"};
     DefaultTableModel model = new DefaultTableModel(columnNames, 0);
     JTable tblReservations= new JTable(model);
    public ManageReservationsFrame() {
        
        JFrame frame = new JFrame("Hotel Management System - Manage Reservations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        // Initialize Swing components
        table = new JTable();
        lblHotelName=new JLabel("Hotel name :");
        lblClientMail = new JLabel("Client mail:");
        lblChambreNumero = new JLabel("Chambre numero:");
        lblCheckin = new JLabel("Check-in:");
        lblCheckout = new JLabel("Check-out:");
        txtClientMail = new JTextField(10);
        txtChambreNumero = new JTextField(10);
        txtCheckin = new JTextField(10);
        txtCheckout = new JTextField(10);
        txtHotelName = new JTextField(10);
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        // Set layout and add components
        setLayout(new BorderLayout());
        JPanel panelTop = new JPanel(new FlowLayout());
         
        panelTop.add(lblHotelName);
        panelTop.add(txtHotelName);
        panelTop.add(lblClientMail);
        panelTop.add(txtClientMail);
        panelTop.add(lblChambreNumero);
        panelTop.add(txtChambreNumero);
        panelTop.add(lblCheckin);
        panelTop.add(txtCheckin);
        panelTop.add(lblCheckout);
        panelTop.add(txtCheckout);
        
        frame.add(panelTop, BorderLayout.NORTH);
   
        JPanel panelBottom = new JPanel(new FlowLayout());
        panelBottom.add(btnAdd);
        panelBottom.add(btnUpdate);
        panelBottom.add(btnDelete);
        panelBottom.add(returnButton);
        frame.add(panelBottom, BorderLayout.SOUTH);
                // Reservations table
        JScrollPane scrollPane = new JScrollPane(tblReservations);
        frame.add(scrollPane, BorderLayout.CENTER);
        // Load reservations
        loadReservations();

        // Add action listeners
        btnAdd.addActionListener(e -> addReservation());
        btnUpdate.addActionListener(e -> updateReservation());
        btnDelete.addActionListener(e -> deleteReservation());
            
        returnButton.addActionListener(e -> {
            // create a new instance of the main frame and make it visible
             App mainFrame = new App();
             mainFrame.setVisible(true);
             // dispose of the current frame
             frame.setVisible(false);
});
        frame.setVisible(true);

    }

    private void loadReservations() {
        // Clear the table before loading new data
        model.setRowCount(0);
        // Retrieve reservations from database and populate table
        List<Reservation> reservations = ReservationDAO.getAllReservations();
   
  
        for (Reservation reservation : reservations) {
            Object[] rowData = { reservation.getHotelname(),
            reservation.getClientmail()
           ,reservation.getChambrenum(),
             reservation.getDateDebut(),
            reservation.getDateFin()};
            
            model.addRow(rowData);
        }
    
        
    }
    private void addReservation() {
        // Create a new reservation from the input fields
        String hotelname=txtHotelName.getText();
        String clientMail =txtClientMail.getText();
        int chambrenum = Integer.parseInt(txtChambreNumero.getText());
        LocalDate checkInDate = LocalDate.parse(txtCheckin.getText());
        LocalDate checkOutDate = LocalDate.parse(txtCheckout.getText());
    
        Reservation reservation = new Reservation(hotelname,checkInDate, checkOutDate, chambrenum,clientMail);
    
        // Add reservation to database
        ReservationDAO.addReservation(reservation); 
            loadReservations();
       
    }
    private void deleteReservation() {
        // Get the selected reservation ID from the table
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a reservation to delete.");
            return;
        }
        String hotelname=(String) table.getValueAt(selectedRow, 0);
        String clientMail =(String) table.getValueAt(selectedRow, 1);
        int chambrenum = (int) table.getValueAt(selectedRow, 2);
        LocalDate checkInDate = (LocalDate)table.getValueAt(selectedRow, 3);
        LocalDate checkOutDate = (LocalDate)table.getValueAt(selectedRow, 4);
    
        Reservation reservation = new Reservation(hotelname,checkInDate, checkOutDate, chambrenum,clientMail);
         
    
        // Delete reservation from database
        ReservationDAO.deleteReservation(reservation);
            // Refresh table
        loadReservations();
     
    }
    private void updateReservation() {
        // Get the selected reservation ID from the table
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a reservation to update.");
            return;
        }
        String hotelname=(String) table.getValueAt(selectedRow, 0);
        String clientMail =(String) table.getValueAt(selectedRow, 1);
        int chambrenum = (int) table.getValueAt(selectedRow, 2);
        LocalDate checkInDate = (LocalDate)table.getValueAt(selectedRow, 3);
        LocalDate checkOutDate = (LocalDate)table.getValueAt(selectedRow, 4);
    
        Reservation reservation =new Reservation(hotelname,checkInDate, checkOutDate, chambrenum,clientMail);
    
        // Update reservation in database
        ReservationDAO.updateReservation(reservation);
        loadReservations();
     
    }
    
    
public static void main(String[] args) {
    ManageReservationsFrame frame = new ManageReservationsFrame();
    frame.setVisible(true);
}
}     
    
       

