package application.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    private @Id @GeneratedValue long id;
    private String name;
    private int startDate;
    private String address;
    @OneToMany(mappedBy = "site")
    List<ProjectEntry> projectEntries;
    @ManyToOne
    Customer customer;

    public Project(Customer customer, String name, int startDate, String address, List<ProjectEntry> projectEntries) {
        this.customer = customer;
        this.name = name;
        this.startDate = startDate;
        this.address = address;
        this.projectEntries = new ArrayList<>(projectEntries);

    }

    public Project() {
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void update(Project site) {
        this.startDate = site.getStartDate();
        this.address = site.getAddress();

    }

    public int getStartDate() {
        return startDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }



    public Project createNewInstance() {
        Project newInstance = new Project();
        newInstance.update(this);
        return newInstance;
    }
}
