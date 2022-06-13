package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.JugadorVo;

public class JugadorDao {

	public void crearJugador(JugadorVo jugador) {

		Conexion conex = new Conexion();
		try {
					String sql = "INSERT INTO jugador (nombre, apellidos, dni, dorsal, fechanac, goles, asistencias, tarjAma, tarjRojas, idEquipo, capitan, email, contrasena) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement estatuto = conex.getConnection().prepareStatement(sql);
		            estatuto.setString(1, jugador.getNombre());
		            estatuto.setString(2, jugador.getApellidos());
		            estatuto.setString(3, jugador.getDni());
		            estatuto.setInt(4, jugador.getDorsal());
		            estatuto.setString(5, jugador.getFechanac().toString());
		            estatuto.setInt(6, jugador.getGoles());
		            estatuto.setInt(7, jugador.getAsistencias());
		            estatuto.setInt(8, jugador.getTarjAma());
		            estatuto.setInt(9, jugador.getTarjRojas());
		            estatuto.setInt(10, jugador.getIdEquipo());
		            estatuto.setInt(11, jugador.isCapitan());
		            estatuto.setString(12, jugador.getEmail());
		            estatuto.setString(13, jugador.getContrasena());
		            estatuto.executeUpdate();
		            
					JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
					
					estatuto.close();
					conex.desconectar();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}

	}

	public void modificarJugador(JugadorVo jugador) {

		Conexion conex= new Conexion();
		try{
			String consulta= "UPDATE jugador SET nombre = ?, apellidos = ?, dni = ?, dorsal = ?, fechanac = ?, goles = ?, asistencias = ?,tarjAma = ?, tarjRojas = ?, idEquipo = ?, capitan = ?, email= ?, contrasena=? WHERE idJugador=?";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, jugador.getNombre());
            estatuto.setString(2, jugador.getApellidos());
            estatuto.setString(3, jugador.getDni());
            estatuto.setInt(4, jugador.getDorsal());
            estatuto.setString(5, jugador.getFechanac().toString());
            estatuto.setInt(6, jugador.getGoles());
            estatuto.setInt(7, jugador.getAsistencias());
            estatuto.setInt(8, jugador.getTarjAma());
            estatuto.setInt(9, jugador.getTarjRojas());
            estatuto.setInt(10, jugador.getIdEquipo());
            estatuto.setInt(11, jugador.isCapitan());
            estatuto.setString(12, jugador.getEmail());
            estatuto.setString(13, jugador.getContrasena());
            estatuto.setInt(14, jugador.getIdJugador());
            estatuto.executeUpdate();

          //JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          	
          	estatuto.close();
          	conex.desconectar();

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarJugador(int idJugador) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM jugador WHERE idJugador="+idJugador);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}

	}

	public JugadorVo buscarJugador(int idJugador) {
		Conexion conex = new Conexion();
		JugadorVo jugador = new JugadorVo();
		boolean existe = false;
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM jugador where idJugador = ? ");
			consulta.setInt(1, idJugador);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				existe = true;
				jugador.setIdJugador(Integer.parseInt(res.getString("idJugador")));
				jugador.setNombre(res.getString("nombre"));
				jugador.setApellidos(res.getString("apellidos"));
				jugador.setDni(res.getString("dni"));
				jugador.setDorsal(Integer.parseInt(res.getString("dorsal")));
				jugador.setFechanac(res.getString("fechanac"));
				jugador.setGoles(Integer.parseInt(res.getString("goles")));
				jugador.setAsistencias(Integer.parseInt(res.getString("asistencias")));
				jugador.setTarjAma(Integer.parseInt(res.getString("tarjAma")));
				jugador.setTarjRojas(Integer.parseInt(res.getString("tarjRojas")));
				jugador.setIdEquipo(Integer.parseInt(res.getString("idEquipo")));
				jugador.setCapitan(res.getBoolean("capitan"));
				jugador.setEmail(res.getString("email"));
				jugador.setContrasena(res.getString("contrasena"));
			 }
			
			consulta.close();
			res.close();
			conex.desconectar();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}

		if (existe) {
			return jugador;
		} else
			return null;
	}
	
	public ArrayList<JugadorVo> buscarJugadores(){
		ArrayList<JugadorVo> jugadores = new ArrayList<>();
		Conexion conexion = new Conexion();
		try {
			PreparedStatement consulta = conexion.getConnection().prepareStatement("SELECT * FROM jugador ORDER BY goles DESC");
			ResultSet respuesta = consulta.executeQuery();
			while(respuesta.next()) {
				jugadores.add(new JugadorVo(Integer.parseInt(respuesta.getString(1)),
						respuesta.getString(2),
						respuesta.getString(3),
						respuesta.getString(4),
						Integer.parseInt(respuesta.getString(5)),
						respuesta.getString(6),
						Integer.parseInt(respuesta.getString(7)),
						Integer.parseInt(respuesta.getString(8)),
						Integer.parseInt(respuesta.getString(9)),
						Integer.parseInt(respuesta.getString(10)),
						Integer.parseInt(respuesta.getString(11)),
						respuesta.getBoolean(12),
						respuesta.getString(13),
						respuesta.getString(14)
						));
			}
			
			respuesta.close();
			conexion.desconectar();
			
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage()); //al parecer el error esta aqui
		}
		
		return jugadores;
	}

	public ArrayList<JugadorVo> buscarJugadoresEquipo(int idEquipo) {

		ArrayList<JugadorVo> jugadores = new ArrayList<>();
		Conexion conexion = new Conexion();
		try {
			PreparedStatement consulta = conexion.getConnection()
					.prepareStatement("SELECT * FROM jugador WHERE idEquipo = " + idEquipo + " ORDER BY dorsal");
			ResultSet respuesta = consulta.executeQuery();
			while (respuesta.next()) {
				jugadores.add(new JugadorVo(respuesta.getInt(1), respuesta.getString(2), respuesta.getString(3),
						respuesta.getString(4), respuesta.getInt(5), respuesta.getString(6), respuesta.getInt(7),
						respuesta.getInt(8), respuesta.getInt(9), respuesta.getInt(10), respuesta.getInt(11),
						respuesta.getBoolean(12), respuesta.getString(13), respuesta.getString(14)));
			}
			consulta.close();
			respuesta.close();
			conexion.desconectar();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage()); // al parecer el error esta aqui
		}
		conexion.desconectar();
		return jugadores;

	}
	
}
