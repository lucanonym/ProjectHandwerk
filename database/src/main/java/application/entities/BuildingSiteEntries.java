package application.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuildingSiteEntries implements GenericEntity<BuildingSiteEntries> {

    private @Id @GeneratedValue long id;
    @Override
    public long getID() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void update(BuildingSiteEntries entrie) {
        //TODO add attributes and implement method
        throw new UnsupportedOperationException();
    }
}
