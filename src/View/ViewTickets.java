package View;

import Model.*;
import Controller.*;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ViewTickets extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    ArrayList<Ticket> tickets = new ArrayList<>();
    private final String dataPath = "src/data/";
    private final String ticketExtension = ".txt";


    public ViewTickets(User user) {
        setTitle("List of Tickets");
        setSize(800, 400);
        setLocationRelativeTo(null);
        FileManager fm = new FileManager();
        Database db = new Database();

        if(user.getRole()==2){
            try {
                tickets= fm.getCollaboratorTickets(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                tickets = fm.getAdminTickets();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] columnNames = {"Title", "Assigned to", "Created by", "State", "Description"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            // Override isCellEditable to make the "State" column editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
        for (Ticket ticket : tickets) {
            Object[] rowData = {ticket.getTitle(), ticket.getAssignTo().getFirstname(), ticket.getCreatedBy().getFirstname(), ticket.getStatus(), ticket.getDescreption()};
            model.addRow(rowData);
        }
        JTable table = new JTable(model);

        // Récupérer la colonne "State" du tableau
        TableColumn stateColumn = table.getColumnModel().getColumn(3);

        // Créer un JComboBox pour la colonne "State"
        JComboBox<String> stateComboBox = new JComboBox<>(new String[]{"Created", "In progress", "Traited"});
        stateColumn.setCellEditor(new DefaultCellEditor(stateComboBox));

        // Ajouter un ActionListener au JComboBox pour mettre à jour la liste de tickets
        stateComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer l'index de la ligne sélectionnée
                int rowIndex = table.getSelectedRow();
                if (rowIndex != -1) {
                    // Mettre à jour la valeur de "State" dans le ticket correspondant
                    String newState = (String) stateComboBox.getSelectedItem();
                    Ticket ticket = tickets.get(rowIndex);
                    String tmp = ticket.toString();
                    ticket.setStatus(newState);
                    db.UpdateTicketFile(dataPath +ticket.getAssignTo().getLastname() + "_" + ticket.getAssignTo().getFirstname() + "_Tickets"+ticketExtension, tmp, ticket.toString());
                    db.UpdateTicketFile(dataPath +"data_tickets"+ticketExtension, tmp, ticket.toString());

                }
            }
        });



        // Add the table to the panel
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        this.add(scrollPane);
    }

    public void display() {
        setVisible(true);
    }
}

