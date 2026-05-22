package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {

	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);
	private static final String URL = "jdbc:postgresql://localhost:5432/tallerjdbc";
	private static final String USER = "postgres";
	private static final String PASSWORD = "Rm015056";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps;

		String sql = """
				INSERT INTO vehiculos(placa,marca,modelo,anio,precio,color,disponible,kilometraje)
				VALUES (?,?,?,?,?,?,?,?)
				""";

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(sql);
			
			ps.setString(1,"PDB-8986");
			ps.setString(2, "Chevrolet");
			ps.setString(3, "Aveo");
			ps.setInt(4, 2009);
			ps.setDouble(5, 7900);
			ps.setString(6, "Plomo");
			ps.setBoolean(7, false);
			ps.setInt(8, 210000);
			
			
			int filas = ps.executeUpdate();
			log.info("Vehiculo insertado");
			log.info("Filas insertadas: " + filas);
			
		} catch (SQLException e) {

			log.error("Error en la conexión" + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
