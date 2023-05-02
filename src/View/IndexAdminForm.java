package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class IndexAdminForm extends JPanel {

    private JButton gestionTicketsButton;
    private JButton gestionUtilisateursButton;
    private JButton statistiqueButton;

    public IndexAdminForm() {

        // initialize buttons
        gestionTicketsButton = new JButton("Gestion des Tickets");
        gestionUtilisateursButton = new JButton("Gestion des Utilisateurs");
        statistiqueButton = new JButton("Statistique");

        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        add(gestionTicketsButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(gestionUtilisateursButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;

        add(statistiqueButton, gridBagConstraints);
    }

    // listeners for each button
    public void gestionTicketsListener(ActionListener actionListener) {
        gestionTicketsButton.addActionListener(actionListener);
    }

    public void gestionUtilisateursListener(ActionListener actionListener) {
        gestionUtilisateursButton.addActionListener(actionListener);
    }

    public void statistiqueListener(ActionListener actionListener) {
        statistiqueButton.addActionListener(actionListener);
    }

     
}
