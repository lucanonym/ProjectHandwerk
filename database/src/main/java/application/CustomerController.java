package application;


import application.entities.Customer;
import application.utilities.CustomerNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repo) {
        this.repository = repo;
    }

    //TODO Maybe public Keyword doesnt work test it

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/customer")
    public List<Customer> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    @GetMapping("/customers/{id}")
    public Customer one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    public Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return repository.findById(id)
                .map(customer -> {
                    customer.setAddress(newCustomer.getAddress());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setPreName(newCustomer.getPreName());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
