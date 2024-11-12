public class User {
    private String username;
    private String name;
    private String status;

    public User(String username, String name) {
        this.username = username;
        this.name = name;
        this.status = "No status";  // Status default
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println(name + " updated status to: " + newStatus);
    }

    public void viewProfile() {
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Status: " + status);
    }

    public String getUsername() {
        return username;
    }
}
