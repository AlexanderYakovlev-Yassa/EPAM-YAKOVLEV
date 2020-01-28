package by.jwdc.finances.bean.impl;

import by.jwdc.finances.bean.BeanFactory;
import by.jwdc.finances.bean.IBeanLogic;
import by.jwdc.finances.bean.bean.DateTime;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanException;
import by.jwdc.finances.bean.exception.BeanInitialisationException;
import by.jwdc.finances.bean.exception.BeanNullParametersException;
import by.jwdc.finances.bean.exception.BeanWrongParameterException;
import by.jwdc.finances.dao.DAOFactory;
import by.jwdc.finances.dao.IDAOLogic;
import org.junit.Assert;
import org.junit.Test;

public class BeanLogicTest {

    private static BeanFactory factory = BeanFactory.getInstance();
    private static IBeanLogic BEAN_LOGIC = factory.getBeanLogic();
    private static DAOFactory daoFactory = DAOFactory.getInstance();
    private static IDAOLogic DAO_LOGIC = daoFactory.getDaoLogic();

        OperationType actual = null;
        String string = "earn +";

        try {
            actual = BEAN_LOGIC.stringToOperationType(string);
        } catch (BeanNullParametersException e) {
            System.out.println("NULL EXCEPTION");
        } catch (BeanWrongParameterException e) {
            System.out.println("NULL EXCEPTION");
        }

        OperationType excepted = new OperationType("earn", true);

        Assert.assertEquals(excepted, actual);

        actual = null;

        string = "earn+";

        try {
            actual = BEAN_LOGIC.stringToOperationType(string);
        } catch (BeanNullParametersException e) {
            System.out.println("NULL EXCEPTION");
        } catch (BeanWrongParameterException e) {
            System.out.println("NULL EXCEPTION");
        }

        excepted = null;

        Assert.assertEquals(excepted, actual);

    }

    @Test
    public void toFinanceOperationTest() {

        String string = "20-02-2020-20:00 earn 200";

        FinanceOperation actual = null;

        DateTime date = new DateTime(2020, 02, 20, 20, 00);
        OperationType operationType = new OperationType("earn", true);
        Double value = 200.0;
        FinanceOperation excepted = new FinanceOperation(date, operationType, value);

        try {
            actual = BEAN_LOGIC.stringToFinanceOperation(string);
        } catch (BeanNullParametersException e) {
            System.out.println("NULL EXCEPTION");
            e.printStackTrace();
        } catch (BeanWrongParameterException e) {
            System.out.println("NULL EXCEPTION");
            e.printStackTrace();
        } catch (BeanInitialisationException e) {
            e.printStackTrace();
        } catch (BeanException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void stringToDateTest() {

        String dateString = "20-01-2020-12:00";

        DateTime actual = null;
        DateTime excepted = new DateTime(2020,01,20,12,00);

        try {
            actual = BEAN_LOGIC.stringToDate(dateString);
        } catch (BeanWrongParameterException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(excepted, actual);
    }

}