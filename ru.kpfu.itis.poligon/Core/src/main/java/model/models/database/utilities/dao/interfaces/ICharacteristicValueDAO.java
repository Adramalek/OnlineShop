package model.models.database.utilities.dao.interfaces;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.Characteristic;
import model.models.database.entities.CharacteristicValue;

import java.util.Collection;

public interface ICharacteristicValueDAO extends IBaseDAO<CharacteristicValue, Long> {
    Collection<CharacteristicValue> find(@NotNull Characteristic characteristic);
}
