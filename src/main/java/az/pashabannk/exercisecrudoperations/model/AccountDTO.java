package az.pashabannk.exercisecrudoperations.model;

import az.pashabannk.exercisecrudoperations.entities.CustomerDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long id;
    @NotBlank(message = "Login is mandatory")
    private String login;
    @NotBlank(message = "Login is mandatory")
    private String password;
    private CustomerDao customerDao;
}
