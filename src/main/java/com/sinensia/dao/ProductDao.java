package com.sinensia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sinensia.daocontracts.IAddWithConnection;
import com.sinensia.model.Product;

public class ProductDao extends BaseDao implements IAddWithConnection<Product, Connection> {


	public boolean add(List<Product> productos, Connection connect) throws SQLException {
		PreparedStatement preparedStatement = null; 
		try {
			for(Product producto: productos) {
				preparedStatement = connect.prepareStatement("INSERT INTO Products(productName, categoryId) VALUE (?,?)",Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, producto.getProductName());
				preparedStatement.setInt(2, producto.getCategoryId());	
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
		}
		return false;
	}
}
