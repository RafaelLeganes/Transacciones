package com.sinensia.daocontracts;

import java.sql.SQLException;
import java.util.List;

public interface IAddWithConnection <T,U>{

	public boolean add(List<T> modelo, U connection) throws SQLException;
}
