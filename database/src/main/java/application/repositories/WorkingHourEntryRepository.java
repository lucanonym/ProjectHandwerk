package application.repositories;

import application.entities.WorkingHourEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingHourEntryRepository extends JpaRepository<WorkingHourEntry, Long> {
}
