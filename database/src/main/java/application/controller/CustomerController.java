package application.controller;


import application.entities.Customer;
import application.repositories.CustomerRepository;
import application.utilities.CustomerModelAssembler;
import application.utilities.CustomerNotFoundException;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {
    private final CustomerRepository repository;
    private final CustomerModelAssembler assembler;

    public CustomerController(CustomerRepository repo, CustomerModelAssembler assembler) {
        this.assembler = assembler;
        this.repository = repo;
    }



    @GetMapping("/customer")
    public CollectionModel<EntityModel<Customer>> all() {
        List<EntityModel<Customer>> customers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(customers,
                linkTo(methodOn(CustomerController.class).all()).withSelfRel());
    }


    @PostMapping("/customers")
    public EntityModel<Customer> newCustomer(@RequestBody Customer newCustomer) {
        return assembler.toModel(repository.save(newCustomer));
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> one(@PathVariable Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        return assembler.toModel(customer);
    }

    @PutMapping("/customers/{id}")
    public EntityModel<Customer> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return repository.findById(id)
                .map(customer -> {
                    customer.setAddress(newCustomer.getAddress());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setPreName(newCustomer.getPreName());
                    return assembler.toModel(repository.save(customer));
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return assembler.toModel(repository.save(newCustomer));
                });
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
