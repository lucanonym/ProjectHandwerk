package application.repositories;

import application.entities.MaterialEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialEntryRepository extends JpaRepository<MaterialEntry, Long> {

}
