package application.entities;



public enum Unit {
    HOURS("Std"),
    SQUAREMETERS("qm"),
    ROLLE("Roll"),
    KILOGRAMM("kg");



    private String stringRep;
    private Unit(String stringRep) {

    }
}
