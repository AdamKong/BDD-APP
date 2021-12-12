package com.adam.service.impl;

import com.adam.context.LoginContext;
import com.adam.service.CartService;
import com.adam.shopping.Cart;
import com.adam.shopping.Goods;
import com.adam.shopping.Inventory;
import com.adam.shopping.Order;
import lombok.Data;

import java.util.Map;


@Data
public class CartServiceImpl implements CartService {

    private Cart cart;

    public CartServiceImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void addGoods(Goods goods, int amount) {

        Map<Goods, Integer> goodsMap = cart.getGoodsMap();
//        Map<Goods, Integer> goodsMap = new HashMap<>();
//        goodsMap.put(new Goods("Apple"), 10);


        if (Inventory.stockOf(goods) <= 0) {
            throw new RuntimeException("No sufficient goods in inventory.");
        }
        if (goodsMap.get(goods) != null) {
            goodsMap.put(goods, goodsMap.get(goods) + amount);
        } else {
            goodsMap.put(goods, amount);
        }

        Inventory.subtract(goods, amount);
    }

    @Override
    public int getGoodsAmount(Goods goods) {
        return cart.getGoodsMap().getOrDefault(goods, 0);
    }

    @Override
    public void checkout(Order order) {
        LoginContext.loginRequired();
        new OrderServiceImpl().generate(cart);
    }
}
