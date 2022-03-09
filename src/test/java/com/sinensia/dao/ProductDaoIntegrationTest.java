package com.sinensia.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sinensia.model.Category;
import com.sinensia.model.Product;

public class ProductDaoIntegrationTest extends BaseDao{
	
	private static int productId =0;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddProductConnection() throws SQLException {
		Connection connect = (Connection) super.getconnection();
		Product producto = new Product();
		IDao<Product> productDao = new ProductDao();
		producto.setProductName("Silla");
		Category category = new Category();
		IDao<Category> categoryDao = new CategoryDao();
		category.setCategoryName("Telas");
		int categoryId = categoryDao.add(category);
		producto.setCategoryId(categoryId);
		productId = productDao.add(producto, connect);
		assertTrue(productId>0);
	}

}
