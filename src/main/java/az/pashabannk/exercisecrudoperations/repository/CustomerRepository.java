package az.pashabannk.exercisecrudoperations.repository;

import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collection;

public interface CustomerRepository {

    void createCustomer(CustomerDTO customerDTO);

    Collection<CustomerDTO> updateCustomer(String customerId, CustomerDTO customerDTO);

    void deleteCustomerById(String customerId);

    Collection<CustomerDTO> findAllCustomers();

    CustomerDTO findCustomersById(String id);
}
