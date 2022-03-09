package com.sinensia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sinensia.model.Alumno;

public class AlumnoDao extends BaseDao implements IDao<Alumno> {
private Connection connect;
	
	@Override
	public int add(Alumno alumno) throws SQLException {
		int idalumno = 0;
		PreparedStatement preparedStatement = null; 
		ResultSet rsKey = null;
		try {
			connect = super.getconnection();
			preparedStatement = connect.prepareStatement("INSERT INTO alumno(nombre,apellidos,dni) VALUE (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, alumno.getNombre());
			preparedStatement.setString(2, alumno.getApellidos());
			preparedStatement.setString(3, alumno.getDni());
			
			preparedStatement.executeUpdate();
			rsKey = preparedStatement.getGeneratedKeys();
			
			rsKey.next();
			idalumno = rsKey.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rsKey != null) {
				rsKey.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		return idalumno;
	}

	@Override
	public int modify(Alumno alumno) throws SQLException {
		PreparedStatement preparedStatement = null; 
		ResultSet rsKey = null;
		int modificado=0;
		try {
			connect = super.getconnection();
			preparedStatement = connect.prepareStatement("UPDATE alumno SET nombre=?, apellidos=?, dni=? WHERE idalumno=?");
			preparedStatement.setString(1, alumno.getNombre());
			preparedStatement.setString(2, alumno.getApellidos());
			preparedStatement.setString(3, alumno.getDni());
			preparedStatement.setInt(4, alumno.getIdalumno());	
			modificado =preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rsKey != null) {
				rsKey.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		return modificado;
	}


	@Override
	public List<Alumno> get() throws SQLException {
		Alumno alumno = new Alumno();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Alumno> alumnos = null;
		try {
			connect = super.getconnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM alumno");
			rs= preparedStatement.executeQuery();
			alumnos = new ArrayList<Alumno>();
			while(rs.next()) {
				alumno.setIdalumno(rs.getInt("idalumno"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				alumno.setDni(rs.getString("dni"));
				alumnos.add(alumno);
			}		
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		return alumnos;		
	}

	@Override
	public Alumno getById(int id) throws SQLException {
		Alumno alumno = new Alumno();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connect =super.getconnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM alumno WHERE idalumno=?");
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				alumno.setIdalumno(rs.getInt("idalumno"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				alumno.setDni(rs.getString("dni"));
			}				
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		return alumno;
	}

	@Override
	public int remove(int id) throws SQLException {
		PreparedStatement preparedStatement = null; 
		ResultSet rsKey = null;
		int borrado=0;
		try {
			connect = super.getconnection();
			preparedStatement = connect.prepareStatement("DELETE FROM alumno WHERE idalumno=?");
			preparedStatement.setInt(1, id);			
			borrado =preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rsKey != null) {
				rsKey.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		return borrado;
	}


	@Override
	public int add(Alumno modelo, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}
