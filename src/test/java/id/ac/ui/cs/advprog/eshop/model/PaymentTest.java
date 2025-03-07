package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private HashMap<String, String> paymentData;
    private Order order;
    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product. setProductName ("Sampo Cap Bambang");
        product.setProductQuantity(2);
        products.add(product);

        order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");

        this.paymentData = new HashMap<>();
        this.paymentData.put("voucherCode", "ESHOPabc12345678");
        this.paymentData.put("address", "Depok");
        this.paymentData.put("deliveryFee", "50.000");
    }
    @Test
    void testCreatePaymentEmptyData() {
        this.paymentData.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("1d6ac561-6257-44b2-acf6-9a06d39392eb", "VOUCHER",
                    this.paymentData, order);
        });
    }
    @Test
    void testCreatePaymentWithVoucherSuccessStatus() {
        Payment payment = new Payment("1d6ac561-6257-44b2-acf6-9a06d39392eb", "VOUCHER",
                this.paymentData, order);

        assertEquals("1d6ac561-6257-44b2-acf6-9a06d39392eb", payment.getId());
        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(payment.getOrder().getStatus());
    }
    @Test
    void testCreatePaymentWithVoucherRejectedStatus() {
        this.paymentData.put("voucherCode", "ABCDEFGH12345678");
        Payment payment = new Payment("1d6ac561-6257-44b2-acf6-9a06d39392eb", "VOUCHER",
                this.paymentData, order);

        assertEquals("1d6ac561-6257-44b2-acf6-9a06d39392eb", payment.getId());
        assertEquals("REJECTED", payment.getStatus());
        assertEquals("FAILED", payment.getOrder.getStatus());
    }
    @Test
    void testCreatePaymentWithCODSuccessStatus() {
        Payment payment = new Payment("1d6ac561-6257-44b2-acf6-9a06d39392eb", "COD",
                this.paymentData, order);

        assertEquals("1d6ac561-6257-44b2-acf6-9a06d39392eb", payment.getId());
        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(payment.getOrder().getStatus(), payment.getStatus());
    }
    @Test
    void testCreatePaymentWithVoucherRejectedStatus() {
        this.paymentData.remove("address");
        Payment payment = new Payment("1d6ac561-6257-44b2-acf6-9a06d39392eb", "VOUCHER",
                this.paymentData, order);

        assertEquals("1d6ac561-6257-44b2-acf6-9a06d39392eb", payment.getId());
        assertEquals("REJECTED", payment.getStatus());
        assertEquals("FAILED", payment.getOrder.getStatus());
    }
    @Test
    void testCreatePaymentWithInvalidMethod() {
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("1d6ac561-6257-44b2-acf6-9a06d39392eb", "BANK",
                    this.paymentData, order);
        });
    }
    @Test
    void testEditPaymentWithVoucherToSuccess() {
        this.paymentData.put("voucherCode", "ABCDEFGH12345678");
        Payment payment = new Payment("1d6ac561-6257-44b2-acf6-9a06d39392eb", "VOUCHER",
                this.paymentData, order);

        assertEquals("REJECTED", payment.getStatus());
        assertEquals("FAILED", payment.getOrder.getStatus());

        payment.setStatus(payment.getMethod());

        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(payment.getOrder().getStatus(), payment.getStatus());
    }
}
