package com.jsd.petvilla.repository;

import com.jsd.petvilla.entity.PetOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetOrdersRepository extends JpaRepository<PetOrders, Integer> {

    @Query("SELECT po FROM PetOrders po WHERE po.customer.cId = :customerId")
    List<PetOrders> findByCustomerId(int customerId);

    @Query("SELECT po FROM PetOrders po WHERE po.customer.cId = :customerId AND po.status = :status")
    List<PetOrders> findByCustomerIdAndStatus(int customerId, String status);
}
