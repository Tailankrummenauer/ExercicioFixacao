
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        // Entrando com numero de produtos

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.println("Common, used or imported (c/u/i)?");
            char tipe = sc.next().charAt(0);
            sc.nextLine();
            //Todos vao precisar de nome e preço, fazer fora do for
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            // verificar qual tipo de produto foi digitado

            if (tipe == 'c') {
               
                products.add (new Product(name, price));


            } else if (tipe == 'u') {
                System.out.print("Manufacture date (dd/MM/yyyy): ");
                Date date = sdf.parse(sc.next());
                products.add(new UsedProduct(name, price, date));

            } else {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));

            }

        }

        System.out.println("PRICE TAGS:");
        for (Product product : products) {
            System.out.println(product.priceTag());

        }
        sc.close();

    }
}
