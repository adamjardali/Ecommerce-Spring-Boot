package eg.com.ecommerce.service.impl;

import eg.com.ecommerce.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eg.com.ecommerce.model.OrderProduct;
import eg.com.ecommerce.repository.OrderProductRepository;
import eg.com.ecommerce.service.OrderProductService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    @Override
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductRepository.findAll();
    }


    @Override
    public OrderProduct updateOrderProduct(OrderProduct updatedOrderProduct,int Quantity) {


        // Set the ID of the updated order product
        updatedOrderProduct.setQuantity(Quantity);

        // Save the updated order product
        return orderProductRepository.save(updatedOrderProduct);
    }
}
