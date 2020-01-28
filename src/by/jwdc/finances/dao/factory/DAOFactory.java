package by.jwdc.finances.dao.factory;

import by.jwdc.finances.dao.IFinanceOperationDAO;
import by.jwdc.finances.dao.impl.FileFinanceOperationDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final IFinanceOperationDAO operationDAO = new FileFinanceOperationDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return instance;
    }

    public IFinanceOperationDAO getOperationDAO() {
        return operationDAO;
    }
}
