package com.adam.service;

import com.adam.shopping.Order;
import com.adam.shopping.Goods;

public interface CartService {

    void addGoods(Goods goods, int amount);

    int getGoodsAmount(Goods goods);

    void checkout(Order order);

}
