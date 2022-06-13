package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.conexion.Conexion;
import modelo.vo.AdministradorVo;

public class AdministradorDao {
	public ArrayList<AdministradorVo> buscarAdministrador(){
		ArrayList<AdministradorVo> administradores = new ArrayList<>();
		Conexion conexion = new Conexion();
		
		try {
			PreparedStatement consulta = conexion.getConnection().prepareStatement("SELECT * FROM administrador");
			ResultSet respuesta = consulta.executeQuery();
			while(respuesta.next()) {
				administradores.add(new AdministradorVo(Integer.parseInt(respuesta.getString("idAdministrador")), respuesta.getString("usuario"), respuesta.getString("contrasena")));
			}
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		conexion.desconectar();
		return administradores;
	}
}
