package az.pashabannk.exercisecrudoperations.service.Impl;

import az.pashabannk.exercisecrudoperations.entities.AccountDao;
import az.pashabannk.exercisecrudoperations.mapper.AccountMapper;
import az.pashabannk.exercisecrudoperations.model.AccountDTO;
import az.pashabannk.exercisecrudoperations.repository.AccountRepository;
import az.pashabannk.exercisecrudoperations.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private AccountMapper accountMapper;

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountDTO> findAll() {
        logger.info("findAllAccounts Service: ");
        List<AccountDao> accountDaoList = (List<AccountDao>) accountRepository.findAll();
        return accountMapper.accountDaoListToAccountDTOList(accountDaoList);

    }

    @Override
    public AccountDTO findById(Long id) {
        logger.info("findAccountsById Service: ");
        AccountDao accountDao = accountRepository.findById(id).orElse(null);
        return accountMapper.accountDaoToAccountDTO(accountDao);
    }

    @Override
    public void updateAccount(AccountDTO accountDTO) {
        logger.info("updateAccount Service: ");
    accountRepository.save(accountMapper.accountDTOToAccountDao(accountDTO));
    }

    @Override
    public void addAccount(AccountDTO accountDTO) {
        logger.info("addAccount Service: ");
        accountRepository.save(accountMapper.accountDTOToAccountDao(accountDTO));
    }

    @Override
    public void removeAccount(Long id) {
        logger.info("removeAccount Service: ");
    accountRepository.deleteById(id);
    }

    @Override
    public AccountDTO findByLogin(String login) {
        logger.info("findByLogin Service: ");
        AccountDao accountDao = accountRepository.findByCustomerByLogin(login);
        return accountMapper.accountDaoToAccountDTO(accountDao);
    }
}
