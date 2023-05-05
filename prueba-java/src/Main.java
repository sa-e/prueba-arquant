import java.util.*;
import models.Product;
import models.Size;
import service.Service;

public class Main {
    public static void main(String[] args) {
        // Cargar los datos de los ficheros csv
        List<Product> products = Service.loadProducts("resources/product.csv");
        List<Size> sizes = Service.loadSizes("resources/size-1.csv");
        Map<Integer, Integer> stock = Service.loadStock("resources/stock.csv");

        // Obtener los productos filtrados y la lista sin estos productos
        List<Integer> filteredProducts = Service.filterProducts(products, sizes, stock);
        List<Integer> finalList = Service.finalList(products, filteredProducts);

        // Imprimir los ids de los productos de la lista final
        System.out.println("Lista final sin los productos filtrados:");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finalList.size(); i++) {
            sb.append(finalList.get(i));
            if (i != finalList.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
