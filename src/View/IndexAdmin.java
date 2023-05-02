package View;

import javax.swing.*;
import Controller.AdminController;
import java.awt.*;

public class IndexAdmin extends JFrame {

  // Card layout for switching view
private CardLayout cardLayout;

public IndexAdmin() {
    super("Accueil");
    cardLayout = new CardLayout();
    IndexAdminForm form = new IndexAdminForm();
    setLayout(cardLayout);
    new AdminController(form);
    add(form, "form");

    // Switch to the user management view when clicked
    form.gestionUtilisateursListener(e -> cardLayout.show(IndexAdmin.this.getContentPane(), "utilisateursForm"));

    // Set the icon for the application
    ImageIcon imageIcon = new ImageIcon("src/assets/appicon.png");
    setIconImage(imageIcon.getImage());

    // Set the size of the application window
    int FRAME_WIDTH = 1200;
    int FRAME_HEIGHT = 700;
    setSize(FRAME_WIDTH, FRAME_HEIGHT);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}


}
