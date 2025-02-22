package model.dao.user;

import model.entity.user.Users;

public interface UserDao {
    void registerUser(Users user);
    void loginUser(String username, String password);
    void logout();
    void viewProducts();
    void placeOrder();
    void viewOrderHistory();
}
