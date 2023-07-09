package beans;

public class PassData
{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String passwd;
    private String confPassword;


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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getconfPasswd() {
        return confPassword;
    }

    public void setconfPasswd(String confPassword) {
        this.confPassword = confPassword;
    }



    @Override
    public String toString() {
        return "AddrData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", confPassword='" + confPassword +
                '}';
    }

}

