package View;

import javax.swing.*;
import Controller.AdminController;
import Controller.CollabController;

import java.awt.*;

public class IndexCollab extends JFrame {

  // Card layout for switching view
private CardLayout cardLayout;

public IndexCollab() {
    super("Accueil");
    cardLayout = new CardLayout();
    IndexCollabForm form = new IndexCollabForm();
    setLayout(cardLayout);
    new CollabController(form);
    add(form, "form");

    // Switch to the user management view when clicked
    //form.gestionUtilisateursListener(e -> cardLayout.show(IndexAdmin.this.getContentPane(), "utilisateursForm"));

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
