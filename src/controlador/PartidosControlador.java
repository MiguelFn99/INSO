package controlador;

import java.util.ArrayList;

import modelo.dao.ArbitroDao;
import modelo.dao.PartidoDao;
import modelo.vo.ArbitroVo;
import modelo.vo.PartidoVo;

public class PartidosControlador {

	public ArrayList<PartidoVo> listarPartidos() {
		PartidoDao partidoDao = new PartidoDao();
		ArrayList<PartidoVo> partidos = partidoDao.buscarPartidos();
		return partidos;
	}

	public ArbitroVo buscarArbitro(int idArbitro) {
		ArbitroDao arbitroDao = new ArbitroDao();
		ArbitroVo arbitro = arbitroDao.buscarArbitro(idArbitro);
		return arbitro;
	}

}
