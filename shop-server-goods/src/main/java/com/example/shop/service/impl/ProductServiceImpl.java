package com.example.shop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.shop.goods.domain.Product;
import com.example.shop.goods.service.IProductService;
import com.example.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> getAllProduct() {
        return productMapper.selectAll();
    }
}
