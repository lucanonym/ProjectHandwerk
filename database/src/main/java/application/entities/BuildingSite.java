package application.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BuildingSite implements GenericEntity<BuildingSite> {

    private @Id @GeneratedValue long id;
    private int startDate;
    private String address;

    @OneToMany
    private List<BuildingSiteEntry> entries;

    @Override
    public long getID() {
        return id;
    }

    @Override
    public void update(BuildingSite site) {
        this.startDate = site.getStartDate();
        this.address = site.getAddress();
        this.id = site.getId();
        this.entries = new ArrayList<>(site.getEntries());
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int date) {
        this.startDate = date;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public List<BuildingSiteEntry> getEntries() {
        return List.copyOf(entries);
    }
}
