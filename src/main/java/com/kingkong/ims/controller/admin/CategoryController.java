/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingkong.ims.controller.admin;

import com.kingkong.ims.entity.Category;
import com.kingkong.ims.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kiran
 */
@Controller
@RequestMapping(value = "/")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        Category category = new Category(1, "Apparels", "Apparels Description goes here", true);
        categoryService.insert(category);
        return "/admin/category/index";
    }
}
