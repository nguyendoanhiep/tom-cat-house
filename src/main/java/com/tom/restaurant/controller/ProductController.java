package com.tom.restaurant.controller;

import com.tom.restaurant.entity.dto.ProductDto;
import com.tom.restaurant.response.Response;
import com.tom.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/getAll")
    public Response<?> getAll(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam String search
    ) {
        return productService.getAll(PageRequest.of(page - 1, size), search);
    }

    @PostMapping("/addOrUpdate")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<?> addOrUpdate(@RequestBody ProductDto dto) {
        return productService.addOrUpdate(dto);
    }
}
