package com.sinensia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.sinensia.model.Product;

public class ProductDao extends BaseDao implements IDao<Product> {

	@Override
	public int add(Product producto, Connection con) throws SQLException {
		PreparedStatement preparedStatement = null; 
		ResultSet rsKeyProduct = null;
		Connection connect;
		int ProductId=0;
		try {
			connect = con;
			preparedStatement = connect.prepareStatement("INSERT INTO Products(productName, categoryId) VALUE (?,?)",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, producto.getProductName());
			preparedStatement.setInt(2, producto.getCategoryId());
			
			preparedStatement.executeUpdate();
			rsKeyProduct = preparedStatement.getGeneratedKeys();
			
			rsKeyProduct.next();
			ProductId = rsKeyProduct.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rsKeyProduct != null) {
				rsKeyProduct.close();
			}
		}
		return ProductId;
	}

	@Override
	public int modify(Product modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> get() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Product modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
