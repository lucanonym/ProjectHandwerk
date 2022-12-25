package application.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuildingSiteEntry implements GenericEntity<BuildingSiteEntry> {

    private @Id @GeneratedValue long id;











    @Override
    public long getID() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void update(BuildingSiteEntry entrie) {
        //TODO add attributes and implement method
        throw new UnsupportedOperationException();
    }
}
