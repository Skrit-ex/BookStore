package by.pack.dao;

import by.pack.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

import java.util.List;
import java.util.Optional;

@Component
public class HibernateBookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveAddBook(Book book){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(book);
    }


    @Transactional
    public Optional<Book> findByBookName(String nameBook) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> bookQuery = currentSession.createQuery("from Book where nameBook =: nameBook", Book.class);
        bookQuery.setParameter("nameBook", nameBook);
        try {
            return Optional.of(bookQuery.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<Book> findByNameAuthor(String nameAuthor) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> bookQuery = currentSession.createQuery("from Book where nameAuthor =: nameAuthor", Book.class);
        bookQuery.setParameter("nameAuthor", nameAuthor);
        try {
            return Optional.of(bookQuery.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<Book> findByGenre(String genre){
        Session currentSessionGenre = sessionFactory.getCurrentSession();
        Query<Book> bookQuery = currentSessionGenre.createQuery("from Book where genre =: genre", Book.class);
        bookQuery.setParameter("genre", genre);
        try {
            return Optional.of(bookQuery.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Transactional
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

    @Transactional
    public void update(Book book){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Error with update : " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public Book findByLineCount(Long id) {
        Session session = sessionFactory.openSession();
        try {
            Query<Book> query = session.createQuery("FROM Book WHERE id = :id", Book.class);
            query.setParameter("id", id);
            return query.uniqueResult(); // Return book or null
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при поиске книги: " + e.getMessage());
        } finally {
            session.close();
        }
    }

        @Transactional
        public List<Book> findAll(){
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from Book", Book.class).getResultList();
        }
}
