package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // 🔹 INSERT
        Transaction tx = session.beginTransaction();

        Restaurant r = new Restaurant("ABC Hotel", new Date(), "OPEN");
        session.save(r);

        tx.commit();

        // 🔹 UPDATE using HQL
        session.beginTransaction();

        String hql = "update Restaurant set name = :name, status = :status where id = :id";

        Query q = session.createQuery(hql);
        q.setParameter("name", "Updated Hotel");
        q.setParameter("status", "CLOSED");
        q.setParameter("id", 1);

        int result = q.executeUpdate();

        session.getTransaction().commit();

        System.out.println("Updated Rows: " + result);

        session.close();
        factory.close();
    }
}