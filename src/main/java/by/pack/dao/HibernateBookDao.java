package by.pack.dao;

import by.pack.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.NoResultException;
import java.util.Optional;

@Component
public class HibernateBookDao {


    @Autowired
    private SessionFactory sessionFactory;


    public void save(Book book){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction= session.beginTransaction();
            session.save(book);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Optional<Book> findByAuthor(String nameAuthor){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> queryBook = currentSession.createQuery("from Book where nameAuthor = : nameAuthor", Book.class);
        queryBook.setParameter("nameAuthor", nameAuthor);
        try{
            return Optional.of(queryBook.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    public Optional<Book> findByNameBook(String nameBook){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> queryBook = currentSession.createQuery("from Book where nameBook= : nameBook", Book.class);
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
