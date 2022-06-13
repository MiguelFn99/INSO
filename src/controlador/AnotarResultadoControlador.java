package controlador;

import java.util.ArrayList;

import modelo.dao.EquipoDao;
import modelo.dao.JugadorDao;
import modelo.dao.PartidoDao;
import modelo.vo.EquipoVo;
import modelo.vo.JugadorVo;
import modelo.vo.PartidoVo;

public class AnotarResultadoControlador {
	
	private PartidoDao partidoDao;
	private JugadorDao jugadorDao;
	private EquipoDao equipoDao;
	private Coordinador coordinador;
	
	public PartidoVo[] listarPartidos(int idArbitro) {
		partidoDao = new PartidoDao();
		ArrayList<PartidoVo> partidos = partidoDao.buscarPartidos(idArbitro);
		PartidoVo[] listaPartidos = new PartidoVo[partidos.size()];
		
		for(int i = 0; i < partidos.size(); i++) {
			listaPartidos[i] = partidos.get(i);
		}
		return listaPartidos;
	}
	public ArrayList<JugadorVo> listarJugadoresEquipo(int idEquipo){
		jugadorDao = new JugadorDao();
		ArrayList<JugadorVo> listaJugadoresEquipo = jugadorDao.buscarJugadoresEquipo(idEquipo);
		return listaJugadoresEquipo;
	}
	public void anotarEstadisticas(JugadorVo jugador) {
		jugadorDao = new JugadorDao();
		jugadorDao.modificarJugador(jugador);
		
	}
	public void anotarResultado(PartidoVo partidoSelec) {
		// TODO Auto-generated method stub
		partidoDao = new PartidoDao();
		partidoDao.modificarPartido(partidoSelec);
		equipoDao = new EquipoDao();
		EquipoVo equipoLocal = equipoDao.buscarEquipo(partidoSelec.getIdEquipoLocal());
		EquipoVo equipoVisitante = equipoDao.buscarEquipo(partidoSelec.getIdEquipoVis());
		
		// CAMBIAR GOLES FAV Y CON
		
		equipoLocal.setGolesFav(equipoLocal.getGolesFav() + partidoSelec.getGolesLocal());
		equipoLocal.setGolesContra(equipoLocal.getGolesContra() + partidoSelec.getGolesVis());
		equipoVisitante.setGolesFav(equipoVisitante.getGolesFav() + partidoSelec.getGolesVis());
		equipoVisitante.setGolesContra(equipoVisitante.getGolesContra() + partidoSelec.getGolesLocal());
		
		// REPARTO DE PUNTOS
		
		if(partidoSelec.getGolesLocal()==partidoSelec.getGolesVis()) {
			equipoLocal.setPuntos(equipoLocal.getPuntos()+1);
			equipoVisitante.setPuntos(equipoVisitante.getPuntos()+1);
		} else if (partidoSelec.getGolesLocal()>partidoSelec.getGolesVis()) {
			equipoLocal.setPuntos(equipoLocal.getPuntos()+3);
		} else {
			equipoVisitante.setPuntos(equipoVisitante.getPuntos()+3);
		}
		
		// ACTUALIZACION DE EQUIPOS
		
		equipoDao.modificarEquipo(equipoLocal);
		equipoDao.modificarEquipo(equipoVisitante);
	}
}
