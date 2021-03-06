package org.austral.ing.lab1.repository;


import org.austral.ing.lab1.model.User;
import org.austral.ing.lab1.util.LangUtils;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

import static org.austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static org.austral.ing.lab1.util.LangUtils.checkedList;
import static org.austral.ing.lab1.util.Transactions.tx;

public class Users {

  public static Optional<User> findById(Long id){
    return tx(() ->
      Optional.of(currentEntityManager().find(User.class, id))
    );
  }

  public static Optional<User> findByEmail(String email){
    return tx(() -> LangUtils.<User>checkedList(currentEntityManager()
        .createQuery("SELECT u FROM User u WHERE u.email LIKE :email")
        .setParameter("email", email).getResultList()).stream()
      .findFirst()
    );
  }

  public static List<User> listAll() {
    return tx(() ->
            checkedList(currentEntityManager().createQuery("SELECT u FROM User u").getResultList())
    );
  }

  public static User persist(User user) {
    final EntityTransaction tx = currentEntityManager().getTransaction();

    try {
      tx.begin();

      currentEntityManager().persist(user);

      tx.commit();
      return user;
    } catch (Exception e) {
      tx.rollback();
      throw e;
    }
  }
}
