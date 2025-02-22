package model.dao.user;

import model.entity.user.Users;

public class UserDaoImpl implements UserDao {

    @Override
    public void registerUser(Users user) {
        System.out.println("User registered successfully");
    }




    @Override
    public void loginUser(String username, String password) {
        System.out.println("User logged in successfully");
    }
    @Override
    public void logout() {
        System.out.println("User logged out successfully");
    }

    @Override
    public void viewProducts() {
        System.out.println("Products viewed successfully");
    }

    @Override
    public void placeOrder() {

    }

    @Override
    public void viewOrderHistory() {

    }
}
