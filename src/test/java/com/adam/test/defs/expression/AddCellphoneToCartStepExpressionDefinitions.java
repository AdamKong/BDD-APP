package com.adam.test.defs.expression;

import com.adam.context.LoginContext;
import com.adam.service.impl.CartServiceImpl;
import com.adam.shopping.Cart;
import com.adam.shopping.Goods;
import com.adam.shopping.Inventory;
import com.adam.shopping.Person;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * @program : bdd-demo-app
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 22:09 2021/12/11 2021
 * @ Description ：This is the AddCellphoneToCartStepDefinitions
 * @Version : 1.0$
 */
public class AddCellphoneToCartStepExpressionDefinitions {

    private Person person;
    private CartServiceImpl csi;

    @Given("I have login in the shopping website")
    public void login(){
        person = new Person("ray");
        LoginContext.login(person);
    }

    @When("I add {int} {word} into the cart")
//    @When("I add (\\d+) (\\w+) into the cart")
    public void addGoodsToCart(int amount, String goodsName){
        // Cart.of(person).addGoods(new Goods("HuaWei"), 2);
        csi = new CartServiceImpl(Cart.of(person));
        csi.addGoods(createGoodsByName(goodsName), amount);
    }

    @Then("I can see {int} {word} in my cart")
    public void iCanSee(int amount, String goodsName){
        Assert.assertEquals("I can not see my cellphone in my cart",
                amount,
                csi.getGoodsAmount(createGoodsByName(goodsName)));
    }

    @And("The amount of the {word} in the inventory should be {int}")
    public void theInventory(String goodsName, int reminder){
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect.",
        Integer.valueOf(reminder),
        Inventory.stockOf(createGoodsByName(goodsName))
        );
    }

    public Goods createGoodsByName(String name){
        return new Goods(name);
    }

}
