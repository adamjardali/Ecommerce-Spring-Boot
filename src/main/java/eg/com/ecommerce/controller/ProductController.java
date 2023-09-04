package eg.com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import eg.com.ecommerce.model.Product;
import eg.com.ecommerce.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = { "", "/" })
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }
	
	
	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)    
	public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Product createProduct(@Valid @RequestBody Product product) {
		// Save the provided product using the ProductService
		return productService.save(product);
	}

	@PutMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
	public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
		// Set the ID of the product to be updated
		product.setId(id);

		// Save the updated product using the ProductService
		return productService.save(product);
	}
}
