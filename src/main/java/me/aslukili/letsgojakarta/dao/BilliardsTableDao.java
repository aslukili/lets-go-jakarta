package me.aslukili.letsgojakarta.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import me.aslukili.letsgojakarta.entities.BilliardsTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BilliardsTableDao {
  public void saveBilliardsTable(BilliardsTable billiardsTable) {
    // TODO replace this with session factory !!! and use save instead of merge
    Transaction transaction = null;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    try  {
      transaction = (Transaction) entityManager.getTransaction();
      transaction.begin();
      entityManager.merge(billiardsTable);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }
}
