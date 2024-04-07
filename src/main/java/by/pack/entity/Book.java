package by.pack.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
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

    private Genre genre;

    public Book(String nameBook, String nameAuthor, String lastNameAuthor, Genre genre) {
        this.nameBook = nameBook;
        this.nameAuthor = nameAuthor;
        this.lastNameAuthor = lastNameAuthor;
        this.genre = genre;
    }
}
