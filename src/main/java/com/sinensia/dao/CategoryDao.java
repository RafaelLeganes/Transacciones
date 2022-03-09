package com.sinensia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sinensia.model.Category;
import com.sinensia.model.Product;

public class CategoryDao extends BaseDao implements IDao<Category> {

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
					productdao.add(producto, connect);
				}
			}
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connect.rollback();
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

	@Override
	public int modify(Category modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> get() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Category modelo, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
