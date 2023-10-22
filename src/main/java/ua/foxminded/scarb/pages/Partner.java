package ua.foxminded.scarb.pages;

public class Partner {

    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String companyPosition;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() { this.email = email; }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPosition() { return companyPosition; }

    public void setCompanyPosition(String companyPosition) {
        this.companyPosition = companyPosition;
    }

    public String getPassword() { return password;}

    public void setPassword(String password) {
        this.password = password;
    }
}
