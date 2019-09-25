package az.pashabannk.exercisecrudoperations.controller;

import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import az.pashabannk.exercisecrudoperations.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/findAllCustomers")
    public ResponseEntity<Object> findAllCustomers() {
        logger.info("findAllCustomers: ");
        return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createProduct(@Valid @RequestBody CustomerDTO customerDTO) {
        logger.info("createProduct: ");
        customerService.createCustomer(customerDTO);
        System.out.println("Creating customer... ");


        return new ResponseEntity<>("Customer is created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> findCustomersById(@PathVariable
                                                    @Min(value = 1, message = "id must be greater than or equal 1")
                                                    @Max(value = 1000, message = "id must be lower than or equal to 1000")
                                                            String customerId) {
        logger.info("findCustomersById: ");
        return new ResponseEntity<>(customerService.findCustomersById(customerId), HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> updateCustomer(@PathVariable
                                                 @Min(value = 1, message = "id must be greater than or equal 1")
                                                 @Max(value = 1000, message = "id must be lower than or equal to 1000")
                                                         String customerId,
                                                 @Valid @RequestBody CustomerDTO customerDTO) {
        logger.info("updateCustomer: ");
        return new ResponseEntity<>(customerService.updateCustomer(customerId, customerDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomerById(@PathVariable
                                                     @Min(value = 1, message = "id must be greater than or equal 1")
                                                     @Max(value = 1000, message = "id must be lower than or equal to 1000")
                                                             String customerId) {
        logger.info("deleteCustomerById: ");
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>("Customer is deleted successsfully", HttpStatus.OK);
    }
}
