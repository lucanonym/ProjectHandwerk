package application.repositories;

import application.entities.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "buildingSites", path = "buildingSites")
public interface BuildingSiteRepository extends PagingAndSortingRepository<Project, Long> {
    Project findById(@Param("id") long id);
}