package come.test.hplus.beans;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class User {



    @Id
    private int id;

    @Size(min = 6,message = "Username cannot be less than 6 characters")
    private String username;
    @Pattern(regexp = "((?=.[A-Z].{6,10}))",message = "Password must have one upper cse, one lower case and should be " +
            "between 6 to 10 characters")
    private String password;
    private String gender;
    @NotNull(message = "Activity can not be empty")
    private String activity;
    @NotEmpty(message = "First Name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be empty")
    private String lastName;
    @Past
    @NotEmpty(message = "DOB format yyyy-mm-dd and cant be today")
    private String dateOfBirth;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
