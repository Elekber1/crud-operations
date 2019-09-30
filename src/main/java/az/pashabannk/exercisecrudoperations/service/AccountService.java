package az.pashabannk.exercisecrudoperations.service;

import az.pashabannk.exercisecrudoperations.model.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> findAll();

    AccountDTO findById(Long id);

    AccountDTO findByLogin(String login);

    void updateAccount(AccountDTO accountDTO);

    void addAccount(AccountDTO accountDTO);

    void removeAccount(Long id);


}
