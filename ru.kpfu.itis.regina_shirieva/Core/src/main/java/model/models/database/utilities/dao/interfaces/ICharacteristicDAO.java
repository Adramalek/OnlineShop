package model.models.database.utilities.dao.interfaces;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.Characteristic;

public interface ICharacteristicDAO extends IBaseDAO<Characteristic, Long> {
    Characteristic find(@NotNull String name);
}
