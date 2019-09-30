package az.pashabannk.exercisecrudoperations.mapper;

import az.pashabannk.exercisecrudoperations.entities.AccountDao;
import az.pashabannk.exercisecrudoperations.model.AccountDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    ModelMapper mapper = new ModelMapper();

    public AccountDTO accountDaoToAccountDTO(AccountDao accountDao) {
        AccountDTO accountDTO = mapper.map(accountDao, AccountDTO.class);
        return accountDTO;
    }

    public AccountDao accountDTOToAccountDao(AccountDTO accountDTO) {
        AccountDao accountDao = mapper.map(accountDTO, AccountDao.class);
        return accountDao;
    }

    public List<AccountDTO> accountDaoListToAccountDTOList(List<AccountDao> accountDao) {
        List<AccountDTO> accountDTOList = accountDao.stream().map(m -> accountDaoToAccountDTO(m)).collect(Collectors.toList());
        return accountDTOList;
    }

}
