package bsuir.vintsarevich.buisness.orderproduct.service;

import bsuir.vintsarevich.exception.service.ServiceException;

public interface IOrderProductService {

    boolean addOrderProduct(Integer clientId, Integer productId, Integer productCount) throws ServiceException;

    boolean deleteOrderProduct(Integer clientId, Integer productId) throws ServiceException;

    boolean editOrderProductPayment(Integer orderIdNew, Integer orderId) throws ServiceException;

}
