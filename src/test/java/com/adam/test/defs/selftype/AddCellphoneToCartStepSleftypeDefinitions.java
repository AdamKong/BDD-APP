package com.adam.test.defs.selftype;

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
public class AddCellphoneToCartStepSleftypeDefinitions {

    private Person person;
    private CartServiceImpl csi;

    @Given("I have login in the shopping website")
    public void login(){
        person = new Person("ray");
        LoginContext.login(person);
    }

    @When("I add {int} {goodsName} into the cart")
    public void addGoodsToCart(int amount, Goods goods){
        // Cart.of(person).addGoods(new Goods("HuaWei"), 2);
        csi = new CartServiceImpl(Cart.of(person));
        csi.addGoods(goods, amount);
    }

    @Then("I can see {int} {goodsName} in my cart")
    public void iCanSee(int amount, Goods goods){
        Assert.assertEquals("I can not see my cellphone in my cart",
                amount,
                csi.getGoodsAmount(goods));
    }

    @And("The amount of the {goodsName} in the inventory should be {int}")
    public void theInventory(Goods goods, int reminder){
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect.",
        Integer.valueOf(reminder),
        Inventory.stockOf(goods)
        );
    }

}
