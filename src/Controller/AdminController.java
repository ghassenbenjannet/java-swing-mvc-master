package Controller;

import View.*;


public class AdminController {
    private IndexAdminForm indexAdmin;
    public AdminController( IndexAdminForm indexAdmin) {
        this.indexAdmin = indexAdmin;
        indexAdmin.gestionUtilisateursListener(e -> {
                    MainFrame adminFrame = new MainFrame();
                    adminFrame.setVisible(true);
                    indexAdmin.setVisible(false);
                
        });

        indexAdmin.gestionTicketsListener(e -> {

                    ViewTickets VFrame = new ViewTickets(ConnexionController.currentUser);
                    VFrame.setVisible(true);
                    indexAdmin.setVisible(false);
        });

        indexAdmin.statistiqueListener(e -> {
            Statistique Vframe = new Statistique(ConnexionController.currentUser);
            Vframe.setVisible(true);
            indexAdmin.setVisible(false);

        } );

    }
}
