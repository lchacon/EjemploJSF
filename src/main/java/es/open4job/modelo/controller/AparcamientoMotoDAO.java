package es.open4job.modelo.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.open4job.modelo.bean.AparcamientoMotosBean;

@ManagedBean
@SessionScoped
public class AparcamientoMotoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger
			.getLogger(AparcamientoMotoDAO.class.getName());

	// resource injection
	// @Resource(name="jdbc/mysql")
	private DataSource ds;

	// if resource injection is not support, you still can get it manually.
	public AparcamientoMotoDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	// listado de aparcamiento de motos
	public List<AparcamientoMotosBean> getLstAparcamientoMoto()
			throws NamingException, SQLException {
		List<AparcamientoMotosBean> lsitAparcamientoMotos = new ArrayList<AparcamientoMotosBean>();

		AparcamientoMotosBean motoVO = null;

		if (ds == null)
			throw new SQLException("Can't get data source");

		// get database connection
		Connection con = ds.getConnection();

		if (con == null)
			throw new SQLException("Can't get database connection");

		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM APARCAMIENTOSMOTOS");

		// get customer data from database
		ResultSet result = ps.executeQuery();

		while (result.next()) {
			motoVO = new AparcamientoMotosBean(result.getDouble("latitud"),
					result.getDouble("longitud"), result.getString("titulo"),
					result.getString("icono"), result.getString("descripcion"),
					result.getString("last_update"), result.getInt("plazas"),
					result.getInt("id"));

			lsitAparcamientoMotos.add(motoVO);
		}

		return lsitAparcamientoMotos;
	}

	/*
	 * Detalles de Aparcamiento de motos
	 * 
	 * public AparcamientoMotosBean getDetailAparcamientoMoto(int motoId) throws
	 * NamingException {
	 * 
	 * AparcamientoMotosBean aptoMoto = null; String query =
	 * "SELECT * FROM APARCAMIENTOSMOTOS WHERE id=?"; ResultSet rset = null;
	 * PreparedStatement stmt = null;
	 * 
	 * try { this.abrirConexion(); // stmt = connection.createStatement(); stmt
	 * = connection.prepareStatement(query); stmt.setInt(1, motoId); rset =
	 * stmt.executeQuery();
	 * 
	 * while (rset.next()) { AparcamientoMotosBean moto = new
	 * AparcamientoMotosBean( rset.getDouble("latitud"),
	 * rset.getDouble("longitud"), rset.getString("titulo"),
	 * rset.getString("icono"), rset.getString("descripcion"),
	 * rset.getString("last_update"), rset.getInt("plazas"), rset.getInt("id"));
	 * aptoMoto = moto; } stmt.close(); } catch (SQLException e) {
	 * logger.log(Level.SEVERE, "SQLException : " + e.getMessage()); } catch
	 * (ClassNotFoundException e) { logger.log(Level.SEVERE,
	 * "ClassNotFoundException : " + e.getMessage());
	 * 
	 * } finally {
	 * 
	 * if (rset != null) { try { rset.close(); } catch (Exception e) { } }
	 * 
	 * if (stmt != null) { try { stmt.close(); } catch (Exception e) { } }
	 * 
	 * } return aptoMoto;
	 * 
	 * }
	 */
}
