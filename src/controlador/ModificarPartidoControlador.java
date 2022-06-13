package controlador;

import java.util.ArrayList;

import modelo.dao.ArbitroDao;
import modelo.dao.EquipoDao;
import modelo.dao.PartidoDao;
import modelo.vo.ArbitroVo;
import modelo.vo.EquipoVo;
import modelo.vo.PartidoVo;

public class ModificarPartidoControlador {
	PartidoVo partido;
	EquipoDao equipoDao;
	ArbitroDao arbitroDao;
	PartidoDao partidoDao;
	
	public EquipoVo[] listarEquipos() {
		equipoDao = new EquipoDao();
		ArrayList<EquipoVo> equipos = equipoDao.buscarEquipos();
		EquipoVo[] listaEquipos = new EquipoVo[equipos.size()];
		
		for (int i = 0; i < equipos.size(); i++) {
			listaEquipos[i] = equipos.get(i);
		}

		return listaEquipos;
	}
	
	public ArbitroVo[] listarArbitros() {
		arbitroDao = new ArbitroDao();
		ArrayList<ArbitroVo> arbitros = arbitroDao.buscarArbitros();
		ArbitroVo[] listaArbitros = new ArbitroVo[arbitros.size()];
		
		for (int i = 0; i < arbitros.size(); i++) {
			listaArbitros[i] = arbitros.get(i);
		}

		return listaArbitros;
	}

	public PartidoVo[] listarPartidos() {
		partidoDao = new PartidoDao();
		ArrayList<PartidoVo> partidos = partidoDao.buscarPartidos();
		PartidoVo[] listaPartidos = new PartidoVo[partidos.size()];
		
		for(int i = 0; i < partidos.size(); i++) {
			listaPartidos[i] = partidos.get(i);
		}
		return listaPartidos;
	}

	public void modificarPartido(int idPartido, int idEquipoLocal, int idEquipoVisitante, int idArbitro, String fecha, String hora) {
		partidoDao = new PartidoDao();
		PartidoVo partido = new PartidoVo(idPartido, idEquipoLocal, idEquipoVisitante, idArbitro, fecha, hora, 0, 0, 0, 0);
		partidoDao.modificarPartido(partido);
	}

}
