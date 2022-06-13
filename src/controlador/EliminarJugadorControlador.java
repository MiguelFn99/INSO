package controlador;

import java.util.ArrayList;

import modelo.dao.EquipoDao;
import modelo.dao.JugadorDao;
import modelo.vo.EquipoVo;
import modelo.vo.JugadorVo;

public class EliminarJugadorControlador {

	private EquipoDao equipoDao;
	private JugadorDao jugadorDao;
	
	public EquipoVo[] listarEquipos() {
		equipoDao = new EquipoDao();
		ArrayList<EquipoVo> equipos = equipoDao.buscarEquipos();
		EquipoVo[] listaEquipos = new EquipoVo[equipos.size()];
		
		for(int i = 0; i < equipos.size(); i++) {
			listaEquipos[i] = equipos.get(i);
		}
		
		return listaEquipos;
	}

	public JugadorVo[] listarJugadoresEquipo(int idEquipo) {
		jugadorDao = new JugadorDao();
		ArrayList<JugadorVo> jugadores = jugadorDao.buscarJugadoresEquipo(idEquipo);
		JugadorVo[] listaJugadores = new JugadorVo[jugadores.size()];
		
		for(int i = 0; i < jugadores.size();i++) {
			listaJugadores[i] = jugadores.get(i);
		}
		
		return listaJugadores;
	}

	public void eliminarJugador(int idJugador) {
		jugadorDao.eliminarJugador(idJugador);
	}

}
