package com.adam.test.defs.plain;

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
public class AddCellphoneToCartStepDefinitions {

    private Person person;
    private CartServiceImpl csi;

    @Given("I have login in the shopping website")
    public void login(){
        person = new Person("ray");
        LoginContext.login(person);
    }

    @When("I add one cellphone into the cart")
    public void addGoodsToCart(){
        // Cart.of(person).addGoods(new Goods("HuaWei"), 2);
        csi = new CartServiceImpl(Cart.of(person));
        csi.addGoods(new Goods("HuaWei"), 2);
    }

    @Then("I can see one cellphone in my cart")
    public void iCanSee(){
        Assert.assertEquals("I can not see my cellphone in my cart",
                2,
                csi.getGoodsAmount(new Goods("HuaWei")));
    }

    @And("The amount of the cellphone in the inventory should be 98")
    public void theInventory(){
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect.",
        Integer.valueOf(98),
        Inventory.stockOf(new Goods("HuaWei"))
        );
    }

}
