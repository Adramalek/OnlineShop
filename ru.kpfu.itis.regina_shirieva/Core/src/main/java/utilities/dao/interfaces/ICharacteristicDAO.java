package utilities.dao.interfaces;

import com.sun.istack.internal.NotNull;
import models.Characteristic;

public interface ICharacteristicDAO extends IBaseDAO<Characteristic, Long> {
    Characteristic find(@NotNull String name);
}
