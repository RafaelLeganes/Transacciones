package com.sinensia.dao;


import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sinensia.model.Alumno;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlumnoDaoIntegrationTest {

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

	private static int idAlumno =0;
	
	@Test
	public void test1Add() throws Exception{
		Alumno alumno = new Alumno();
		IDao<Alumno> alumnoDao = new AlumnoDao();
		alumno.setNombre("Pepe");
		alumno.setApellidos("soto");
		alumno.setDni("45324523Z");
		idAlumno = alumnoDao.add(alumno);
		assertTrue(idAlumno>0);		
	}


	@Test
	public void test2Modify() throws Exception {
		Alumno alumno = new Alumno();
		IDao<Alumno> alumnoDao = new AlumnoDao();
		alumno.setNombre("Pepe");
		alumno.setApellidos("soto");
		alumno.setDni("45324523Z");
		alumno.setIdalumno(idAlumno);
		assertTrue(alumnoDao.modify(alumno)>0);
	}

	@Test
	public void test3Get() throws SQLException {
		IDao<Alumno> alumnoDao = new AlumnoDao();
		assertTrue(alumnoDao.get().size()>0);
	}

	@Test
	public void test4GetById() throws SQLException {
		IDao<Alumno> alumnoDao = new AlumnoDao();
		assertTrue(alumnoDao.getById(idAlumno) != null);
	}

	@Test
	public void test5Remove() throws SQLException {
		IDao<Alumno> alumnoDao = new AlumnoDao();
		assertTrue(alumnoDao.remove(idAlumno)>0);
	}

}
