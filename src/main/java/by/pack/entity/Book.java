package by.pack.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameBook;

    private String NameAuthor;

    private String LastNameAuthor;

    private String Genre;
}
