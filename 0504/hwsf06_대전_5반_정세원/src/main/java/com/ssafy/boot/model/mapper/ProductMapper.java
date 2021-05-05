package com.ssafy.boot.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.boot.model.dto.Product;


@Mapper
public interface ProductMapper {
	public int insert(Product product);
	public Product select(String pCode);
	public List<Product> selectAll();
}
