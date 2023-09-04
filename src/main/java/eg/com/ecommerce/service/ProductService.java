package eg.com.ecommerce.service;

import java.util.List;

import eg.com.ecommerce.dto.OrderProductDto;
import eg.com.ecommerce.model.Product;

public interface ProductService {
	
	public Iterable<Product> getProducts();
	public Product getProduct(long id);

	public void update(Product product);
	public Product save(Product product);
	public void validateProductsAvailability(List<OrderProductDto> orderProducts);

}
