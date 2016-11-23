package model.models.database.utilities.utils;

import model.models.database.entities.*;
import model.models.database.utilities.dao.implementations.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DAOFactory {
    private static DAOFactory instance;
    private static Map<Class<? extends AEntity>, ABaseDAO<? extends AEntity, ? extends Serializable>> daoEntities;
    
    static {
        daoEntities = new HashMap<>();
        instance = new DAOFactory();
    }
    
    private DAOFactory (){
        daoEntities.put(Characteristic.class, CharacteristicDAO.getInstance());
        daoEntities.put(Product.class, ProductDAO.getInstance());
        daoEntities.put(User.class, UserDAO.getInstance());
        daoEntities.put(CharacteristicValue.class, CharacteristicValueDAO.getInstance());
    }
    
    public static DAOFactory getInstance(){
        return instance;
    }

    public static void addDAO(Class<? extends AEntity> entityType, ABaseDAO<? extends AEntity, ? extends Serializable> dao){
        daoEntities.put(entityType, dao);
    }

    public ABaseDAO<? extends AEntity, ? extends Serializable> getDAOFor(Class<? extends AEntity> entity){
        return daoEntities.get(entity);
    }
}
