Feature: Add Another Cellphone to cart

  Scenario Outline: Add cellphone to cart with sufficient stock

    Given I have login in the shopping website
    When I add one cellphone into the cart
      | name   | <goodsName> |
      | price  | <price>     |
      | amount | <amount>    |
    Then I can see <amount> <goodsName> in my cart
    And The amount of the <goodsName> in the inventory should be <reminder>

    Examples:
      | goodsName | price | amount | reminder |
      | HuaWei    | 1000  | 1      | 99       |
      | XiaoMi    | 800   | 3      | 97       |
      | Apple     | 1500  | 6      | 94       |
