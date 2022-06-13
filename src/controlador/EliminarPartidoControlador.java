package controlador;

import java.util.ArrayList;

import modelo.dao.PartidoDao;
import modelo.vo.PartidoVo;

public class EliminarPartidoControlador {
	PartidoDao partidoDao;
	
	public PartidoVo[] listaPartidos() {
		partidoDao = new PartidoDao();
		ArrayList<PartidoVo> partidos = partidoDao.buscarPartidos();
		PartidoVo[] listaPartidos = new PartidoVo[partidos.size()];
		
		for (int i = 0; i < partidos.size(); i++) {
			listaPartidos[i] = partidos.get(i);
		}

		return listaPartidos;
	}

	public void eliminarEquipo(int idPartido) {
		partidoDao.eliminarPartido(idPartido);
	}
}
