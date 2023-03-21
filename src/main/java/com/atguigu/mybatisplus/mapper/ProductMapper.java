package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

/**
 * @author 陆钱江
 * @create 2022-10-24 21:06
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
