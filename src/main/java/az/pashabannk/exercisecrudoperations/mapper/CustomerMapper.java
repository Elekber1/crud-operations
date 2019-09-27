package az.pashabannk.exercisecrudoperations.mapper;

import az.pashabannk.exercisecrudoperations.entities.CustomerDao;
import az.pashabannk.exercisecrudoperations.model.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    ModelMapper mapper = new ModelMapper();

    public CustomerDTO customerDaoToCustomerDTO(CustomerDao customerDao) {

        CustomerDTO customerDTO = mapper.map(customerDao, CustomerDTO.class);

        return customerDTO;
    }

    public CustomerDao customerDTOToCustomerDao(CustomerDTO customerDTO) {
        CustomerDao customerDao = mapper.map(customerDTO, CustomerDao.class);
        return customerDao;
    }

    public List<CustomerDTO> customerDaoListToCustomerDTOList(List<CustomerDao> customerDao) {
        List<CustomerDTO> customerDTOList = customerDao.stream().map(m -> customerDaoToCustomerDTO(m)).collect(Collectors.toList());
        return customerDTOList;
    }
}

