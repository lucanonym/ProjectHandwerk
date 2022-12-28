package application.repositories;

import application.entities.Customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Customer findById(@Param("id") long id);

}