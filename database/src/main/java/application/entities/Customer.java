package application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    private @Id @GeneratedValue long id;
    private String address;
    private String preName;
    private String lastName;

    public Customer() {

    }

    public Customer(String preName, String lastName, String address) {
        this.preName = preName;
        this.lastName = lastName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public String toString() {
        return "Customer {id:  " + id + ", first name = " + this.preName + ", last name = " + lastName + ", address = " + address + "}";
    }

}
