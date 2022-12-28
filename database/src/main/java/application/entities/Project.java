package application.entities;


import javax.persistence.*;

@Entity
public class Project {

    private @Id @GeneratedValue long id;
    private String name;
    private int startDate;
    private String address;

    @ManyToOne
    Customer customer;

    public Project(Customer customer, String name, int startDate, String address) {
        this.customer = customer;
        this.name = name;
        this.startDate = startDate;
        this.address = address;

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

    public long getID() {
        return id;
    }


    public void update(Project site) {
        this.startDate = site.getStartDate();
        this.address = site.getAddress();
        this.id = site.getID();

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
