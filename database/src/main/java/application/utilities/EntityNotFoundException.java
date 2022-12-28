package application.utilities;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("The id: " + id + "of Entity" + "was not found");
    }
}
