package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {

	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					UPDATE vehiculos SET marca = ?, modelo = ?, anio = ?, precio = ?,color = ?,disponible = ?
					WHERE placa = ?
					""";
			ps = con.prepareStatement(sql);

			ps.setString(1, "Chevrolet");
			ps.setString(2, "Aveo");
			ps.setInt(3, 2009);
			ps.setDouble(4, 7500);
			ps.setString(5, "Plomo");
			ps.setBoolean(6, true);

			ps.setString(7, "PDB-8986");

			int filas = ps.executeUpdate();

			log.info("Vehiculo Actualizado");
			log.info("Filas actualizadas: " + filas);

		} catch (Exception e) {
			log.error("Error al actualizar", e.getMessage());
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
