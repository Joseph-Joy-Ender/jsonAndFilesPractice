package fileAndJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        String location = "C:\\Users\\Joy-PC\\IdeaProjects\\jsonAndFilePractice\\src\\fileAndJson\\products.txt";
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Bread", BigDecimal.valueOf(1500), 2));
        productList.add(new Product(2, "Butter", BigDecimal.valueOf(750), 1));
        productList.add(new Product(3, "Hollandia", BigDecimal.valueOf(500), 2));
        productList.add(new Product(4, "Chocolate", BigDecimal.valueOf(200), 2));

        writeProductsTo(productList, location);
        writeToJson(productList);
    }

    public static void writeProductsTo(List<Product> products, String fileLocation){
        try (FileOutputStream outputStream =
                     new FileOutputStream(fileLocation)){
            String header = "id\t\tname\t\t\tprice\t\tquantity";
            outputStream.write(header.getBytes());
            for (Product product: products){
                outputStream.write(("\n"+product.getId()+"\t\t"+product.getProductName()+"\t\t\t"+product.getPrice()+
                                        "\t\t"+product.getQuantity()).getBytes());
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }


    public static void writeToJson(List<Product> products){
        ObjectMapper mapper = new ObjectMapper();
        try(PrintStream printStream = new PrintStream("C:\\Users\\Joy-PC\\IdeaProjects\\jsonAndFilePractice\\src\\fileAndJson\\product.json")) {
            String json = mapper.writeValueAsString(products);
            printStream.println(json);
//            System.out.println(json);

        }catch (JsonProcessingException |FileNotFoundException exception){
            System.err.println("Error: " + exception.getMessage());
        }
    }

}