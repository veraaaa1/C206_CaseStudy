public class User {
    private String name;
    private String email;
    private int contactnum;

    public User(String name, String email, int contactnum) {
        this.name = name;
        this.email = email;
        this.contactnum = contactnum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public int getContactnum() {
      return contactnum;
    }

    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nContact Number: " + contactnum;
    }
}