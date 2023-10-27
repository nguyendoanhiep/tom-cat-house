package com.tom.restaurant.service;

import com.tom.restaurant.entity.dto.VoucherRequest;
import com.tom.restaurant.response.Response;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VoucherService {
    Response<?> getAll(Pageable pageable,String search , Integer status);
    Response<?> save(VoucherRequest request);
    Response<?> findByNumberPhone(String numberPhone);
    Response<?> addVoucherForCustomer(List<String> numberPhoneList , Long voucherId);
    Response<?> delete(Long id);
}
