package Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Product {
    private UUID id;
    private Category category;
    private List<String> values= new ArrayList<>();
    private String name;
    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public UUID getId() {
        return id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    public void consoleValueReader(){
        values.removeAll(values);
        Scanner myObj = new Scanner(System.in);
        List<String> props = category.getProperties();
        for (int i =0; i<props.size();i++){
            System.out.println(props.get(i)+" değerini girin:");
            String value = myObj.nextLine();
            values.add(value);
        }
    }


    public Product( Category category){
        this.id = UUID.randomUUID();
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
