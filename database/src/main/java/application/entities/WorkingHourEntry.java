package application.entities;

import application.utilities.ChangeNotPossibleException;

import java.sql.Date;

public class WorkingHourEntry extends ProjectEntry {

    public static final String CAST_NOT_POSSIBLE = "%s could not be changed to %s %n";

    private double amountOfHours;
    private double wage;

    public WorkingHourEntry(Date date, String description, Project project) {
        setDate(date);
        setDescription(description);
        setSite(project);
    }

    @Override
    public void update(ProjectEntry entry) {
        super.update(entry);
        if (entry instanceof WorkingHourEntry workingHourEntry) {
            this.wage = workingHourEntry.getWage();
            this.amountOfHours = workingHourEntry.getAmountOfHours();
        } else throw new ChangeNotPossibleException(String.format(CAST_NOT_POSSIBLE,this.getClass(),entry.getClass()));
    }

    public double getAmountOfHours() {
        return amountOfHours;
    }

    public void setAmountOfHours(double amountOfHours) {
        this.amountOfHours = amountOfHours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
}
