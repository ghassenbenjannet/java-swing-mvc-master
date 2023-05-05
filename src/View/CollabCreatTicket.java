package View;

import javax.swing.*;
import Controller.*;
import java.awt.*;

public class CollabCreatTicket extends JFrame {

  // Card layout for switching view
  private CardLayout cardLayout;

  public CollabCreatTicket() {
    super("Créer un Ticket");
    cardLayout = new CardLayout();
    CollabCreatTicketForm form = new CollabCreatTicketForm(ConnexionController.currentUser);
    setLayout(cardLayout);
    new TicketsController(form);
    add(form, "form");

    // Set the icon for the application
    ImageIcon imageIcon = new ImageIcon("src/assets/appicon.png");
    setIconImage(imageIcon.getImage());

    // Set the size of the application window
    int FRAME_WIDTH = 600;
    int FRAME_HEIGHT = 400;
    setSize(FRAME_WIDTH, FRAME_HEIGHT);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
  }

}
