package by.jwdc.finances.bean.factory;

import by.jwdc.finances.bean.FinanceOperation;
import by.jwdc.finances.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanFactoryException;
import by.jwdc.finances.bean.validator.Validator;

import java.util.GregorianCalendar;

public class BeanFactory {

    private static final BeanFactory instance = new BeanFactory();

    private BeanFactory() {
    }

    public static BeanFactory getInstance() {
        return instance;
    }

    public FinanceOperation createOperation(String record) throws BeanFactoryException {

        if (record == null) {
            return null;
        }

        String[] field = record.split(" ");

        GregorianCalendar date = toDate(field[0]);
        if (date == null) {
            throw new BeanFactoryException("Wrong financeOperation date");
        }

        OperationType type = toType(field[1], field[2]);
        if (type == null){
            throw new BeanFactoryException("Wrong financeOperation type");
        }

        double value = 0;
        try {
            value = Double.parseDouble(field[3]);
        } catch (NullPointerException | NumberFormatException e) {
            throw new BeanFactoryException("Wrong financeOperation value", e);
        }

        FinanceOperation financeOperation = new FinanceOperation(date, type, value);

        return financeOperation;
    }

    private static OperationType toType(String name, String inCome) {

        if (name == null || inCome == null) {
            return null;
        }

        String typeName = name;
        boolean typeIsIncome;

        switch (inCome){
            case "income": {
                typeIsIncome = true;
                break;
            }
            case "expenses": {
                typeIsIncome = false;
                break;
            }
            default: {
                return null;
            }
        }

        OperationType type = new OperationType(typeName, typeIsIncome);

        return type;
    }

    private static GregorianCalendar toDate(String string) {

        Validator validator = Validator.getInstance();

        GregorianCalendar res = null;

        if (string == null) {
            return null;
        }
        if (string.length() != 12) {
            return null;
        }
        if (!isAllSymbolDigit(string)) {
            return null;
        }

        int year = Integer.parseInt(string.substring(0, 4));
        int month = Integer.parseInt(string.substring(4, 6));
        int day = Integer.parseInt(string.substring(6, 8));
        int hour = Integer.parseInt(string.substring(8, 10));
        int min = Integer.parseInt(string.substring(10));

        if (!validator.isDateCorrect(year, month, day, hour, min)){
            return null;
        }

        return new GregorianCalendar(year, month, day, hour, min);
    }

    private static boolean isAllSymbolDigit(String string) {
        char[] chars = string.toCharArray();
        int i = 0;
        boolean res = true;
        while (i < chars.length) {

            if (!(Character.isDigit(chars[i]))) {
                res = false;
                break;
            }

            i++;
        }

        return res;
    }
}
