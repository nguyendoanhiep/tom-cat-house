package com.tom.restaurant.repository;

import com.tom.restaurant.entity.Orders;
import com.tom.restaurant.entity.dto.OrdersDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    @Query("select new com.tom.restaurant.entity.dto.OrdersDto(c.name,o.code,o.numberPhone,c.name,o.originalTotalValue,o.discountAmount,o.totalValue,o.status,o.createDate) " +
            "from Orders o join Customer c on o.numberPhone = c.numberPhone where " +
            "(:search is null or o.code like :search% or o.numberPhone like :search%) and " +
            "(:status = 0 or o.status = :status)")
    Page<OrdersDto> getAll(Pageable pageable, String search , Integer status);
}
