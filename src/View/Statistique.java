package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.*;

public class Statistique extends JFrame {

    private ArrayList<Ticket> tickets = new ArrayList<>();
    private PieChart chart;
    private JLabel label;

    public Statistique(User user) {
        setTitle("Statistiques");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FileManager fm = new FileManager();

        if(user.getRole() == 2) {
            try {
                tickets = fm.getCollaboratorTickets(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                tickets = fm.getAdminTickets();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Création du graphique
        chart = new PieChart("Statistiques des tickets");
        chart.setBorder(BorderFactory.createLineBorder(Color.black));

        // Comptage du nombre de tickets par état
        int createdCount = 0;
        int inProgressCount = 0;
        int treatedCount = 0;

        for (Ticket ticket : tickets) {
            String status = ticket.getStatus();
            if (status.equalsIgnoreCase("created")) {
                createdCount++;
            } else if (status.equalsIgnoreCase("in progress")) {
                inProgressCount++;
            } else if (status.equalsIgnoreCase("treated")) {
                treatedCount++;
            }
        }

        // Calcul du pourcentage de chaque segment
        double totalCount = createdCount + inProgressCount + treatedCount;
        double createdPercentage = (createdCount / totalCount) * 100;
        double inProgressPercentage = (inProgressCount / totalCount) * 100;
        double treatedPercentage = (treatedCount / totalCount) * 100;

        // Ajout des segments au graphique avec leur couleur, leur légende et leur pourcentage
        chart.addSegment("Créés (" + String.format("%.2f", createdPercentage) + "%)", createdCount, new Color(0, 128, 0));
        chart.addSegment("En cours (" + String.format("%.2f", inProgressPercentage) + "%)", inProgressCount, new Color(255, 165, 0));
        chart.addSegment("Traité (" + String.format("%.2f", treatedPercentage) + "%)", treatedCount, new Color(220, 20, 60));

        // Ajout du graphique et du label de légende au panneau principal
        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.add(chart, BorderLayout.CENTER);
        label = new JLabel("Légende: ");
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        chartPanel.add(label, BorderLayout.SOUTH);
        add(chartPanel, BorderLayout.CENTER);
    }
}
