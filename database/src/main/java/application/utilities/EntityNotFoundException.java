package application.utilities;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entity) {
        super("The id: " + id + "of Entity" + entity.getTypeName() + "was not found");
    }
}
