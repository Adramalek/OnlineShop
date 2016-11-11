package utilities.utils;

import models.AEntity;
import utilities.dao.implementations.ABaseDAO;
import utilities.dao.implementations.CharacteristicsDAO;
import utilities.dao.implementations.ProductDAO;
import utilities.dao.implementations.UserDAO;
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
        daoEntities.put(Characteristic.class,CharacteristicsDAO.getInstance());
        daoEntities.put(Product.class,ProductDAO.getInstance());
        daoEntities.put(User.class,UserDAO.getInstance());
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
