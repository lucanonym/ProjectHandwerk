package application.controller;


import application.entities.Customer;
import application.repositories.CustomerRepository;
import application.utilities.CustomerModelAssembler;

import application.utilities.EntityNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/customers")
public class CustomerController extends GenericController<Customer> {
    private final CustomerModelAssembler assembler;

    public CustomerController(CustomerRepository repo, CustomerModelAssembler assembler) {
        super(repo, Customer.class);
        this.assembler = assembler;

    }

    public CollectionModel<EntityModel<Customer>> all() {
        List<EntityModel<Customer>> customers = super.getAllEntities().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(customers,
                linkTo(methodOn(CustomerController.class).getAllEntities()).withSelfRel());
    }


    @PostMapping("/customers")
    public EntityModel<Customer> newCustomer(@RequestBody Customer newCustomer) {
        return assembler.toModel(super.newEntitiy(newCustomer));
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> one(@PathVariable Long id) {
        return assembler.toModel(super.getOne(id));
    }

    @PutMapping("/customers/{id}")
    public EntityModel<Customer> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        try{
            super.getOne(id).update(newCustomer);
        } catch (EntityNotFoundException e) {
            newCustomer.setId(id);
            super.save(newCustomer);
        }
        return assembler.toModel(newCustomer);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        super.deleteEntity(id);
    }
}
