package by.pack.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "nameBook")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameBook;
    private String nameAuthor;
    private String lastNameAuthor;
    private String genre;
    private String description;

    public Book(String nameBook, String nameAuthor, String lastNameAuthor, String genre, String description) {
        this.nameBook = nameBook;
        this.nameAuthor = nameAuthor;
        this.lastNameAuthor = lastNameAuthor;
        this.genre = genre;
        this.description = description;
    }
}

