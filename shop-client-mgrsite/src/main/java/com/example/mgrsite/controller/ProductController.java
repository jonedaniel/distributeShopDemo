package com.example.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.shop.goods.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Reference
    IProductService productService;

    @RequestMapping("/productList")
    @ResponseBody
    public Object index() {
        return  productService.getAllProduct();
    }
}
