package com.adam.test.defs.datatable;

import com.adam.context.LoginContext;
import com.adam.service.impl.CartServiceImpl;
import com.adam.shopping.Cart;
import com.adam.shopping.Goods;
import com.adam.shopping.Inventory;
import com.adam.shopping.Person;
import com.alibaba.fastjson.JSON;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



import java.util.Map;

/**
 * @program : bdd-demo-app
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 22:09 2021/12/11 2021
 * @ Description ：This is the AddCellphoneToCartStepDefinitions
 * @Version : 1.0$
 */
public class AddCellphoneToCartStepDatatableDefinitions {

    private Person person;
    private CartServiceImpl csi;

    @Given("I have login in the shopping website")
    public void login(){
        person = new Person("ray");
        LoginContext.login(person);
    }

//    @When("I add {int} {goodsName} into the cart")
//    public void addGoodsToCart(int amount, Goods goods){
//        // Cart.of(person).addGoods(new Goods("HuaWei"), 2);
//        csi = new CartServiceImpl(Cart.of(person));
//        csi.addGoods(goods, amount);
//    }

    // receive data by map
//    @When("I add one cellphone into the cart")
//    public void addGoodsToCart(Map<String, String> tableMap){
//        String tableJsonString = JSON.toJSONString(tableMap);
//        Goods goods = JSON.parseObject(tableJsonString, Goods.class);
//        csi = new CartServiceImpl(Cart.of(person));
//        csi.addGoods(goods, goods.getAmount());
//    }

    // receive data by datatable
//    @When("I add one cellphone into the cart")
//    public void addGoodsToCart(DataTable dataTable){
//        Map tableMap = dataTable.asMap(String.class, String.class);
//        String tableJsonString = JSON.toJSONString(tableMap);
//        Goods goods = JSON.parseObject(tableJsonString, Goods.class);
//        csi = new CartServiceImpl(Cart.of(person));
//        csi.addGoods(goods, goods.getAmount());
//    }

    // receive data by datatable self type
//    @When("I add one cellphone into the cart")
//    public void addGoodsToCart(Goods goods){
//        csi = new CartServiceImpl(Cart.of(person));
//        csi.addGoods(goods, goods.getAmount());
//    }

    // receive data by datatable converter
    @When("I add one cellphone into the cart")
    public void addGoodsToCart(Goods goods){
        csi = new CartServiceImpl(Cart.of(person));
        csi.addGoods(goods, goods.getAmount());
    }


    @Then("I can see {int} {word} in my cart")
    public void iCanSee(int amount, String goodsName){
        Assert.assertEquals("I can not see my cellphone in my cart",
                amount,
                csi.getGoodsAmount(new Goods(goodsName)));
    }

    @And("The amount of the {word} in the inventory should be {int}")
    public void theInventory(String goodsName, int reminder){
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect.",
        Integer.valueOf(reminder),
        Inventory.stockOf(new Goods(goodsName))
        );
    }

}
