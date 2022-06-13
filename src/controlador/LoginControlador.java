package controlador;

import java.util.ArrayList;

import modelo.dao.AdministradorDao;
import modelo.dao.ArbitroDao;
import modelo.dao.JugadorDao;
import modelo.vo.AdministradorVo;
import modelo.vo.ArbitroVo;
import modelo.vo.JugadorVo;

public class LoginControlador {
	
	AdministradorDao administradorDao;
	ArbitroDao arbitroDao;
	JugadorDao jugadorDao;
	
	public boolean loginAdmin(String usuario, String contrasena) {
		administradorDao = new AdministradorDao();
		ArrayList<AdministradorVo> administradores = administradorDao.buscarAdministrador();
		AdministradorVo admin = new AdministradorVo(0, usuario, contrasena);
		
		for (int i=0;i<administradores.size();i++) {
			if (admin.getUsuario().equals(administradores.get(i).getUsuario()) && admin.getContrasena().equals(administradores.get(i).getContrasena())) {
				return true;
			}
		}
		return false;
	}

	public Integer loginArbitro(String usuario, String contrasena) {
		
		arbitroDao = new ArbitroDao();
		ArrayList<ArbitroVo> arbitros = arbitroDao.buscarArbitros();
		ArbitroVo arbitroVo = new ArbitroVo(0, usuario, contrasena);
		
		for (int i = 0; i < arbitros.size(); i++) {
			if (arbitroVo.getEmail().equals(arbitros.get(i).getEmail()) && arbitroVo.getContrasena().equals(arbitros.get(i).getContrasena())) {
				return arbitros.get(i).getIdArbitro();
			}
		}
		
		return null;
	}
	
	public Integer loginCapitan(String usuario, String contrasena) {
		
		jugadorDao = new JugadorDao();
		ArrayList<JugadorVo> jugadores = jugadorDao.buscarJugadores();
		JugadorVo jugadorVo = new JugadorVo(0, usuario, contrasena);
		
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadorVo.getEmail().equals(jugadores.get(i).getEmail()) && jugadorVo.getContrasena().equals(jugadores.get(i).getContrasena())) {
				return jugadores.get(i).getIdJugador();
			}
		}
		
		return null;
	}
	
}
