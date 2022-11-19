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
        Product newProd = new Product(category);
        for(int i =0; i< category.getProperties().size();i++){

            System.out.println("Ürünün "+category.getProperties().get(i)+" özelliği için değer girin:");
            String value = myObj.nextLine();
            switch (category.getProperties().get(i)){
                case "Ürün adı":
                    newProd.setName(value);
                    values.add(value);
                    break;
                case "Marka bilgisi":
                    newProd.setBrand(searchBrand(value));
                    values.add(value);
                    break;
                default:
                    values.add(value);
            }
        }

        newProd.setValues(values);
        products.add(newProd);
        System.out.println("ürün oluşturuldu!");
    }
    public static Brand searchBrand(String s){
        for(int i =0;i<brands.size();i++){
            if(brands.get(i).getName().equals(s)){
                return brands.get(i);
            }
        }
        return null;
    }
    public static void showCategories(){
        for(int i =0; i< categories.size();i++){
            System.out.println(categories.get(i).getName());
        }
    }
    public static Category getCategoryByName(String name){
        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getName().equals(name)){
                return categories.get(i);
            }
        }
        return null;
    }
    public static void printHeader (List<String> headers){
        int tireBoyu=0;
        for(int i=0;i<headers.size();i++){
            tireBoyu+= headers.get(i).length()+3;
        }
        String s = String.join("", Collections.nCopies(tireBoyu, String.valueOf("-")));
        System.out.println(s);
        for(int q =0;q<headers.size();q++){
            System.out.printf(" | ");
            System.out.printf(headers.get(q));
        }
        System.out.println();
        System.out.println(s);
    }
    public static void printList (List<String> headers,List<String> values){
        int tireBoyu=0;
        for(int i=0;i<headers.size();i++){
            tireBoyu+= headers.get(i).length()+3;
        }
        String s = String.join("", Collections.nCopies(tireBoyu, String.valueOf("-")));
        System.out.println(s);
        for(int q =0;q<headers.size();q++){
            System.out.printf(" | ");
            System.out.printf(" %-"+(headers.get(q).length()-2)+"s ",values.get(q));
        }
        System.out.println();
        System.out.println(s);
    }
    public static void showProductsByCategory(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("ürünleri görüntülemek için kategori ismi girin:");
        String categoryName = myObj.nextLine();
        Category category =getCategoryByName(categoryName);
        printHeader(category.getProperties());
        for(int i =0; i< products.size();i++){

            if (products.get(i).getCategory().getName().equals(categoryName)){
                printList(category.getProperties(),products.get(i).getValues());
            }
        }
    }
    public static void showProductsByBrand(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("ürünleri görüntülemek için kategori ismi girin:");
        String categoryName = myObj.nextLine();
        Category category =getCategoryByName(categoryName);
        System.out.println("marka ismi girin:");
        String marka = myObj.nextLine();
        printHeader(category.getProperties());
        for(int i =0; i< products.size();i++){

            if (products.get(i).getBrand().getName().equals(marka) && products.get(i).getCategory().getName().equals(categoryName)){
                printList(category.getProperties(),products.get(i).getValues());
            }
        }
    }
    public static void showProductsById(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("ürünleri görüntülemek için kategori ismi girin:");
        String categoryName = myObj.nextLine();
        Category category =getCategoryByName(categoryName);
        System.out.println("ürün id değeri girin:");
        String id = myObj.nextLine();
        printHeader(category.getProperties());
        for(int i =0; i< products.size();i++){

            if (products.get(i).getId().toString().equals(id) && products.get(i).getCategory().getName().equals(categoryName)){
                printList(category.getProperties(),products.get(i).getValues());
            }
        }
    }
    public static void deleteProduct(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("silmek istediğiniz ürünün id değerini girin:");
        String id = myObj.nextLine();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId().toString().equals(id)){
                products.remove(i);
            }
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
            //sa();
            System.out.println("kategori listesi için 1, yeni kategori eklemek için 2,kategori bazlı ürün listesi için 3,\n" +
                    " yeni product için 4, ürün silmek için 5, marka bazlı ürün listesi için 6, id ile ürün sorgulama için 7:");
            String op = myObj.nextLine();
            switch (op){
                case "1":
                    showCategories();
                    break;
                case "2":
                    createCategory();
                    break;
                case "3":
                    showProductsByCategory();
                    break;
                case "4":
                    createProduct();
                    break;
                case "5":
                    deleteProduct();
                    break;
                case "6":
                    showProductsByBrand();
                    break;
                case "7":
                    showProductsById();
                    break;
            }

        }



    }
}