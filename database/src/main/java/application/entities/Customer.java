package application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer implements GenericEntity<Customer>{

    private @Id @GeneratedValue
    long id;
    private String address;
    private String preName;
    private String lastName;
    private int phoneNumber;
    private String salutation;
    @OneToMany
    private List<BuildingSite> buildingSite;


    public Customer() {
    }

    public Customer(String preName, String lastName, String address) {
        this.preName = preName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public void update(Customer customer) {
        this.lastName = customer.getLastName();
        this.address = customer.getAddress();
        this.preName = customer.getPreName();
        this.phoneNumber = customer.getPhoneNumber();
        this.salutation = customer.getSalutation();
    }
    @Override
    public long getID() {
        return id;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Customer {id:  " + id + ", first name = " + this.preName + ", last name = " + lastName + ", address = " + address + "}";
    }

}
