package az.pashabannk.exercisecrudoperations.repository;

import az.pashabannk.exercisecrudoperations.entities.CustomerDao;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerDao, Long> {
}
