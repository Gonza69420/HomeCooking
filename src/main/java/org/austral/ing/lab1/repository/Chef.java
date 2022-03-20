package org.austral.ing.lab1.repository;

import org.austral.ing.lab1.model.User;
import org.austral.ing.lab1.util.LangUtils;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

import static org.austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static org.austral.ing.lab1.util.LangUtils.checkedList;
import static org.austral.ing.lab1.util.Transactions.tx;

public class Chef {


    public static Optional<Chef> findById(Long id){
        return tx(() ->
                Optional.of(currentEntityManager().find(Chef.class, id))
        );
    }

    public static Optional<Chef> findByEmail(String email){
        return tx(() -> LangUtils.<Chef>checkedList(currentEntityManager()
                        .createQuery("SELECT u FROM Chef u WHERE u.email LIKE :email")
                        .setParameter("email", email).getResultList()).stream()
                .findFirst()
        );
    }

    public static List<Chef> listAll() {
        return tx(() ->
                checkedList(currentEntityManager().createQuery("SELECT u FROM Chef u").getResultList())
        );
    }

    public static Chef persist(Chef chef) {
        final EntityTransaction tx = currentEntityManager().getTransaction();

        try {
            tx.begin();

            currentEntityManager().persist(chef);

            tx.commit();
            return chef;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
