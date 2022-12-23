package application.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuildingSiteEntries {

    private @Id @GeneratedValue long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
