package model.models.database.utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.Characteristic;
import model.models.database.utilities.dao.interfaces.ICharacteristicDAO;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CharacteristicsDAO extends ABaseDAO<Characteristic, Long> implements ICharacteristicDAO {

    private static CharacteristicsDAO instance;

    static {
        instance = new CharacteristicsDAO(Characteristic.class);
    }

    private CharacteristicsDAO(Class<Characteristic> type) {
        super(type);
    }

    public static CharacteristicsDAO getInstance() {
        return instance;
    }

    public Characteristic find(@NotNull String name) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Collection<Characteristic> find() {
        List<Characteristic> result = new ArrayList<>();
        List tmp = currentSession.createQuery("from Characteristic").list();
        tmp.forEach((ch) -> result.add((Characteristic) ch));
        return result;
    }

    public boolean delete() {
        Transaction transaction = currentSession.beginTransaction();
        try {
            currentSession.createQuery("delete from Characteristic").executeUpdate();
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
