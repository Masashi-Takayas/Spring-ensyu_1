package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.form.ProductForm;
import com.example.entity.Product;
import com.example.service.ProductService;

/**
 * コントローラ
 */
@Controller
public class ProductController {

    /**
     * メッセージリソース用
     */
    @Autowired
    MessageSource messageSource;

    /**
     * productsテーブル用サービス
     */
    @Autowired
    ProductService productService;

    /**
     * トップ画面表示
     */
    @RequestMapping("/top")
    public String index(@ModelAttribute("product") ProductForm form, Model model) {
        return "top";
    }

    /**
     * 検索結果画面遷移
     */
    @RequestMapping(value = "/execute", params = "search", method = RequestMethod.POST)
    public String search(@Validated @ModelAttribute("product") ProductForm form, BindingResult bindingResult, Model model) {
        Product product = new Product(form.getProductId(), form.getProductName(), form.getPrice());

        List<Product> list = productService.find(product);

        if (list.isEmpty()) {
            // メッセージリソースファイルから、メッセージを取得
            String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
            model.addAttribute("msg", errMsg);

            return "top";
        } else {
            model.addAttribute("productList", list);

            return "searchResult";
        }
    }
    
    @RequestMapping(value = "/main", params = "play", method = RequestMethod.POST)
    public String play(@Validated @ModelAttribute("product") ProductForm form, BindingResult bindingResult, Model model) {

            return "play";
    }
    
    /**
     * 登録完了画面遷移
     */
    @RequestMapping(value = "/execute", params = "insert", method = RequestMethod.POST)
    public String insert(@Validated @ModelAttribute("product") ProductForm form, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "top";
        }

        Product product = new Product(form.getProductId(), form.getProductName(), form.getPrice());

        productService.insert(product);

        return "insertResult";
    }
}

