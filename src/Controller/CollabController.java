package Controller;

import View.*;


public class CollabController {
    private IndexCollabForm indexCollab;
    public CollabController( IndexCollabForm indexCollab) {
        this.indexCollab = indexCollab;
        indexCollab.creerTicketListener(e -> {
            CollabCreatTicket adminFrame = new CollabCreatTicket();
            adminFrame.setVisible(true);
            indexCollab.setVisible(false);
        });

        indexCollab.mesTicketsListener(e -> {

            ViewTickets Vframe = new ViewTickets(ConnexionController.currentUser);
            Vframe.setVisible(true);
            indexCollab.setVisible(false);

        } );
        



    }
}
