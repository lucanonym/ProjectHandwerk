package application.entities;

public interface GenericEntity<T> {
    void update(T source);
    long getID();
}
