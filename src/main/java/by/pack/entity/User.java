package by.pack.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table (name = "usertab", uniqueConstraints = {
@UniqueConstraint(columnNames = "id"),
@UniqueConstraint(columnNames = "username"),
@UniqueConstraint(columnNames = "email")
})

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
