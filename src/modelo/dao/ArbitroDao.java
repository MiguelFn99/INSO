package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.ArbitroVo;


public class ArbitroDao {

	public void crearArbitro(ArbitroVo arbitro){
		Conexion conex= new Conexion();
		
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO arbitro (nombre, apellidos, dni, fechanac, licencia, email, contrasena) VALUES ('"
					+arbitro.getNombre()+"', '"+arbitro.getApellidos()+"', '"
					+arbitro.getDni()+"', '"+arbitro.getFechanac()+"', '"+ arbitro.getLicencia()+"', '"+arbitro.getEmail()+"', '"+arbitro.getContrasena()+"')");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
		
	}

	public void modificarArbitro(ArbitroVo arbitro){
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE arbitro SET idArbitro= ? ,nombre = ? , apellidos=? , dni=? , fechanac=? ,  licencia=? , email=? , contrasena=? WHERE idArbitro= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, arbitro.getIdArbitro());
            estatuto.setString(2, arbitro.getNombre());
            estatuto.setString(3, arbitro.getApellidos());
            estatuto.setString(4, arbitro.getDni());
            estatuto.setString(5, arbitro.getFechanac());
            estatuto.setInt(6, arbitro.getLicencia());
            estatuto.setString(7, arbitro.getEmail());
            estatuto.setString(8, arbitro.getContrasena());
            estatuto.setInt(9, arbitro.getIdArbitro());
            estatuto.executeUpdate();

            JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();
         
        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarArbitro(int idArbitro){
		Conexion conex= new Conexion();
		try {
			Statement estPartido = conex.getConnection().createStatement();
			estPartido.executeUpdate("DELETE FROM partido WHERE idArbitro="+idArbitro);
			Statement estatuto = conex.getConnection().createStatement();
			estPartido.close();
			estatuto.executeUpdate("DELETE FROM arbitro WHERE idArbitro="+idArbitro);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

	public ArbitroVo buscarArbitro(int idArbitro){
		Conexion conex= new Conexion();
		ArbitroVo arbitro= new ArbitroVo();
		boolean existe=false;
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM arbitro where idArbitro = ? ");
			consulta.setInt(1, idArbitro);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				arbitro.setIdArbitro(Integer.parseInt(res.getString("idArbitro")));
				arbitro.setNombre(res.getString("nombre"));
				arbitro.setApellidos(res.getString("apellidos"));
				arbitro.setFechanac(res.getString("fechanac"));
				arbitro.setDni(res.getString("dni"));
				arbitro.setLicencia(Integer.parseInt(res.getString("licencia")));
				arbitro.setEmail(res.getString("email"));
				arbitro.setContrasena(res.getString("contrasena"));
			 }
			res.close();
			conex.desconectar();
					
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return arbitro;
			}
			else return null;	
	} 

	public ArrayList<ArbitroVo> buscarArbitros() {
				ArrayList<ArbitroVo> arbitros = new ArrayList<>();
				Conexion conexion = new Conexion();
				try {
					PreparedStatement consulta = conexion.getConnection().prepareStatement("SELECT * FROM arbitro");
					ResultSet respuesta = consulta.executeQuery();
					while(respuesta.next()) {
						arbitros.add(new ArbitroVo(Integer.parseInt(respuesta.getString(1)),
								respuesta.getString(2),
								respuesta.getString(3),
								respuesta.getString(4),
								respuesta.getString(5),
								Integer.parseInt(respuesta.getString(6)),
								respuesta.getString(7),
								respuesta.getString(8)
								));
					}
					respuesta.close();
					conexion.desconectar();
				} catch(Exception e) {
					e.getStackTrace();
					System.out.println(e.getMessage());
				}

				return arbitros;
	}



}
