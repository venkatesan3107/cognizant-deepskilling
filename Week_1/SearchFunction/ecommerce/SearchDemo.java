package ecommerce;

public class SearchDemo {
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "T-shirt", "Clothing"),
                new Product(3, "Phone", "Electronics"),
                new Product(4, "Shoes", "Footwear"),
                new Product(5, "Book", "Education")
        };

        System.out.println("Linear Search:");
        Product result1 = SearchUtils.linearSearch(products, "Phone");
        System.out.println(result1 != null ? result1 : "Product not found");

        System.out.println("\n Sorting products for binary search...");
        SearchUtils.sortProductsByName(products);

        System.out.println("\n Binary Search:");
        Product result2 = SearchUtils.binarySearch(products, "Phone");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
