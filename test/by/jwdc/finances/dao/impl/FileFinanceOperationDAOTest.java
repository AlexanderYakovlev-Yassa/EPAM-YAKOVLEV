package by.jwdc.finances.dao.impl;

import by.jwdc.finances.bean.FinanceOperation;
import by.jwdc.finances.dao.IFinanceOperationDAO;
import by.jwdc.finances.dao.exception.FinanceOperationDAOException;
import by.jwdc.finances.dao.factory.DAOFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FileFinanceOperationDAOTest {

    @Test
    public void getAllOperations() {

        DAOFactory daoFactory = DAOFactory.getInstance();
        IFinanceOperationDAO operationDAO = daoFactory.getOperationDAO();
        int expected = 3;

        ArrayList<FinanceOperation> financeOperationArrayList = null;

        try {
            financeOperationArrayList = operationDAO.getAllFinanceOperations();
        }catch (FinanceOperationDAOException e){
            System.out.println(e);
        }

        int actual = 0;

        if (financeOperationArrayList != null){
            actual = financeOperationArrayList.size();
        }

        Assert.assertEquals(expected, actual);
    }


}