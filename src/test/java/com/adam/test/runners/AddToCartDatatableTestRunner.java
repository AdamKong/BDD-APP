package com.adam.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @program : bdd-demo-app
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 22:07 2021/12/11 2021
 * @ Description ：This is the AddCellphoneToCartRunner
 * @Version : 1.0$
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"classpath:feature/cart/add_cellphone_to_cart_datatable.feature"},
        glue = {"com.adam.test.defs.datatable", "com.adam.test.types.datatable"},
        plugin = "html:target/report/cucumber_datatable.html"
)
public class AddToCartDatatableTestRunner {

}
