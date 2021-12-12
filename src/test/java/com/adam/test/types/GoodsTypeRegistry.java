package com.adam.test.types;

import com.adam.shopping.Goods;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.CaptureGroupTransformer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.util.Locale;

/**
 * @program : bdd-demo-app
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 15:09 2021/12/12 2021
 * @ Description ：
 * @Version : $
 */
public class GoodsTypeRegistry implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType("goodsName", "\\w+", Goods.class, new GoodsTransfer()));
    }

//    private Goods goodsTransformer(String parameterName){
//        return new Goods(parameterName);
//    }

    class GoodsTransfer implements CaptureGroupTransformer<Goods>{

        @Override
        public Goods transform(String[] strings) throws Throwable {
            return new Goods(strings[0]);
        }
    }

}










































