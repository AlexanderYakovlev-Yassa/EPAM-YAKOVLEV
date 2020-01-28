package by.jwdc.finances.bean.impl;

import by.jwdc.finances.bean.BeanFactory;
import by.jwdc.finances.bean.IBeanLogic;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanException;
import by.jwdc.finances.bean.exception.BeanInitialisationException;
import by.jwdc.finances.bean.exception.BeanNullParametersException;
import by.jwdc.finances.bean.exception.BeanWrongParameterException;
import by.jwdc.finances.dao.DAOFactory;
import by.jwdc.finances.dao.IDAOLogic;
import by.jwdc.finances.dao.exception.DAOException;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashSet;

public class BeanLogicTest {

    private static BeanFactory factory = BeanFactory.getInstance();
    private static IBeanLogic BEAN_LOGIC = factory.getBeanLogic();
    private static DAOFactory daoFactory = DAOFactory.getInstance();
    private static IDAOLogic DAO_LOGIC = daoFactory.getDaoLogic();




    
}