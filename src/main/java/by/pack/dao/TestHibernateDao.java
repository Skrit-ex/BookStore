package by.pack.dao;


import by.pack.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

@Component
public class TestHibernateDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public Optional<Book> findByGenre(String genre) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> query = currentSession.createQuery("from Book where genre =: genre", Book.class);
        query.setParameter("genre", genre);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<Book> findByNameBook(String nameBook) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> bookQuery = currentSession.createQuery("from Book where nameBook =: nameBook", Book.class);
        bookQuery.setParameter("nameBook", nameBook);
        try {
            return Optional.of(bookQuery.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
