package application.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BuildingSite implements GenericEntity<BuildingSite> {

    private @Id @GeneratedValue long id;
    private int date;

    @Override
    public long getID() {
        return id;
    }

    @Override
    public void update(BuildingSite site) {
        this.date = site.getDate();
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setStartDate(int date) {
        this.date = date;
    }
}
