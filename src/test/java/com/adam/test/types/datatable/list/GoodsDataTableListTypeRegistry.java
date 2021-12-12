package com.adam.test.types.datatable.list;

import com.adam.shopping.Goods;
import com.alibaba.fastjson.JSON;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @program : bdd-demo-app
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 15:09 2021/12/12 2021
 * @ Description ：
 * @Version : $
 */
public class GoodsDataTableListTypeRegistry implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {

        typeRegistry.defineDataTableType(new DataTableType(Goods.class, (Map<String, String> goodsMap) -> {
            Goods goods = new Goods();
            String goodsJson = JSON.toJSONString(goodsMap);
            return JSON.parseObject(goodsJson, Goods.class);
        }));



//        typeRegistry.defineDataTableType(new DataTableType(Goods.class, (List<String> row) -> {
//            Goods goods = new Goods();
//            goods.setName(row.get(0));
//            goods.setPrice(Float.parseFloat(row.get(1)));
//            goods.setAmount(Integer.parseInt(row.get(2)));
//            return goods;
//        }));

    }
}










































