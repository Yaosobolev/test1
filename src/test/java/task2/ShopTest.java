package task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Product product;
    private List<Product> productList;
    @BeforeEach
    @DisplayName("Метод: создание списка продуктов")
    void setUp() {
        productList=new ArrayList<>();
        productList.add(new Product("Конфеты",435.00));
        productList.add(new Product("Пирожные",272.00));
        productList.add(new Product("Шоколад",123.00));
        productList.add(new Product("Зефир",223.00));
        productList.add(new Product("Ореховая паста",323.50));
        productList.add(new Product("Мармелад",123.50));
    }

    @AfterEach
    @DisplayName("Метод: обнуление списка")
    void tearDown() {
        productList=null;
    }

    @Test
    @DisplayName("Проверка правильности сортировки списка по цене")
    void sortProductsByPrice() {
        double[] expected = {123.00, 123.50, 223.00,272.00,323.50,435.00};
        Shop.sortProductsByPrice(productList);
        double[] actual = new double[productList.size()];
        int count=0;
        for (Product prod: productList) {
            actual[count]=prod.getPrice();
            count++;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка правильности нахождения самого дорогого товара в списке")
    void getMostExpensiveProduct() {
        assertEquals(435.00, Shop.getMostExpensiveProduct(productList).getPrice());
    }
}