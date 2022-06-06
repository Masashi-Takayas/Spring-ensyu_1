package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ProductDao;
import jp.co.example.entity.Product;

/**
 * productsテーブル用DAO
 */
@Repository
public class PgProductDao implements ProductDao {

    private static final String SELECT_BY_PRODUCT_ID = "SELECT * FROM products WHERE product_id = :productId ORDER BY product_id";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * ID指定検索
     */
    @Override
    public Product findByProductId(Integer productId) {
        // SQL文準備
        String sql = SELECT_BY_PRODUCT_ID;

        // プレースホルダーへの埋め込み値を用意
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("productId", productId); // 引数で受け取った値をセット

        // SQL文を実行し、実行結果をList<Product>型の変数にセット
        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        // (実行結果が無い場合はnull、ある場合は、リストの0番目の要素を返却(Product型で返却するため))
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}

