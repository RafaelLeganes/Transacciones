package com.sinensia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sinensia.daocontracts.IAdd;
import com.sinensia.model.Category;
import com.sinensia.model.Product;

public class CategoryDao extends BaseDao implements IAdd<Category> {

	@Override
	public int add(Category category) throws SQLException {
		PreparedStatement preparedStatement = null; 
		ResultSet rsKey = null;
		Connection connect = null;
		int categoryId=0;
		try {
			connect = (Connection) super.getconnection();
			connect.setAutoCommit(false);
			preparedStatement = connect.prepareStatement("INSERT INTO Categories(categoryName) VALUE (?)",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, category.getCategoryName());
			
			preparedStatement.executeUpdate();
			rsKey = preparedStatement.getGeneratedKeys();
	
			rsKey.next();
			categoryId = rsKey.getInt(1);
			ProductDao productdao= new ProductDao();
			if(category.getProductos()!=null) {
				for(Product producto: category.getProductos()) {
					producto.setCategoryId(categoryId);
				}
				productdao.add(category.getProductos(), connect);
			}
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if(connect != null) {
				try{
					connect.rollback();
				} catch(SQLException e1) {
					e1.printStackTrace();
					throw e1;
				}
			}
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rsKey != null) {
				rsKey.close();
			}
			if(connect!=null) {
				connect.close();
			}
		}
		return categoryId;
	}
}
