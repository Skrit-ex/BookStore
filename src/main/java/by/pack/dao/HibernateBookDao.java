package by.pack.dao;

import by.pack.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import java.util.Optional;

public class HibernateBookDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void save(Book book){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(book);
    }

    public Optional<Book> findByAuthor(String nameAuthor){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> queryBook = currentSession.createQuery("from books where nameAuthor = : nameAuthor", Book.class);
        queryBook.setParameter("nameAuthor", nameAuthor);
        try{
            return Optional.of(queryBook.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    public Optional<Book> findByNameBook(String nameBook){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> queryBook = currentSession.createQuery("from books where nameBook= : nameBook", Book.class);
        queryBook.setParameter("nameBook", nameBook);
        try {
            return Optional.of(queryBook.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    public Book findById(Long id){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Book.class, id);
    }
}
