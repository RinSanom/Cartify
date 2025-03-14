package model.repository.order;

import java.util.List;

/**
 * @author Ronn
 * @version 1.0
 * @param <C> identify class type
 * @param <I> identify data type class
 */
public interface OrderRepository<C, I> {
    /**
     *
     * @param c parameter as class object
     * @return return as an object of class
     */
    I createOrder(C c);
    I cancelOrder(I orderId);
    C viewOrderDetails(I orderId);
    List<C> viewUserOrders(I userId);

}
