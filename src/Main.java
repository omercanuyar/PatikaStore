import Model.Brand;
import Model.Category;
import Model.Product;

import java.util.*;

public class Main {
    public static List<Brand> brands = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();

    public static void createCategory(){
        Scanner myObj = new Scanner(System.in);
        List<String> propNames = new ArrayList<>();
        System.out.println("categori ismi girin:");
        String categoryName = myObj.nextLine();
        while(1==1){
            System.out.println("Categori için özellik ismi girin (bitirmek için e yazın):");
            String propName = myObj.nextLine();
            if(propName.equals("e")){
                break;
            }
            propNames.add(propName);
        }
        Category newCategory = new  Category(categoryName);
        newCategory.setProperties(propNames);
        categories.add(newCategory);

    }
    public static void createProduct(){
        Scanner myObj = new Scanner(System.in);
        List<String> propNames = new ArrayList<>();
        System.out.println("Ürün ismi girin:");
        String productName = myObj.nextLine();
        System.out.println("Ürünün kategorisinin ismi girin:");
        String categoryName = myObj.nextLine();
        boolean categoryExists=false;
        Category category= new Category("");
        for(int i=0; i<categories.size();i++){

            if(categories.get(i).getName().equals(categoryName)){
                category= categories.get(i);
                categoryExists=true;
            }
        }
        if(!categoryExists){
            System.out.println("bu isimde kategori bulunmuyor!");
            return;
        }
        List<String> values = new ArrayList<>();
        for(int i =0; i< category.getProperties().size();i++){
            System.out.println("Ürünün "+category.getProperties().get(i)+" özelliği için değer girin:");
            String value = myObj.nextLine();
            values.add(value);

        }
        Product newProd = new Product(productName,category);
        newProd.setValues(values);
        products.add(newProd);
        System.out.println("ürün oluşturuldu!");
    }
    public static void showCategories(){
        for(int i =0; i< categories.size();i++){
            System.out.println(categories.get(i).getName());
        }
    }
    public static void showProducts(){
        for(int i =0; i< products.size();i++){
            System.out.println(products.get(i).getName());
        }
    }
    public static void main(String[] args) {
        brands.add(new Brand("Samsung"));
        brands.add(new Brand("Lenovo"));
        brands.add(new Brand("Apple"));
        brands.add(new Brand("Huawei"));
        brands.add(new Brand("Casper"));
        brands.add(new Brand("Asus"));
        brands.add(new Brand("HP"));
        brands.add(new Brand("Xiaomi"));
        brands.add(new Brand("Monster"));
        Category cellPhone = new Category("Cep Telefonları");
        String[] props = new String[] { "Birim fiyatı", "İndirim oranı", "Stok miktarı" , "Ürün adı" , "Marka bilgisi" , "Telefonun hafıza bilgisi",
                                        "Ekran Boyutu","Pil Gücü","RAM","Renk" };
        List<String> list = Arrays.asList(props);
        cellPhone.setProperties(list);
        categories.add(cellPhone);


        Category notebook = new Category("Notebook");
        String[] props2 = new String[] { "Birim fiyatı", "İndirim oranı", "Stok miktarı" , "Ürün adı" , "Marka bilgisi" , "Ram",
                "Depolama","Ekran Boyutu"};
        List<String> list2 = Arrays.asList(props2);
        notebook.setProperties(list2);
        categories.add(notebook);
        Scanner myObj = new Scanner(System.in);
        while (1==1){
            System.out.println("kategori listesi için 1, yeni kategori eklemek için 2,product listesi için 3, yeni product için 4:");
            String op = myObj.nextLine();
            switch (op){
                case "1":
                    showCategories();
                    break;
                case "2":
                    createCategory();
                    break;
                case "3":
                    showProducts();
                    break;
                case "4":
                    createProduct();
                    break;
            }

        }



    }
}