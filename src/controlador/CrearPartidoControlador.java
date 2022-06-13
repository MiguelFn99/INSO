package controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.dao.ArbitroDao;
import modelo.dao.EquipoDao;
import modelo.dao.PartidoDao;
import modelo.vo.ArbitroVo;
import modelo.vo.EquipoVo;
import modelo.vo.PartidoVo;

public class CrearPartidoControlador {

	PartidoVo partido;
	EquipoDao equipoDao;
	ArbitroDao arbitroDao;
	PartidoDao partidoDao;
	
	public CrearPartidoControlador() {
	}

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

	public void crearPartido(int idEquipoLocal, int idEquipoVis, int idArbitro, String fecha, String hora) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaD = formatter.parse(fecha);
			PartidoVo partido = new PartidoVo(0, idEquipoLocal, idEquipoVis, idArbitro, fecha, hora);
			partidoDao = new PartidoDao();
			partidoDao.crearPartido(partido);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error! El formato de la fecha es YYYY-MM-DD","Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
