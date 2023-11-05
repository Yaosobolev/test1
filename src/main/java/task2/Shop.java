package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {




    public static void sortProductsByPrice(List<Product> productList){
        Collections.sort(productList, Comparator.comparing(Product::getPrice));
    }

    public static Product getMostExpensiveProduct(List<Product> productList){
        Product product1=null;
        double max=0;
        for (Product prod: productList) {
            if(max<prod.getPrice()) {
                product1 = prod;
                max=prod.getPrice();
            }
        }
        return product1;
    }
}
