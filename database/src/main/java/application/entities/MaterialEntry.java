package application.entities;

import application.utilities.ChangeNotPossibleException;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@DiscriminatorValue("MATERIAL")
public class MaterialEntry extends ProjectEntry {

    public static final String CAST_NOT_POSSIBLE = "%s could not be changed to %s %n";

    private Unit unit;
    private String name;

    public MaterialEntry() {

    }

    public MaterialEntry(Date date, String description, Project project, Unit unit, String name) {
        setDate(date);
        setDescription(description);
        setSite(project);
        this.unit = unit;
        this.name = name;
    }

    @Override
    public void update(ProjectEntry entry) {
        super.update(entry);
        if (entry instanceof MaterialEntry materialEntry) {
            unit = materialEntry.getUnit();
            name = materialEntry.getName();
        } else throw new ChangeNotPossibleException(String.format(CAST_NOT_POSSIBLE,this.getClass(),entry.getClass()));
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
