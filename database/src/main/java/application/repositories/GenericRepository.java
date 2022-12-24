package application.repositories;

import application.entities.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends GenericEntity<T>> extends JpaRepository<T, Long> {
}
