package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ProductDao;
import jp.co.example.entity.Product;
import jp.co.example.service.ProductService;

/**
 * productsテーブル用サービス実装クラス
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * IDを指定した検索
     */
    @Override
    public Product findByProductId(Integer productId) {
        return productDao.findByProductId(productId);
    }

}

