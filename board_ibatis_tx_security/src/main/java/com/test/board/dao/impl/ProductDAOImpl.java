package com.test.board.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.test.board.dao.ProductDAO;
import com.test.board.dto.ProductVO;


public class ProductDAOImpl implements ProductDAO {

	
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<ProductVO> getProductList() throws SQLException{
		List<ProductVO> productList 
			=(List<ProductVO>)client.queryForList("getProductList",null); 
		return productList;
	}

	@Override
	public List<ProductVO> getProductList(String name) throws SQLException{
		List<ProductVO> productList 
		=(List<ProductVO>)client.queryForList("getProductList",name); 
	return productList;
		
	}

	@Override
	public ProductVO getProduct(int pseq) throws SQLException {
		ProductVO product=(ProductVO)client.queryForObject("getProduct",pseq);
		return product;
	}

	@Override
	public int insertProduct(ProductVO product) throws SQLException {
		int result=client.update("insertProduct",product);
		return result;
	}


	@Override
	public int updateProduct(ProductVO product) throws SQLException {
		return client.update("updateProduct",product);
	}


	@Override
	public int deleteProduct(int pseq) throws SQLException {
		return client.update("deleteProduct",pseq);
	}

}





