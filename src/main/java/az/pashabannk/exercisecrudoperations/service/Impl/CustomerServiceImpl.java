package az.pashabannk.exercisecrudoperations.service.Impl;

import az.pashabannk.exercisecrudoperations.entities.AccountDao;
import az.pashabannk.exercisecrudoperations.entities.CustomerDao;
import az.pashabannk.exercisecrudoperations.mapper.AccountMapper;
import az.pashabannk.exercisecrudoperations.mapper.CustomerMapper;
import az.pashabannk.exercisecrudoperations.model.AccountDTO;
import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import az.pashabannk.exercisecrudoperations.repository.CustomerRepository;
import az.pashabannk.exercisecrudoperations.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;


    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> findAll() {
        logger.info("findAllCustomers Service: ");
        List<CustomerDao> customerDaos = (List<CustomerDao>) customerRepository.findAll();
        return customerMapper.customerDaoListToCustomerDTOList(customerDaos);
    }

    @Override
    public CustomerDTO findOne(Long id) {
        CustomerDao customerDao = customerRepository.findById(id).orElse(null);
        logger.info("findCustomersById Service: ");
        return customerMapper.customerDaoToCustomerDTO(customerDao);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        logger.info("updateCustomer Service: ");
        customerRepository.save(customerMapper.customerDTOToCustomerDao(customerDTO));
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        logger.info("addCustomer Service: ");
        customerRepository.save(customerMapper.customerDTOToCustomerDao(customerDTO));
    }

    @Override
    public void removeCustomer(Long id) {
        logger.info("removeCustomerById Service: ");
        customerRepository.deleteById(id);
    }
}
