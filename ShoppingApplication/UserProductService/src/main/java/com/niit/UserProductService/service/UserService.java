package com.niit.UserProductService.service;

import com.niit.UserProductService.domain.Product;
import com.niit.UserProductService.domain.User;
import com.niit.UserProductService.exception.ProductNotFoundException;
import com.niit.UserProductService.exception.UserAlreadyExistException;
import com.niit.UserProductService.exception.UserNotFoundException;
import com.niit.UserProductService.rabbitMq.CommonUser;

import java.util.List;

public interface UserService {
    public User addUser(User user) throws UserAlreadyExistException;
    public User addUsers(CommonUser commonUser);
    public User addProductForUser(int userId, Product product)throws UserNotFoundException;
    public String deleteProductFromUser(int userId, int productId) throws ProductNotFoundException, UserNotFoundException;
    public List<Product> getAllProductOfUser(int userId) throws UserNotFoundException;
}
