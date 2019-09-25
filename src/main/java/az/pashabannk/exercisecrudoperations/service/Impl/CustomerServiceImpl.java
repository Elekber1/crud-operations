package az.pashabannk.exercisecrudoperations.service.Impl;

import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import az.pashabannk.exercisecrudoperations.repository.CustomerRepository;
import az.pashabannk.exercisecrudoperations.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        logger.info("createCustomer Service: ");
        customerRepository.createCustomer(customerDTO);
    }

    @Override
    public Collection<CustomerDTO> updateCustomer(String customerId, CustomerDTO customerDTO) {
        logger.info("updateCustomer Service: ");

        return customerRepository.updateCustomer(customerId, customerDTO);
    }

    @Override
    public void deleteCustomerById(String customerId) {
        logger.info("deleteCustomerById Service: ");

        customerRepository.deleteCustomerById(customerId);
    }

    @Override
    public Collection<CustomerDTO> findAllCustomers() {
        logger.info("findAllCustomers Service: ");

        return customerRepository.findAllCustomers();
    }

    @Override
    public CustomerDTO findCustomersById(String customerId) {
        logger.info("findCustomersById Service: ");

        return customerRepository.findCustomersById(customerId);
    }
}
