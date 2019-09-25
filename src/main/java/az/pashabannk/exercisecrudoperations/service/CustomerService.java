package az.pashabannk.exercisecrudoperations.service;

import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collection;

public interface CustomerService {

    void createCustomer(CustomerDTO customerDTO);

    Collection<CustomerDTO> updateCustomer(String customerId, CustomerDTO customerDTO);

    void deleteCustomerById(String customerId);

    Collection<CustomerDTO> findAllCustomers();

    CustomerDTO findCustomersById(String customerId);
}
