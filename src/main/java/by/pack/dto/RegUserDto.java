package by.pack.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RegUserDto {

    @Pattern(regexp = "([A-Za-z])*", message = "The firstname isn't correct, try again")
    private String firstname;

    @Pattern(regexp = "([A-Za-z])*", message = "The lastname isn't correct, try again")
    private String lastname;

    @Pattern(regexp = "([A-Za-z])*", message = "The username isn't correct, try again")
    private String username;

    @Pattern(regexp = "(^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$)", message = "The Email isn't correct, try again")
    private String email;

    @Pattern(regexp = "(^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$)" , message = "Password isn't correct, try again")
    private String password;
}
