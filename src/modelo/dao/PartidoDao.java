package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.PartidoVo;

public class PartidoDao {

	public void crearPartido(PartidoVo partido) throws Exception{
		Conexion conex= new Conexion();

		try {
			Statement estatuto = conex.getConnection().createStatement();
			
			if(partido.getIdEquipoLocal() == partido.getIdEquipoVis()) {
				JOptionPane.showMessageDialog(null, "Ambos Equipos son Iguales","Error",JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
			
			//Comprobación de Hora
			
			if(partido.getHora().length() != 5) {
				JOptionPane.showMessageDialog(null, "Formato de Fecha Erroneo (HH:MM)","Error",JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
			
			if(partido.getHora().charAt(0) != '0' && partido.getHora().charAt(0) != '1' && partido.getHora().charAt(0) != '2') {
				JOptionPane.showMessageDialog(null, "Hora Erronea","Error",JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
			
			if(partido.getHora().charAt(1) != '0' && partido.getHora().charAt(1) != '1' && partido.getHora().charAt(1) != '2' && partido.getHora().charAt(1) != '3' && partido.getHora().charAt(1) != '4' && partido.getHora().charAt(1) != '5' && partido.getHora().charAt(1) != '6' && partido.getHora().charAt(1) != '7' && partido.getHora().charAt(1) != '8' && partido.getHora().charAt(1) != '9' ) {
				JOptionPane.showMessageDialog(null, "Hora Erronea","Error",JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
			
			if(partido.getHora().charAt(2) != ':') {
				JOptionPane.showMessageDialog(null, "Formato de Fecha Erroneo (HH:MM)","Error",JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
			
			if(partido.getHora().charAt(3) != '0' && partido.getHora().charAt(3) != '1' && partido.getHora().charAt(3) != '2' && partido.getHora().charAt(3) != '3' && partido.getHora().charAt(3) != '4' && partido.getHora().charAt(3) != '5') {
				JOptionPane.showMessageDialog(null, "Hora Erronea","Error",JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
			
			if(partido.getHora().charAt(4) != '0' && partido.getHora().charAt(4) != '1' && partido.getHora().charAt(4) != '2' && partido.getHora().charAt(4) != '3' && partido.getHora().charAt(4) != '4' && partido.getHora().charAt(4) != '5' && partido.getHora().charAt(4) != '6' && partido.getHora().charAt(4) != '7' && partido.getHora().charAt(4) != '8' && partido.getHora().charAt(4) != '9' ) {
				JOptionPane.showMessageDialog(null, "Hora Erronea","Error",JOptionPane.ERROR_MESSAGE);
				throw new Exception();
			}
			
			//------
			
			estatuto.executeUpdate("INSERT INTO partido (idEquipoLocal, idEquipoVis, idArbitro, fecha, hora) VALUES ('"
					+ partido.getIdEquipoLocal() + "', '" + partido.getIdEquipoVis() + "', '" + partido.getIdArbitro()
					+ "', '" + partido.getFecha() + "', '" + partido.getHora() + "')");

			JOptionPane.showMessageDialog(null, "Partido Creado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		} catch (Exception e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No Creado");
		}
	}

	public void modificarPartido(PartidoVo partido) {
		Conexion conex = new Conexion();

		try {
			String consulta = "UPDATE partido SET idEquipoLocal = ? , idEquipoVis=? , idArbitro=? , fecha=? ,  hora=? , golesLocal=? , golesVis=? , tarjAma=? , tarjRojas=? WHERE idPartido= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);

			estatuto.setInt(1, partido.getIdEquipoLocal());
			estatuto.setInt(2, partido.getIdEquipoVis());
			estatuto.setInt(3, partido.getIdArbitro());
			estatuto.setString(4, partido.getFecha());
			estatuto.setString(5, partido.getHora());
			estatuto.setInt(6, partido.getGolesLocal());
			estatuto.setInt(7, partido.getGolesVis());
			estatuto.setInt(8, partido.getTarjAma());
			estatuto.setInt(9, partido.getTarRojas());
			estatuto.setInt(10, partido.getIdPartido());
			estatuto.executeUpdate();

			JOptionPane.showMessageDialog(null, " Se ha Modificado el Partido Correctamente ", "Confirmación",
					JOptionPane.INFORMATION_MESSAGE);

			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {

			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Error al Modificar el Partido", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void eliminarPartido(int idPartido) {
		Conexion conex = new Conexion();

		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM partido WHERE idPartido='" + idPartido + "'");
			JOptionPane.showMessageDialog(null, " Se ha Eliminado el Partido Correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino el Partido");
		}
	}

	public PartidoVo buscarPartido(int idPartido) {
		Conexion conex = new Conexion();

		PartidoVo partido = new PartidoVo();
		boolean existe = false;

		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM partido where idPartido = ? ");
			consulta.setInt(1, idPartido);
			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				existe = true;
				partido.setIdPartido(Integer.parseInt(res.getString("idPartido")));
				partido.setIdEquipoLocal(Integer.parseInt(res.getString("idEquipoLocal")));
				partido.setIdEquipoVis(Integer.parseInt(res.getString("idEquipoVis")));
				partido.setIdArbitro(Integer.parseInt(res.getString("idArbitro")));
				partido.setFecha(res.getString("fecha"));
				partido.setHora(res.getString("hora"));
				partido.setGolesLocal(Integer.parseInt(res.getString("golesLocal")));
				partido.setGolesVis(Integer.parseInt(res.getString("golesVis")));
				partido.setTarjAma(Integer.parseInt(res.getString("tarjAma")));
				partido.setTarRojas(Integer.parseInt(res.getString("tarRojas")));
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}

		if (existe) {
			return partido;
		} else
			return null;
	}

	public ArrayList<PartidoVo> buscarPartidos() {
		Conexion conexion = new Conexion();

		ArrayList<PartidoVo> partidos = new ArrayList<>();

		try {
			PreparedStatement consulta = conexion.getConnection().prepareStatement("SELECT * FROM partido");
			ResultSet respuesta = consulta.executeQuery();

			while (respuesta.next()) {
				if (respuesta.getString(7)==null) {
					partidos.add(new PartidoVo(Integer.parseInt(respuesta.getString(1)),
							Integer.parseInt(respuesta.getString(2)), Integer.parseInt(respuesta.getString(3)),
							Integer.parseInt(respuesta.getString(4)), respuesta.getString(5), respuesta.getString(6)));
				} else {
					partidos.add(new PartidoVo(Integer.parseInt(respuesta.getString(1)),
							Integer.parseInt(respuesta.getString(2)), Integer.parseInt(respuesta.getString(3)),
							Integer.parseInt(respuesta.getString(4)), respuesta.getString(5), respuesta.getString(6),
							Integer.parseInt(respuesta.getString(7)), Integer.parseInt(respuesta.getString(8)),
							Integer.parseInt(respuesta.getString(9)), Integer.parseInt(respuesta.getString(10))));
				}
			}

			respuesta.close();
			consulta.close();
			conexion.desconectar();

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage()); // al parecer el error esta aqui
		}

		return partidos;

	}

	public ArrayList<PartidoVo> buscarPartidos(int idArbitro) {
		Conexion conexion = new Conexion();

		ArrayList<PartidoVo> partidos = new ArrayList<>();

		try {
			PreparedStatement consulta = conexion.getConnection()
					.prepareStatement("select * from partido where idArbitro=" + idArbitro
							+ " and golesLocal is null and golesVis is null");
			ResultSet respuesta = consulta.executeQuery();

			while (respuesta.next()) {
				partidos.add(new PartidoVo(Integer.parseInt(respuesta.getString(1)),
						Integer.parseInt(respuesta.getString(2)), Integer.parseInt(respuesta.getString(3)),
						Integer.parseInt(respuesta.getString(4)), respuesta.getString(5), respuesta.getString(6)));
			}

			respuesta.close();
			consulta.close();
			conexion.desconectar();

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		}

		return partidos;

	}

}
