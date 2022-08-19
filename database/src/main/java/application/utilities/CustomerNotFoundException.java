package application.utilities;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("The id: " + id + " was not found");
    }
}
