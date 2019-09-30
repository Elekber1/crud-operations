package az.pashabannk.exercisecrudoperations.repository;

import az.pashabannk.exercisecrudoperations.entities.AccountDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountDao, Long> {

    @Query("SELECT a FROM AccountDao a WHERE a.login= ?1")
    AccountDao findByCustomerByLogin(String login);
}
