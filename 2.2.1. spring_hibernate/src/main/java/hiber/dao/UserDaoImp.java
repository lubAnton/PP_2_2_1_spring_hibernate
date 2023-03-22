package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User returnUserToModelCar(int series, String model) {
      String hql = "from User as user LEFT JOIN FETCH user.car WHERE user.car.series=" +series+" AND user.car.model='"+model+ "'";
      System.out.println(hql);
      Query <User> query = sessionFactory.getCurrentSession().createQuery(hql);
      return query.uniqueResult();
   }
}
