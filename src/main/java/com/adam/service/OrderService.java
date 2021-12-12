package com.adam.service;

import com.adam.shopping.Cart;
import com.adam.shopping.Order;

public interface OrderService {

    Order generate(Cart cart);
}
