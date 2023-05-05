package Controller;

import java.io.File;

import javax.swing.JOptionPane;

import Model.*;
import View.*;


public class TicketsController {
    private CollabCreatTicketForm form;
    private String databaseFile = "src\\data\\data_tickets.txt";
    private Database database;
    

    public TicketsController( CollabCreatTicketForm form) {
        this.database = new Database();
        this.form = form;
        //this.userDetails = userDetails;

        // submit userticket
        this.form.createTicket(e -> {
            String title = this.form.getTitle().trim();
            String descreption = this.form.getDescreption().trim();
            User createdBy = ConnexionController.currentUser;
            User assignTo = this.form.getAssignTo();
            String status = "Created" ;

            // simple validations
            if(title.isEmpty() ||descreption.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Tous les champs sont à remplir", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.database.addTicket(new Ticket(title, descreption, createdBy, assignTo));
            this.database.saveTicket(new File(databaseFile));
            this.form.reset(true);
        });
    }
}
