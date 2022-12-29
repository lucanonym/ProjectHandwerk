package application.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.sql.Date;


// TODO Repo for entries still needs to be created
// TODO non-volatile database
// TODO csv-Test
@Entity
public abstract class ProjectEntry {

    private @Id @GeneratedValue long id;
    private Date date;
    private String description;
    @ManyToOne
    Project site;

    public long getId() {
        return id;
    }

    public void update(ProjectEntry entry) {
        this.date = entry.getDate();
        this.description = entry.getDescription();
        this.site = entry.getSite();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getSite() {
        return site;
    }

    public void setSite(Project site) {
        this.site = site;
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

    public long getID() {
        return id;
    }

}
