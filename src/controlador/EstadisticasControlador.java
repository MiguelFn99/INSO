package controlador;

import java.util.ArrayList;

import modelo.dao.EquipoDao;
import modelo.dao.JugadorDao;
import modelo.vo.EquipoVo;
import modelo.vo.JugadorVo;

public class EstadisticasControlador {
	
	public ArrayList<JugadorVo> listarJugadores(){
		JugadorDao jugadorDao = new JugadorDao();
		ArrayList<JugadorVo> jugadores = jugadorDao.buscarJugadores();
		return jugadores;
	}
	
	public EquipoVo buscarEquipo(int idEquipo) {
		EquipoDao equipoDao = new EquipoDao();
		EquipoVo equipo = equipoDao.buscarEquipo(idEquipo);
		return equipo;
	}
}
