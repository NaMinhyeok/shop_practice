package gc.cafe.domain.orderproduct;

import gc.cafe.domain.BaseEntity;
import gc.cafe.domain.order.Order;
import gc.cafe.domain.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_items")
public class OrderProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private int quantity;

    public OrderProduct(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.quantity = quantity;
    }
}
