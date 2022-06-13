package controlador;

import java.util.ArrayList;

import modelo.dao.EquipoDao;
import modelo.vo.EquipoVo;

public class ModificarEquipoControlador {

	private EquipoDao equipoDao;
	
	public ModificarEquipoControlador() {
		
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

	public void modificarEquipo(int idEquipo, String nombre, int puntos, int golesFav, int golesCon) {
		equipoDao = new EquipoDao();
		EquipoVo equipo = new EquipoVo(idEquipo, nombre, puntos, golesFav, golesCon);
		equipoDao.modificarEquipo(equipo);
	}
	
}
