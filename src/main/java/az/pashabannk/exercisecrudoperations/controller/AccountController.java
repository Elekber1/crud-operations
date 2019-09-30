package az.pashabannk.exercisecrudoperations.controller;

import az.pashabannk.exercisecrudoperations.model.AccountDTO;
import az.pashabannk.exercisecrudoperations.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/")
    public ResponseEntity<Object> findAllAccounts() {
        logger.info("findAllAccounts:");
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/byLogin/{login}")
    public ResponseEntity<Object> findByLogin(@PathVariable String login) {
        logger.info("findByLogin: {} " + login);
        return new ResponseEntity<>(accountService.findByLogin(login), HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Object> findById(@PathVariable
                                           @Min(value = 1, message = "id must be greater than or equal 1")
                                           @Max(value = 1000, message = "id must be lower than or equal to 1000")
                                                   Long id) {
        logger.info("findById {} : " + id);
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createAccount(@Valid
                                                @RequestBody AccountDTO accountDTO) {
        logger.info("createAccount: ");
        accountService.addAccount(accountDTO);
        return new ResponseEntity<>("Account is created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateAccount(@Valid
                                                @RequestBody AccountDTO accountDTO) {
        logger.info("updateAccount: ");
        accountService.updateAccount(accountDTO);
        return new ResponseEntity<>("Account is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccountById(@PathVariable
                                                    @Min(value = 1, message = "id must be greater than or equal 1")
                                                    @Max(value = 1000, message = "id must be lower than or equal to 1000")
                                                            Long id) {
        logger.info("deleteAccountById {}: " + id);
        accountService.removeAccount(id);
        return new ResponseEntity<>("Account is deleted successfully", HttpStatus.OK);
    }
}
