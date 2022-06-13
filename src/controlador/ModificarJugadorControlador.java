package controlador;

import java.util.ArrayList;

import modelo.dao.EquipoDao;
import modelo.dao.JugadorDao;
import modelo.vo.EquipoVo;
import modelo.vo.JugadorVo;

public class ModificarJugadorControlador {
	
	private JugadorDao jugadorDao;
	private EquipoDao equipoDao;
	
	public JugadorVo[] listaJugadores() {
		jugadorDao = new JugadorDao();
		ArrayList<JugadorVo> jugadores = jugadorDao.buscarJugadores();
		JugadorVo[] listaJugadores = new JugadorVo[jugadores.size()];
		
		for (int i = 0; i < jugadores.size(); i++) {
			listaJugadores[i] = jugadores.get(i);
		}

		return listaJugadores;
	}
	
	public EquipoVo[] listaEquipos() {
		equipoDao = new EquipoDao();
		ArrayList<EquipoVo> equipos = equipoDao.buscarEquipos();
		EquipoVo[] listaEquipos = new EquipoVo[equipos.size()];
		
		for (int i = 0; i < equipos.size(); i++) {
			listaEquipos[i] = equipos.get(i);
		}

		return listaEquipos;
	}
	
	public void modificarJugador(int idJugador, String nombre, String apellidos, String dni, int dorsal, String fechanac, int goles,
			int asistencias, int tarjAma, int tarjRojas, int idEquipo, boolean capitan, String email,
			String contrasena) {
		jugadorDao = new JugadorDao();
		JugadorVo jugador = new JugadorVo(idJugador, nombre, apellidos, dni, dorsal, fechanac, goles,
				asistencias, tarjAma, tarjRojas, idEquipo, capitan, email, contrasena);
		jugadorDao.modificarJugador(jugador);
		
	}

	public JugadorVo[] buscarJugadores(int idEquipo) {
		jugadorDao = new JugadorDao();
		ArrayList<JugadorVo> jugadores = jugadorDao.buscarJugadoresEquipo(idEquipo);
		JugadorVo[] listaJugadores = new JugadorVo[jugadores.size()];
		
		for (int i = 0; i < jugadores.size(); i++) {
			listaJugadores[i] = jugadores.get(i);
		}
		
		return listaJugadores;
		
	}
	
	

}