package model.models.database.utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.Characteristic;
import model.models.database.entities.CharacteristicValue;
import model.models.database.utilities.dao.aspects.marks.Transactional;
import model.models.database.utilities.dao.interfaces.ICharacteristicValueDAO;

import java.util.ArrayList;
import java.util.Collection;

public class CharacteristicValueDAO extends ABaseDAO<CharacteristicValue, Long> implements ICharacteristicValueDAO {
    private static CharacteristicValueDAO instance;

    static {
        instance = new CharacteristicValueDAO(CharacteristicValue.class);
    }

    private CharacteristicValueDAO(Class<CharacteristicValue> type) {
        super(type);
    }

    public static CharacteristicValueDAO getInstance() {
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<CharacteristicValue> find() {
        Collection<CharacteristicValue> result = new ArrayList<>();
        currentSession.createQuery("from CharacteristicValue").list().forEach((ch) -> result.add((CharacteristicValue)ch));
        return result;
    }

    @Override
    @Transactional
    public boolean delete() {
        currentSession.createQuery("delete from CharacteristicValue").executeUpdate();
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<CharacteristicValue> find(@NotNull Characteristic characteristic) {
        Collection<CharacteristicValue> result = new ArrayList<>();
        currentSession.createQuery("from CharacteristicValue ch where ch.characteristic=:characteristic")
                .setParameter("characteristic",characteristic).list().forEach((o) -> result.add((CharacteristicValue)o));
        return result;
    }

    @Override
    @Transactional
    public boolean delete(@NotNull Collection<CharacteristicValue> entities) {
        currentSession.createQuery("delete from CharacteristicValue chv where chv in :values")
                .setParameter("values",entities).executeUpdate();
        return true;
    }
}
