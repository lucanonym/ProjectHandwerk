package application.repositories;


import application.entities.ProjectEntry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;




public interface ProjectEntriesRepository extends JpaRepository<ProjectEntry, Long> {
    ProjectEntry findById(@Param("id") long id);
}
