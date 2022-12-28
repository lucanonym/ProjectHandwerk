package application.entities;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    private @Id @GeneratedValue long id;
    private long sales;
    private String address;
    private String preName;
    private String lastName;
    private int phoneNumber;
    private String salutation;
    @OneToMany(mappedBy = "customer")
    private List<Project> projects;


    public Customer() {
    }

    public Customer(String preName, String lastName, String address, List<Project> sites) {
        this.projects = new ArrayList<>(sites);
        this.preName = preName;
        this.lastName = lastName;
        this.address = address;
    }

    public void update(Customer customer) {
        this.lastName = customer.getLastName();
        this.address = customer.getAddress();
        this.preName = customer.getPreName();
        this.phoneNumber = customer.getPhoneNumber();
        this.salutation = customer.getSalutation();
        this.sales = customer.getSales();
    }

    public long getID() {
        return id;
    }

    public String getSalutation() {
        return salutation;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }


    public String getLastName() {
        return lastName;
    }


    public String getPreName() {
        return preName;
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }

    public long getSales() {
        return sales;
    }

    public String toString() {
        return "Customer {id:  " + id + ", first name = " + this.preName + ", last name = " + lastName + ", address = " + address + "}";
    }
    public Customer createNewInstance() {
        Customer newInstance = new Customer();
        newInstance.update(this);
        return newInstance;
    }

}
