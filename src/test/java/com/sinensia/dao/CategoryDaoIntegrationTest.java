package com.sinensia.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sinensia.daocontracts.IAdd;
import com.sinensia.model.Category;
import com.sinensia.model.Product;

public class CategoryDaoIntegrationTest {
	
	private static int categoryId =0;
	
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
	public void testAddCategory() throws SQLException {
		Category category = new Category();
		IAdd<Category> categoryDao = new CategoryDao();
		category.setCategoryName("Telas");
		categoryId = categoryDao.add(category);
		assertTrue(categoryId>0);			
	}
	
	@Test
	public void testAddCategory2() throws SQLException {
		Category category = new Category();
		List<Product> listaProduct = new ArrayList<Product>();
		IAdd<Category> categoryDao = new CategoryDao();
		category.setCategoryName("Mueble");
		Product product = new Product();
		product.setProductName("Mesa");
		product.setCategoryId(categoryId);
		listaProduct.add(product);
		Product product2 = new Product();
		product2.setProductName("Cama");
		product2.setCategoryId(categoryId);
		listaProduct.add(product2);
		category.setProductos(listaProduct);
		categoryId = categoryDao.add(category);
		assertTrue(categoryId>0);			
	}

}
