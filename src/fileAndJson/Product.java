package fileAndJson;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product{

    private final int id;
    private final String productName;
    private final BigDecimal price;
    private final int quantity;

    public Product(int id, String productName, BigDecimal price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }


    public String getProductName() {
        return productName;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }



}
