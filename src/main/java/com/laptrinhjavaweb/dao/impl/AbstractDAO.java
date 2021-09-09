/*
* (C) Java Core
*
* @author DELL
* @date	7 thg 9, 2021
* @version 1.0
*/

package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IGenericDAO;
import com.laptrinhjavaweb.mapper.IRowMapper;

public class AbstractDAO<T> implements IGenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javajspservlet";
			String user = "root";
			String password = "123456789";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> iRowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameters(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				results.add(iRowMapper.mappRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				return null;
			}
		}
	}

	private void setParameters(PreparedStatement preparedStatement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				int index = i + 1;
				Object object = parameters[i];
				if (object instanceof Long) {
					preparedStatement.setLong(index, (Long) object);
				} else if (object instanceof String) {
					preparedStatement.setString(index, (String) object);
				} else if (object instanceof Integer) {
					preparedStatement.setInt(index, (Integer) object);
				} else if (object instanceof Timestamp) {
					preparedStatement.setTimestamp(index, (Timestamp) object);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setParameters(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}

	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		Long id = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			setParameters(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}
