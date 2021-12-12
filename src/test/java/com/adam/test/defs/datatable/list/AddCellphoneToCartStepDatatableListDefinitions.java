package com.adam.test.defs.datatable.list;

import com.adam.context.LoginContext;
import com.adam.service.impl.CartServiceImpl;
import com.adam.shopping.Cart;
import com.adam.shopping.Goods;
import com.adam.shopping.Inventory;
import com.adam.shopping.Person;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program : bdd-demo-app
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 22:09 2021/12/11 2021
 * @ Description ：This is the AddCellphoneToCartStepDefinitions
 * @Version : 1.0$
 */
public class AddCellphoneToCartStepDatatableListDefinitions {

    private Person person;
    private CartServiceImpl csi;
    private List<Goods> goodslist = new ArrayList<>();

    @Before(order = 2)
    public void setUp1(Scenario scenario){
        scenario.write("Hello before write method of scenario 1.");
    }

    @Before(order = 1)
    public void setUp2(Scenario scenario){
        scenario.write("Hello before write method of scenario 2.");
    }

    @After
    public void tearDown(Scenario scenario){
        scenario.write("Hello tearDown method of scenario.");
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){
        scenario.write("Hello before write method of scenario in the before step");
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        scenario.write("Hello after write method of scenario in the after step");
    }

    @Given("I have login in the shopping website")
    public void login(){
        person = new Person("ray");
        LoginContext.login(person);
    }


    // receive data by datatable list - method 1
//    @When("I add one cellphone into the cart")
//    public void addGoodsToCart(List<Map<String, String>> tableListMap){
//        csi = new CartServiceImpl(Cart.of(person));
//
//        tableListMap.stream()
//                        .forEach(tableMap -> {
//                            Goods goods = new Goods(tableMap.get("name"));
//                            goods.setPrice(Float.parseFloat(tableMap.get("price")));
//                            goods.setAmount(Integer.parseInt(tableMap.get("amount")));
//                            csi.addGoods(goods, goods.getAmount());
//                            goodslist.add(goods);
//                        });
//    }

    // receive data by datatable list - method 2
    @When("I add one cellphone into the cart")
    public void addGoodsToCart(List<Goods> goodsList){
        csi = new CartServiceImpl(Cart.of(person));

        goodsList.stream()
                .forEach(goods -> {
                    csi.addGoods(goods, goods.getAmount());
                    goodslist.add(goods);
                });
    }


    @Then("I can see some cellphone in my cart")
    public void iCanSee(){
        goodslist.stream()
                        .forEach(goods -> {
                            Assert.assertEquals("I can not see my cellphone in my cart",
                                    goods.getAmount(),
                                    csi.getGoodsAmount(goods));
                        });
    }

    @And("The amount of the cellphone in the inventory should be correct")
    public void theInventory(){
        goodslist.stream()
                        .forEach(goods -> {
                            Assert.assertEquals("The amount of the cellphone in the inventory is incorrect.",
                                    100 - goods.getAmount(),
                                    Inventory.stockOf(goods).intValue()
                            );
                        });



    }

}
