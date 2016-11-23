package model.models.database.utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.Characteristic;
import model.models.database.utilities.dao.aspects.marks.Transactional;
import model.models.database.utilities.dao.interfaces.ICharacteristicDAO;

import java.util.ArrayList;
import java.util.Collection;

public class CharacteristicDAO extends ABaseDAO<Characteristic, Long> implements ICharacteristicDAO {

    private static CharacteristicDAO instance;

    static {
        instance = new CharacteristicDAO(Characteristic.class);
    }

    private CharacteristicDAO(Class<Characteristic> type) {
        super(type);
    }

    public static CharacteristicDAO getInstance() {
        return instance;
    }

    public Characteristic find(@NotNull String name) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Collection<Characteristic> find() {
        Collection<Characteristic> result = new ArrayList<>();
        currentSession.createQuery("from Characteristic").list().forEach((ch) -> result.add((Characteristic) ch));
        return result;
    }

    @Override
    @Transactional
    public boolean delete() {
        currentSession.createQuery("delete from Characteristic").executeUpdate();
        return true;
    }

    @Override
    @Transactional
    public boolean delete(@NotNull Collection<Characteristic> entities) {
        currentSession.createQuery("delete from Characteristic ch where ch in :characteristics")
                .setParameter("characteristics",entities).executeUpdate();
        return true;
    }
}
