package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("063881b4-b601-4d59-8189-6a3db0052732");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }
    @Test
    void testFindAllifEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllifMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("063881b4-b601-4d59-8189-6a3db0052732");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("398781b4-z5t1-4d59-8189-6a3db0052732");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductName(), savedProduct.getProductName());
    }
    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductId("063881b4-b601-4d59-8189-6a3db0052732");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product updatedProduct = new Product();
        updatedProduct.setProductId("063881b4-b601-4d59-8189-6a3db0052732");
        updatedProduct.setProductName("Sampo Cap Budi");
        updatedProduct.setProductQuantity(50);
        productRepository.edit(updatedProduct);

        Product editedProduct = productRepository.findById("063881b4-b601-4d59-8189-6a3db0052732");
        assertNotEquals(product.getProductName(), editedProduct.getProductName());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("063881b4-b601-4d59-8189-6a3db0052732");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        productRepository.delete(product);
        assertNull(productRepository.findById(product.getProductId()));
    }
}
