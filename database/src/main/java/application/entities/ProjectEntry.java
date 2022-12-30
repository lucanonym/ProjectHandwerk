package application.entities;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

import java.sql.Date;


// TODO non-volatile database
// TODO csv-Test

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = MaterialEntry.class, name = "MATERIAL"),
        @JsonSubTypes.Type(value = WorkingHourEntry.class, name = "WORKING"),
})
public abstract class ProjectEntry {



    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private Date date;
    @Column
    private String description;
    @ManyToOne
    Project site;

    protected ProjectEntry() {

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

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Long getID() {
        return id;
    }

}
