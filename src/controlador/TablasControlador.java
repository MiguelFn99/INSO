package controlador;

import java.util.ArrayList;

import modelo.dao.EquipoDao;
import modelo.vo.EquipoVo;

public class TablasControlador {
	
	private EquipoDao equipoDao;

	public ArrayList<EquipoVo> listarEquipos(){
		equipoDao = new EquipoDao();
		ArrayList<EquipoVo> listaEquipos = equipoDao.buscarEquipos();
		return listaEquipos;
	}

}
