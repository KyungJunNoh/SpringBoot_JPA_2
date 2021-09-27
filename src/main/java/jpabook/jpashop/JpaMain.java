package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
            Order order = new Order();
            order.addOrderItem(new OrderItem());
            tx.commit(); // 한 트랜잭션 종료
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close(); // em 종료
        }

        emf.close(); // emf 종료
    }
}
