package eg.com.ecommerce.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import eg.com.ecommerce.model.OrderProduct;

import java.util.List;
import java.util.Optional;

@Validated
public interface OrderProductService {

	OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);

	List<OrderProduct> getAllOrderProducts();

	OrderProduct updateOrderProduct(OrderProduct updatedOrderProduct, int quantity);
}
