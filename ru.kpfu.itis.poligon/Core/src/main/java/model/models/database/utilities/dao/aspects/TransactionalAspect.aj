package model.models.database.utilities.dao.aspects;

import model.models.database.utilities.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public aspect TransactionalAspect {

    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    boolean around(Object... args) : @annotation(model.models.database.utilities.dao.aspects.marks.Transactional){
        Transaction transaction = factory.getCurrentSession().beginTransaction();
        try {
            proceed(args);
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
