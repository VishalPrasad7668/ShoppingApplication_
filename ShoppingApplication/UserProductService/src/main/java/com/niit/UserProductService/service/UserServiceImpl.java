package com.niit.UserProductService.service;

import com.niit.UserProductService.domain.Product;
import com.niit.UserProductService.domain.User;
import com.niit.UserProductService.exception.ProductNotFoundException;
import com.niit.UserProductService.exception.UserAlreadyExistException;
import com.niit.UserProductService.exception.UserNotFoundException;
import com.niit.UserProductService.rabbitMq.CommonUser;
import com.niit.UserProductService.rabbitMq.Producer;
import com.niit.UserProductService.rabbitMq.UserDTO;
import com.niit.UserProductService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    private Producer producer;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if (userRepository.findById(user.getUserId()).isPresent()){
            throw new UserAlreadyExistException();
        }
        return userRepository.insert(user);
    }
    @Override
    public User addUsers(CommonUser commonUser){
        UserDTO userDTO = new UserDTO(commonUser.getUserId(),commonUser.getPassword());
        producer.sendDTOToQueue(userDTO);
        User user = new User(commonUser.getUserId(),commonUser.getUserName(),commonUser.getPhoneNo(),commonUser.getEmailId(),commonUser.getAddress(),new ArrayList<>());
        return userRepository.insert(user);
    }


    @Override
    public User addProductForUser(int userId, Product product) throws UserNotFoundException {
        if (userRepository.findById(userId).isEmpty()){
            throw new  UserNotFoundException();
        }
        User user = userRepository.findByUserId(userId);
        if (user.getProducts()==null){
            user.setProducts(Arrays.asList(product));
        }
        else{
            List<Product> productList = user.getProducts();
            productList.add(product);
            user.setProducts(productList);
        }
        return userRepository.save(user);
    }

    @Override
    public String deleteProductFromUser(int userId, int productId) throws ProductNotFoundException, UserNotFoundException {
        if (userRepository.findById(userId).isEmpty()){
            throw new UserNotFoundException();
        }
        User user = userRepository.findById(userId).get();
        List<Product> productList = user.getProducts();
        productList.removeIf(obj-> obj.getProductId()==productId);

        if(userRepository.findById(productId).isPresent()){
            throw new ProductNotFoundException();
        }
        user.setProducts(productList);
        userRepository.save(user);
        return "Product with product Id = "+productId+" is deleted";
    }

    @Override
    public List<Product> getAllProductOfUser(int userId) throws UserNotFoundException {
        if (userRepository.findById(userId).isEmpty()){
            throw new UserNotFoundException();
        }
        return userRepository.findById(userId).get().getProducts();
    }
}
