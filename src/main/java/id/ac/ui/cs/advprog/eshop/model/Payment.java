package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.regex.Pattern;

@Builder
@Getter
public class Payment {
    String id;
    String method;
    Map<String, String> paymentData;
    Order order;
    String status;

    public Payment(String id, String method, Map<String, String> paymentData, Order order) {
        this.id = id;
        this.method = method;
        this.order = order;

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }

        this.setStatus(method);
    }

    public Payment(String id, String method, Map<String, String> paymentData, Order order, String status) {
    }

    public void setStatus(String method) {
        if (method.equals("VOUCHER")) {
            // Regex pattern
            final String voucerPattern = "^ESHOP(?=(?:\\D*\\d){8})[a-zA-Z0-9]{11}$";
            String code = paymentData.get("voucherCode");
            if (Pattern.matches(voucerPattern, code)) {
                this.status = ("SUCCESS");
                this.order.setStatus("SUCCESS");
            } else {
                this.status = ("REJECTED");
                this.order.setStatus("FAILED");
            }
        } else if (method.equals("COD")) {
            if (!paymentData.get("address").isEmpty() || !paymentData.get("deliveryFee").isEmpty()) {
                this.status = ("SUCCESS");
                this.order.setStatus("SUCCESS");
            } else {
                this.status = ("REJECTED");
                this.order.setStatus("FAILED");
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
