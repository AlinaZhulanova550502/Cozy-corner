package bsuir.vintsarevich.buisness.account.service.impl;

import bsuir.vintsarevich.buisness.account.service.IAccountService;
import bsuir.vintsarevich.entity.Account;
import bsuir.vintsarevich.exception.dao.DaoException;
import bsuir.vintsarevich.exception.service.ServiceException;
import bsuir.vintsarevich.factory.dao.DaoFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * class AccountService created for preparation data before sending queries to database table "account"
 */
public class AccountService implements IAccountService {

    private static final Logger LOGGER = Logger.getLogger(AccountService.class);
    private DaoFactory daoFactory = DaoFactory.getInstance();


    /**
     * @param clientId
     * @return Double
     * @throws ServiceException
     */
    @Override
    public Double getCashById(Integer clientId) throws ServiceException {
        LOGGER.log(Level.DEBUG, "Account service: start get cash");
        try {
            LOGGER.log(Level.DEBUG, "Account service: finish get cash");
            return daoFactory.getAccountDao().getCashById(clientId);
        } catch (DaoException e) {
            throw new ServiceException(this.getClass() + ":" + e.getMessage());
        }
    }

    /**
     * @param clientId
     * @return boolean
     * @throws ServiceException
     */
    @Override
    public boolean addAccount(Integer clientId) throws ServiceException {
        LOGGER.log(Level.DEBUG, "Account service: start add account");
        Account account;
        Integer accountNumber;
        try {
            do {
                accountNumber = (int) (Math.random() * 100000);
            } while (daoFactory.getAccountDao().checkAccountNumber(accountNumber));
            account = new Account(accountNumber, 0.0, clientId);
            LOGGER.log(Level.DEBUG, "Account service: finish add account");
            return daoFactory.getAccountDao().addAccount(account);
        } catch (DaoException e) {
            throw new ServiceException(this.getClass() + ":" + e.getMessage());
        }
    }

    /**
     * @param clientId
     * @param orderCostNew
     * @return boolean
     * @throws ServiceException
     */
    @Override
    public boolean editAccount(Integer clientId, Double orderCostNew) throws ServiceException {
        LOGGER.log(Level.DEBUG, "Account service: start edit account");
        try {
            LOGGER.log(Level.DEBUG, "Account service: finish edit account");
            return daoFactory.getAccountDao().editAccount(clientId, orderCostNew);
        } catch (DaoException e) {
            throw new ServiceException(this.getClass() + ":" + e.getMessage());
        }
    }

    /**
     * @param clientId
     * @return boolean
     * @throws ServiceException
     */
    @Override
    public boolean findAccountByClientId(Integer clientId) throws ServiceException {
        LOGGER.log(Level.DEBUG, "Account service: start find account");
        try {
            LOGGER.log(Level.DEBUG, "Account service: finish find account");
            return daoFactory.getAccountDao().findAccountByClientId(clientId);
        } catch (DaoException e) {
            throw new ServiceException(this.getClass() + ":" + e.getMessage());
        }
    }
}
