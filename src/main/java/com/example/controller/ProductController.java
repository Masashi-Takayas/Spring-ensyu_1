package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.ProductForm;
import jp.co.example.entity.Product;
import jp.co.example.service.ProductService;

/**
 * コントローラ
 */
@Controller
public class ProductController {

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
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@ModelAttribute("product") ProductForm form, Model model) {
        // データを取得
        Product product = productService.findByProductId(form.getProductId());

        if(product == null) {
            // データがない場合
            model.addAttribute("msg", "対象のデータはありません");

            return "top";
        } else {
            // データがある場合
            model.addAttribute("product", product);

            return "searchResult";
        }

    }

}

