package az.pashabannk.exercisecrudoperations.scheduler;

import az.pashabannk.exercisecrudoperations.mapper.CustomerMapper;
import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import az.pashabannk.exercisecrudoperations.repository.CustomerRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Random;

@Repository
public class CustomerScheduler {

    CustomerRepository customerRepository;

    CustomerMapper customerMapper;

    public CustomerScheduler(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Scheduled(fixedRate = 20000)// 20 second
    public void createRandomCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
        Random random = new Random();
        int i = random.nextInt(7) + 3;
        System.out.println("Time: " + new Date());
        switch (i) {
            case 3:
                customerDTO.setName("Camil");
                customerDTO.setLastname("Camilov");
                customerRepository.save(customerMapper.customerDTOToCustomerDao(customerDTO));

                break;
            case 4:
                customerDTO.setName("Samir");
                customerDTO.setLastname("Samorov");
                customerRepository.save(customerMapper.customerDTOToCustomerDao(customerDTO));
                break;
            case 5:
                customerDTO.setName("Orxan");
                customerDTO.setLastname("Orxanov");
                customerRepository.save(customerMapper.customerDTOToCustomerDao(customerDTO));
                break;
            case 6:
                customerDTO.setName("Ali");
                customerDTO.setLastname("Aliyev");
                customerRepository.save(customerMapper.customerDTOToCustomerDao(customerDTO));
                break;
            case 7:
                customerDTO.setName("Senan");
                customerDTO.setLastname("Kazimov");
                customerRepository.save(customerMapper.customerDTOToCustomerDao(customerDTO));
                break;
            default:
        }
    }
}
