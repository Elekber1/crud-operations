package az.pashabannk.exercisecrudoperations.controller;

import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import az.pashabannk.exercisecrudoperations.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/")
    public ResponseEntity<Object> findAllCustomers() {
        logger.info("findAllCustomers: ");
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findCustomersById(@PathVariable
                                                    @Min(value = 1, message = "id must be greater than or equal 1")
                                                    @Max(value = 1000, message = "id must be lower than or equal to 1000")
                                                            Long id) {
        logger.info("findCustomersById: ");
        return new ResponseEntity<>(customerService.findOne(id), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<Object> createCustomer(@Valid
                                                 @RequestBody CustomerDTO customerDTO) {
        logger.info("createProduct: ");
        customerService.addCustomer(customerDTO);
        System.out.println("Creating customer... ");

        return new ResponseEntity<>("Customer is created successfully", HttpStatus.CREATED);
    }


    @PutMapping("/")
    public ResponseEntity<Object> updateCustomer(@Valid
                                                 @RequestBody CustomerDTO customerDTO) {
        logger.info("updateCustomer: ");
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity<>("Customer is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomerById(@PathVariable
                                                     @Min(value = 1, message = "id must be greater than or equal 1")
                                                     @Max(value = 1000, message = "id must be lower than or equal to 1000")
                                                             Long id) {
        logger.info("deleteCustomerById: ");
        customerService.removeCustomer(id);
        return new ResponseEntity<>("Customer is deleted successsfully", HttpStatus.OK);
    }
}
