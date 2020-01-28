package by.jwdc.finances.dao.impl;

import by.jwdc.finances.bean.FinanceOperation;
import by.jwdc.finances.bean.exception.BeanFactoryException;
import by.jwdc.finances.bean.factory.BeanFactory;
import by.jwdc.finances.dao.IFinanceOperationDAO;
import by.jwdc.finances.dao.exception.DaoUtilException;
import by.jwdc.finances.dao.exception.FinanceOperationDAOException;
import by.jwdc.finances.dao.util.FileUtil;

import java.io.File;
import java.util.ArrayList;

public class FileFinanceOperationDAO implements IFinanceOperationDAO {

    private static final File financeMovementFile = new File("src\\by\\jwdc\\finances\\data\\file\\Finance_movement.dat");

    @Override
    public ArrayList<FinanceOperation> getAllFinanceOperations() throws FinanceOperationDAOException {

        BeanFactory factory = BeanFactory.getInstance();

        ArrayList<String> recordsList;

        try {
            recordsList = FileUtil.readFile(financeMovementFile);
        } catch (DaoUtilException e) {
            throw new FinanceOperationDAOException("Data source error", e);
        }

        ArrayList<FinanceOperation> financeOperations = new ArrayList<FinanceOperation>();

        //turn all records to "FinanceOperation" objects
        FinanceOperation tempFinanceOperation = null;
        for (String s : recordsList){
            try {
                tempFinanceOperation = factory.createOperation(s);
            } catch (BeanFactoryException e){
                throw new FinanceOperationDAOException("Data conversion error", e);
            }

            financeOperations.add(tempFinanceOperation);
        }

        return financeOperations;
    }
}
