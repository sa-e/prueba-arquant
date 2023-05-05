package service;

import java.util.*;
import models.Product;
import models.Size;
import java.io.*;

public class Service {
    // Cargar los datos de los productos
    public static List<Product> loadProducts(String fileName) {
        List<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                int sequence = Integer.parseInt(fields[1].trim());
                products.add(new Product(id, sequence));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Cargar los datos de los sizes
    public static List<Size> loadSizes(String fileName) {
        List<Size> sizes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                int productId = Integer.parseInt(fields[1].trim());
                boolean backSoon = Boolean.parseBoolean(fields[2].trim());
                boolean special = Boolean.parseBoolean(fields[3].trim());
                sizes.add(new Size(id, productId, backSoon, special));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sizes;
    }

    // Cargar los datos de stock
    public static Map<Integer, Integer> loadStock(String fileName) {
        Map<Integer, Integer> stock = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                int sizeId = Integer.parseInt(fields[0].trim());
                int quantity = Integer.parseInt(fields[1].trim());
                stock.put(sizeId, quantity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stock;
    }

    // Filtrar los productos sin stock
    public static List<Integer> filterProducts(List<Product> products, List<Size> sizes, Map<Integer, Integer> stock) {
        List<Integer> filteredProducts = new ArrayList<>();
        Map<Integer, Integer> productStock = new HashMap<>();
        for (Size size : sizes) {
            int productId = size.productId;
            int sizeId = size.id;
            Integer quantity = stock.get(sizeId);
            if (!size.backSoon && quantity != null && quantity > 0) {
                int stockByProduct = productStock.getOrDefault(productId, 0);
                stockByProduct += quantity;
                productStock.put(productId, stockByProduct);
            }
        }

        // Crear una nueva lista para los productos sin stock
        List<Integer> filteredProductsWithoutStock = new ArrayList<>();
        for (Product product : products) {
            int productId = product.id;
            if (!productStock.containsKey(productId)) {
                filteredProductsWithoutStock.add(productId);
            }
        }

        // Ordenar los productos sin stock por secuencia y añadirlos a la lista final
        filteredProductsWithoutStock.sort(Comparator.comparingInt(p -> getProductById(products, p).sequence));
        filteredProducts.addAll(filteredProductsWithoutStock);

        return filteredProducts;
    }

    // Método para obtener un objeto Product a partir de su id
    static Product getProductById(List<Product> products, int id) {
        for (Product product : products) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    // Método para obtener la lista final
    public static List<Integer> finalList(List<Product> products, List<Integer> filtereds) {
        List<Integer> finalList = new ArrayList<>();
        for (Product product : products) {
            if (!filtereds.contains(product.getId())) {
                finalList.add(product.getId());
            }
        }
        return finalList;
    }
}
