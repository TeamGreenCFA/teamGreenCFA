package team.green.cfo.command;

import javax.validation.constraints.*;

public class BenDto {

    private Integer id;

    @NotNull(message = "First name is mandatory")
    @NotBlank (message = "First name is mandatory")
    @Size(min = 3, max = 64)
    private String firstName;

    @NotNull (message = "First name is mandatory")
    @NotBlank (message = "First name is mandatory")
    @Size (min = 3, max = 64)
    private String lastName;


    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

     


    private String phone;

    private String address;

    private String descriptions;

    private String services;

    public int age;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
        return "BenForm{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }



}
