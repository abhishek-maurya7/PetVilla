package com.jsd.petvilla.service;

import java.util.List;

import com.jsd.petvilla.entity.ProductOrders;

/*
 * Service interface to define operations related to ProductOrders entity.
 */
public interface ProductOrdersService {

    /**
     * Create a new product order.
     * @return The created ProductOrders object.
     */
    List<ProductOrders> createProductOrder(List<ProductOrders> newProductOrders);

    /**
     * Fetch a product order by its unique identifier (ID).
     * @return The ProductOrders object corresponding to the given ID.
     */
    ProductOrders fetchProductOrderById(int productOrderId);

    /**
     * Cancel a product order by updating its status or making necessary changes.
     * @return The updated ProductOrders object after cancellation.
     */
    ProductOrders cancelProductOrder(ProductOrders productOrder, int productOrderId);
}
