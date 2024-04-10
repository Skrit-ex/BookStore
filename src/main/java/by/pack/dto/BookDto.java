package by.pack.dto;

import by.pack.entity.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class BookDto {

    @Pattern(regexp = "([A-Za-z])*" , message = "The nameBook isn't correct, try again")
    private String nameBook;

    @Pattern(regexp = "([A-Za-z])*" , message = "The nameAuthor isn't correct, try again")
    private String nameAuthor;

    @Pattern(regexp = "([A-Za-z]*)" , message = "The lastNameAuthor isn't correct, try again")
    private String lastNameAuthor;

    private String genre;

    private Long UserId;
}
