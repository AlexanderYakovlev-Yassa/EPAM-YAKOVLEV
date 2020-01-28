package by.jwdc.finances.bean.factory;

import by.jwdc.finances.bean.FinanceOperation;
import by.jwdc.finances.bean.exception.BeanFactoryException;
import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

public class BeanFactoryTest {

    private  static final GregorianCalendar DATE =
            new GregorianCalendar(2020, 1, 9, 8, 50);
    private static final String TYPE = "work";
    private static final double VALUE = 205.36;

    @Test
    public void createOperationRightDate() {
        BeanFactory factory = BeanFactory.getInstance();
        String record = "202001090850 work expenses 205.36";
        FinanceOperation financeOperation = null;
        try {
            financeOperation = factory.createOperation(record);
        } catch (BeanFactoryException e){
            //nothing
        }

        GregorianCalendar expected = DATE;
        GregorianCalendar actual = financeOperation.getDate();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createOperationRightTypeName() {
        BeanFactory factory = BeanFactory.getInstance();
        String record = "202001090850 work expenses 205.36";
        FinanceOperation financeOperation = null;
        try {
            financeOperation = factory.createOperation(record);
        } catch (BeanFactoryException e){
            //nothing
        }

        String expected = TYPE;
        String actual = financeOperation.getType().getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createOperationRightTypeIsIncom() {
        BeanFactory factory = BeanFactory.getInstance();
        String record = "202001090850 work expenses 205.36";
        FinanceOperation financeOperation = null;
        try {
            financeOperation = factory.createOperation(record);
        } catch (BeanFactoryException e){
            //nothing
        }

        boolean expected = false;
        boolean actual = financeOperation.getType().isInComeOperation();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createOperationRightTypeIsInComeTrue() {
        BeanFactory factory = BeanFactory.getInstance();
        String record = "202001090850 work income 205.36";
        FinanceOperation financeOperation = null;
        try {
            financeOperation = factory.createOperation(record);
        } catch (BeanFactoryException e){
            //nothing
        }

        boolean expected = true;
        boolean actual = financeOperation.getType().isInComeOperation();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createOperationException() {
        BeanFactory factory = BeanFactory.getInstance();
        String record = "202011860850 work income 205.36";

        Class expected = BeanFactoryException.class;
        Class actual = null;

        try {
            FinanceOperation financeOperation = factory.createOperation(record);
        }catch (Exception e){
            actual = e.getClass();
        }

        Assert.assertEquals(expected, actual);
    }
}