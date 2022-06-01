package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.IndexForm;
import jp.co.example.entity.Product;

@Controller
public class IndexController {

    // 入力画面
    @RequestMapping("/index")
    public String index(@ModelAttribute("index") Model model) {
        // プルダウンの内容を作成
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(101, "鉛筆", 50));
        productList.add(new Product(102, "消しゴム", 100));

        // ビューに情報を渡す
        model.addAttribute("productList", productList);

        // 入力画面へ
        return "index";
    }

    // 結果画面
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@ModelAttribute("index") IndexForm form, Model model) {
        // 選択した情報を取得
        String userName = form.getUserName();
        int productId = form.getProductId();

        // 選択した商品IDを元に、productオブジェクトを作成
        Product product = null;
        switch (productId) {
        case 101:
            product = new Product(101, "鉛筆", 50);
            break;
        case 102:
            product = new Product(102, "消しゴム", 100);
            break;
        }

        // ビューに情報を渡す
        model.addAttribute("userName", userName);
        model.addAttribute("product", product);

        // 結果画面へ
        return "result";
    }

}
