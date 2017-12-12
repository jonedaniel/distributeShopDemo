package com.example.website.controller;

import com.example.shop.goods.domain.Product;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.LinkedList;

@RestController
public class TestRestController {

    /**
     * 返回部门所有的信息
     *
     * @return
     */
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public Object restIndex() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1L, "zmh");
        map.put(2L, "2BU");
        return map;
    }

    /**
     * 返回某个指定部门的信息
     * GET /list/1
     *
     * @return
     */
    @RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
    public Object restIndex1(@PathVariable("id") Long did) {
        HashMap<Object, Object> map  = new HashMap<>();
        LinkedList<Object>      maps = new LinkedList<>();
        map.put(1L, "zmh");
        maps.add(map);
        map = new HashMap<>();
        map.put(2L, "2BU");
        maps.add(map);
        return maps.get(Math.toIntExact(did));
    }

    /**
     * 新创建一个部门
     * POST departments
     *
     * @return
     */
    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public void createResources(Product product) {
        System.out.println(product.getName());
    }

    /**
     * 删除某个指定部门下某个指定的员工
     * DELETE /department/1/employee/1
     */
    @RequestMapping(value = "/departments/{did}/employees/{eid}", method = RequestMethod.DELETE)
    public void deleteResource(@PathVariable("did") int did, @PathVariable("eid") int eid) {
        System.out.println(did + ":" + eid);
    }

    /**
     * 同一个URL,使用不同的表现形式:json,xml
     */
    //    @RequestMapping(value = "/depts", method = RequestMethod.GET,headers = {"Accept=application/json"})
    @RequestMapping(value = "/depts", method = RequestMethod.GET,
            produces = "application/json")// produces = headers 为Accept
    public void departmentJson() {
        System.out.println("使用json的表现形式?");
    }

    @RequestMapping(value = "/depts",
            method = RequestMethod.GET,
            headers = {"Accept=application/xml"},
            params = {"id", "name"}) //必须有这两个参数
    public void departmentXml(Long id, String name) {
        System.out.println("使用xml的表现形式?" + id + ":" + name);
    }

    /**
     * 同一个URI,使用不容的请求体内容 比如:普通的form表单提交和用json请求体内容提交
     */
    //    @RequestMapping(value = "/depts", method = RequestMethod.POST, headers = "Content-Type=application/x-www-form-urlencoded")
    @RequestMapping(value = "/depts", method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded")//consumes = Headers 为Content-Type
    public void departmentForm(Product product) {
        System.out.println("form表单: " + product.getId() + ":" + product.getName());
    }

    @RequestMapping(value = "/depts", method = RequestMethod.POST, headers = "Content-Type=application/json")
    @ApiImplicitParam(name = "product", paramType = "body")
    public void departmentFormJson(@RequestBody Product product) {
        System.out.println("json表单: " + product.getId() + ":" + product.getName());
    }
}
