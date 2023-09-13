package com.example.socialmedia.repository;

import com.example.socialmedia.data.HibernateSessionFactory;
import com.example.socialmedia.event.Event;
import com.example.socialmedia.event.EventAggregator;
import com.example.socialmedia.log.ILogger;
import com.example.socialmedia.log.LoggerFactory;
import com.example.socialmedia.model.User;
import org.hibernate.Session;

public class UserRepository {
    private static final ILogger logger = LoggerFactory.createLogger(UserRepository.class);
    private final HibernateSessionFactory sessionFactory;
    private final EventAggregator eventAggregator;

    public UserRepository(HibernateSessionFactory sessionFactory, EventAggregator eventAggregator) {
        this.sessionFactory = sessionFactory;
        this.eventAggregator = eventAggregator;
    }

    public void save(User user)
    {
        try(Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.persist(user);
            session.getTransaction().commit();
        }

        logger.info("[TR-001] User saved");
        eventAggregator.publish(Event.NEW_USER);
        logger.info("[TR-002] New User published");


    }

}
