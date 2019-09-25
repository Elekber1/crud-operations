package az.pashabannk.exercisecrudoperations.repository.Impl;

import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import az.pashabannk.exercisecrudoperations.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static Map<String, CustomerDTO> customerMap = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

    @Scheduled(fixedRate = 20000)// 20 second
    public void createRandomCustomer() {
        Random random = new Random();
        int i = random.nextInt(7) + 3;
        System.out.println("Time: " + new Date());
        switch (i) {
            case 3:
                customerMap.put("3", new CustomerDTO("3", "Camil", "Camilov"));
                break;
            case 4:
                customerMap.put("4", new CustomerDTO("4", "Samir", "Samirov"));
                break;
            case 5:
                customerMap.put("5", new CustomerDTO("5", "Orxan", "Orxanov"));
                break;
            case 6:
                customerMap.put("6", new CustomerDTO("6", "Ali", "Aliyev"));
                break;
            case 7:
                customerMap.put("7", new CustomerDTO("7", "Senan", "Kazimov"));
                break;
            default:
        }
    }

    static {
        CustomerDTO customer = new CustomerDTO();

        customer.setId("1");
        customer.setName("Alakbar");
        customer.setLastname("Hajizada");
        customerMap.put(customer.getId(), customer);

        CustomerDTO customer2 = new CustomerDTO();

        customer2.setId("2");
        customer2.setName("Samir");
        customer2.setLastname("Aliyev");
        customerMap.put(customer2.getId(), customer2);
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        logger.info("createCustomer Repository: ");
        customerMap.put(customerDTO.getId(), customerDTO);
    }

    @Override
    public Collection<CustomerDTO> updateCustomer(String customerId, CustomerDTO customerDTO) {
        logger.info("updateCustomer Repository: ");
        customerMap.remove(customerId);
        customerDTO.setId(customerId);
        customerMap.put(customerId, customerDTO);
        return customerMap.values();
    }

    @Override
    public void deleteCustomerById(String customerId) {
        logger.info("deleteCustomerById Repository: ");

        customerMap.remove(customerId);
    }


    @Override
    public Collection<CustomerDTO> findAllCustomers() {
        logger.info("findAllCustomers Repository: ");

        return customerMap.values();
    }

    @Override
    public CustomerDTO findCustomersById(String customerId) {
        logger.info("findCustomersById Repository: ");

        return customerMap.get(customerId);
    }
}
