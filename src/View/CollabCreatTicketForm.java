package View;

import Model.*;
import Service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CollabCreatTicketForm extends JPanel {

    private JTextField titleField;
    private JTextArea descriptionArea;
    private JComboBox<User> assignedToBox;
    private JButton createTicketButton;

    public CollabCreatTicketForm(User currentUser) {

        // initialize components
        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);

        JLabel assignedToLabel = new JLabel("Assign to:");
        assignedToBox = new JComboBox<>();

        for (User user : AuthenticationService.readUsersFromDatabase()) {
            if (!user.equals(currentUser)) {
                assignedToBox.addItem(user);
            }
        }

        createTicketButton = new JButton("Create Ticket");

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(titleLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(titleField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(descriptionLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(scrollPane, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(assignedToLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(assignedToBox, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        add(createTicketButton, gridBagConstraints);

    }
    public void createTicket(ActionListener actionListener) {
        createTicketButton.addActionListener(actionListener);
    };

    public String getTitle(){
        return titleField.getText();
    }

    public String getDescreption(){
        return descriptionArea.getText();
    }

   public User getAssignTo(){
    return (User) assignedToBox.getSelectedItem();
   }

   public void reset(boolean bln) {
    if(bln) {
        titleField.setText("");
        descriptionArea.setText("");
    }
}

}
