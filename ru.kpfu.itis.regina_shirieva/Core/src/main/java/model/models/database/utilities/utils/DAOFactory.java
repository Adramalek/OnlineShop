package model.models.database.utilities.utils;

import model.models.database.entities.AEntity;
import model.models.database.entities.Characteristic;
import model.models.database.entities.Product;
import model.models.database.entities.User;
import model.models.database.utilities.dao.implementations.CharacteristicsDAO;
import model.models.database.utilities.dao.implementations.ProductDAO;
import model.models.database.utilities.dao.implementations.UserDAO;
import model.models.database.utilities.dao.implementations.ABaseDAO;
import models.*;

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
        daoEntities.put(Characteristic.class, CharacteristicsDAO.getInstance());
        daoEntities.put(Product.class, ProductDAO.getInstance());
        daoEntities.put(User.class, UserDAO.getInstance());
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
