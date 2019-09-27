package az.pashabannk.exercisecrudoperations.service;

import az.pashabannk.exercisecrudoperations.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();

    CustomerDTO findOne(Long id);

    void updateCustomer(CustomerDTO customerDTO);

    void addCustomer(CustomerDTO customerDTO);

    void removeCustomer(Long id);

}
