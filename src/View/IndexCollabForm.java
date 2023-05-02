package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class IndexCollabForm extends JPanel{

    private JButton mesTicketsButton;
    private JButton traetTicketsButton;
    private JButton statistiqueButton;

    public IndexCollabForm() {

        // initialize buttons
        mesTicketsButton = new JButton("Mes Tickets");
        traetTicketsButton = new JButton("Traitement des Tickets");
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

        add(mesTicketsButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(traetTicketsButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;

        add(statistiqueButton, gridBagConstraints);
    }

    // listeners for each button
    public void mesTicketsListener(ActionListener actionListener) {
        mesTicketsButton.addActionListener(actionListener);
    }

    public void treatTicketsListener(ActionListener actionListener) {
        traetTicketsButton.addActionListener(actionListener);
    }

    public void statistiqueListener(ActionListener actionListener) {
        statistiqueButton.addActionListener(actionListener);
    }

     
}