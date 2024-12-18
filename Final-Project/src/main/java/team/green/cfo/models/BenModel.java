package team.green.cfo.models;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "ben")
public class BenModel extends AbstractModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private int phone;

    private int age;

    private String address;

    private String descriptions;

    @ElementCollection
    private List<String> services = new LinkedList<>();


    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getPhone() {
        return phone;
    }

    @Override
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getDescriptions() {
        return descriptions;
    }

    @Override
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public List getServices() {
        return services;
    }

    @Override
    public void setServices(List services) {
        this.services = services;
    }
}
