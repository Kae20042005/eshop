package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        if (product.getProductId() == null) {
            product.setProductId(UUID.randomUUID().toString());
        }
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String id) {
        return productData.stream()
                .filter(product -> product.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("product not found"));
    }

    public Product edit(Product updatedProduct) {
        Iterator<Product> iterator = productData.iterator();
        while (iterator.hasNext()) {
            Product existingProduct = iterator.next();
            if (existingProduct.getProductId().equals(updatedProduct.getProductId())) {
                existingProduct.setProductName(updatedProduct.getProductName());
                existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
                return existingProduct;
            }
        }
        throw new RuntimeException("Product not found");
    }

    public void delete(Product deletedProduct) {
        Iterator<Product> iterator = productData.iterator();
        while (iterator.hasNext()) {
            Product existingProduct = iterator.next();
            if (existingProduct.equals(deletedProduct)) {
                iterator.remove();
                return;
            }
        }
        throw new RuntimeException("Product not found");
    }
}
