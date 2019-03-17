package cn.enjoy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.enjoy.mapper.ProductMapper;
import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;

@Service
public class ProductServiceImpl implements IProductService{
	@Resource
    private ProductMapper productMapper;

    @Override
    public Product get(long id) {
        return productMapper.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return productMapper.create(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }

}
