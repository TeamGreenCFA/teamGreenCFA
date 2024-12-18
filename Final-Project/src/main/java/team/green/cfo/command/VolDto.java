package team.green.cfo.command;

import javax.validation.constraints.*;

public class VolDto {
    private Integer id;

    @NotNull (message = "First name is mandatory")
            @NotBlank (message = "First name is mandatory")
            @Size (min = 3, max = 23)
    private String firstName;

    @NotNull(message = "First name is mandatory")
            @NotBlank (message = "First name is mandatory")
            @Size (min = 3, max = 23)
    private String lastName;


    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;


    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
            @Size(min = 9, max = 16)
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "VolForm{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}