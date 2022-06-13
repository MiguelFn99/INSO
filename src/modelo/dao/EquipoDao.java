package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.EquipoVo;

public class EquipoDao {

	public void crearEquipo(EquipoVo equipo) {
		Conexion conex = new Conexion();

		try {
			PreparedStatement estatuto = conex.getConnection()
					.prepareStatement("INSERT INTO equipo (nombre) VALUES (?) ");
			estatuto.setString(1, equipo.getNombre());
			estatuto.execute();
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Informaci�n",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}

	}

	public void modificarEquipo(EquipoVo equipo) {
		Conexion conex = new Conexion();
		try {
			String consulta = "UPDATE equipo SET nombre = ? , puntos=? , golesFav=? ,  golesContra=? WHERE idEquipo= ?";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
	
			estatuto.setString(1, equipo.getNombre());
			estatuto.setInt(2, equipo.getPuntos());
			estatuto.setInt(3, equipo.getGolesFav());
			estatuto.setInt(4, equipo.getGolesContra());
			estatuto.setInt(5, equipo.getIdEquipo());
			estatuto.executeUpdate();

			//JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al Modificar", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void eliminarEquipo(int idEquipo) {
		Conexion conex = new Conexion();
		try {
			Statement estatutoPartido = conex.getConnection().createStatement();
			estatutoPartido.executeUpdate("DELETE FROM partido WHERE idEquipoLocal="+idEquipo+" OR idEquipoVis="+idEquipo);
			Statement estatutoJugadores = conex.getConnection().createStatement();
			estatutoJugadores.executeUpdate("DELETE FROM jugador WHERE idEquipo="+idEquipo);
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM equipo WHERE idEquipo=" + idEquipo);
			JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			estatutoJugadores.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

	public EquipoVo buscarEquipo(int idEquipo) {
		Conexion conex = new Conexion();
		EquipoVo equipo = new EquipoVo();
		boolean existe = false;
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM equipo where idEquipo = ? ");
			consulta.setInt(1, idEquipo);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				existe = true;
				equipo.setIdEquipo(Integer.parseInt(res.getString("idEquipo")));
				equipo.setNombre(res.getString("nombre"));
				equipo.setPuntos(Integer.parseInt(res.getString("puntos")));
				equipo.setGolesFav(Integer.parseInt(res.getString("golesFav")));
				equipo.setGolesContra(Integer.parseInt(res.getString("golesContra")));
			}
			res.close();
			conex.desconectar();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}

		if (existe) {
			return equipo;
		} else
			return null;
	}

	public ArrayList<EquipoVo> buscarEquipos() {
		ArrayList<EquipoVo> equipos = new ArrayList<>();
		Conexion conexion = new Conexion();

		try {
			PreparedStatement consulta = conexion.getConnection().prepareStatement("SELECT * FROM equipo ORDER BY puntos DESC");
			ResultSet respuesta = consulta.executeQuery();
			while (respuesta.next()) {
				EquipoVo equipo = new EquipoVo();
				equipo.setIdEquipo(respuesta.getInt(1));
				equipo.setNombre(respuesta.getString(2));
				equipo.setPuntos(respuesta.getInt(3));
				equipo.setGolesFav(respuesta.getInt(4));
				equipo.setGolesContra(respuesta.getInt(5));
				equipos.add(equipo);
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
		conexion.desconectar();
		return equipos;
	}

}
