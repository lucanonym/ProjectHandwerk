package application.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.sql.Date;


// TODO divide Entries ProjectMaterial and Hourly rates
// TODO non-volatile database
// TODO csv-Test
@Entity
public class BuildingSiteEntry {

    private @Id @GeneratedValue long id;
    private Date date;
    private String description;
    private Unit unit;
    private double ePrice;
    @ManyToOne
    Project site;

    public BuildingSiteEntry() {

    }


    public BuildingSiteEntry(Date date, String description, Unit unit, double ePrice) {
        this.date = date;
        this.description = description;
        this.unit = unit;
        this.ePrice = ePrice;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Unit getUnit() {
        return unit;
    }

    public double getePrice() {
        return ePrice;
    }

    public long getID() {
        return id;
    }

    public void update(BuildingSiteEntry entry) {
        this.ePrice = entry.getePrice();
        this.unit = entry.getUnit();
        this.description = entry.getDescription();
        this.date = entry.getDate();
        this.id = entry.getID();
    }

    public BuildingSiteEntry createNewInstance() {
        BuildingSiteEntry newInstance = new BuildingSiteEntry();
        newInstance.update(this);
        return newInstance;
    }
}
