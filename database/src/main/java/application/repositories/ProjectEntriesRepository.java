package application.repositories;

import application.entities.ProjectEntry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "projectEntries", path = "projectEntries")
public interface ProjectEntriesRepository extends PagingAndSortingRepository<ProjectEntry, Long> {
    ProjectEntry findBy(@Param ("id") long id);
}
