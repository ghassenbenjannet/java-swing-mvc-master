package Model;

public class Ticket {
    private String title;
    private String description;
    private User createdBy;
    private User assignedTo;
    private String status;

    public Ticket(String title, String description, User createdBy) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.status = "created";
    }

    public void assignTo(User assignedTo) {
        this.assignedTo = assignedTo;
        this.status = "in progress";
    }

    public void markAsTraited() {
        this.status = "traited";
    }

    // getters and setters

    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.title, this.description, this.createdBy, this.assignedTo, this.status);
    }

    public static Ticket fromString(String line) {
        String[] parts = line.split(",");
        String title = parts[0];
        String description = parts[1];
        User createdBy = User.fromString(parts[2]);
        User assignedTo = null;
        if (!parts[3].equals("null")) {
            assignedTo = User.fromString(parts[3]);
        }
        String status = parts[4];
        Ticket ticket = new Ticket(title, description, createdBy);
        if (assignedTo != null) {
            ticket.assignTo(assignedTo);
        }
        if (status.equals("traited")) {
            ticket.markAsTraited();
        }
        return ticket;
    }

    public User getAssignTo() {
        return assignedTo;
    }

    public User getCreatedBy() {
        return createdBy ;
    }


}
