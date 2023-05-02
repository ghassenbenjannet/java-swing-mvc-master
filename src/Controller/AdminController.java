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

    }
}
