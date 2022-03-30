package com.sinensia.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sinensia.daocontracts.IAdd;
import com.sinensia.daocontracts.IAddWithConnection;
import com.sinensia.model.Category;
import com.sinensia.model.Product;

public class ProductDaoIntegrationTest extends BaseDao{

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
		List<Product> productos = new ArrayList<Product>();
		Product producto = new Product();
		IAddWithConnection<Product,Connection> productDao = new ProductDao();
		producto.setProductName("Silla");
		Category category = new Category();
		IAdd<Category> categoryDao = new CategoryDao();
		category.setCategoryName("Telas");
		int categoryId = categoryDao.add(category);
		producto.setCategoryId(categoryId);
		productos.add(producto);
		category.setProductos(productos);
		boolean correcto = productDao.add(productos, connect);
		assertTrue(correcto==true);
	}

}
