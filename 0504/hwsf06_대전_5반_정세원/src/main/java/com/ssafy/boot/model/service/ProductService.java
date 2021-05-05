package com.ssafy.boot.model.service;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.boot.model.dto.Product;
import com.ssafy.boot.model.mapper.ProductMapper;

@Service
public class ProductService{
	
	@Autowired
	private SqlSession pdao;
	
	public boolean insert(Product product) throws SQLException{
		if (product.getQuantity() == null)
			return false;
		if(pdao.getMapper(ProductMapper.class).insert(product)>0)
			return true;
		return false;
	}

//	public Product select(String pCode) throws SQLException {
//		return pdao.getMapper(ProductMapper.class).select(pCode);
//	}

	public List<Product> selectAll() throws SQLException {
		return pdao.getMapper(ProductMapper.class).selectAll();
	}

}