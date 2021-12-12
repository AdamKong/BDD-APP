package com.adam.test.types.datatable;

import com.adam.shopping.Goods;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;
import com.alibaba.fastjson.JSON;

import java.util.Locale;
import java.util.Map;

/**
 * @program : bdd-demo-app
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 15:09 2021/12/12 2021
 * @ Description ：
 * @Version : $
 */
public class GoodsDataTableTypeRegistry implements TypeRegistryConfigurer {

    DataTableTypeRegistry typeRegistry = new DataTableTypeRegistry(Locale.ENGLISH);
    DataTable.TableConverter tableConverter = new DataTableTypeRegistryTableConverter(typeRegistry);

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {


        typeRegistry.defineDataTableType(new DataTableType(Goods.class, (DataTable dataTable) -> {
            Map<String, String> tableMap = tableConverter.toMap(dataTable, String.class, String.class);
            String tableJsonString = JSON.toJSONString(tableMap);
            Goods goods = JSON.parseObject(tableJsonString, Goods.class);
            return goods;
        }));

//        typeRegistry.defineDataTableType(new DataTableType(Goods.class, (DataTable dataTable) -> {
//            Goods goods = new Goods();
//            goods.setName(dataTable.cell(0, 1));
//            goods.setPrice(Float.parseFloat(dataTable.cell(1,1)));
//            goods.setAmount(Integer.parseInt(dataTable.cell(2,1)));
//            return goods;
//        }));
    }

}










































