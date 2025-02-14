package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductTest {
    Product product;
    @BeforeEach
    void setUp() {
        this.product = new Product();
        this.product.setProductId("063881b4-b601-4d59-8189-6a3db0052732");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(100);
    }
    @Test
    void testGetProductId() {
        assertEquals("063881b4-b601-4d59-8189-6a3db0052732", this.product.getProductId());
    }

    @Test
    void testGetProductName() {
        assertEquals("Sampo Cap Bambang", this.product.getProductName());
    }

    @Test
    void testGetProductQuantity() {
        assertEquals(100, product.getProductQuantity());
    }
}
