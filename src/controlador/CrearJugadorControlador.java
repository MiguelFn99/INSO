package controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.dao.EquipoDao;
import modelo.dao.JugadorDao;
import modelo.vo.EquipoVo;
import modelo.vo.JugadorVo;

public class CrearJugadorControlador {
	
	private JugadorVo jugador;
	private ArrayList<EquipoVo> equipos;
	private EquipoDao equipoDao;
	private JugadorDao jugadorDao;

	public CrearJugadorControlador(String nombre, String apellidos, String dni, String dorsal, String fechanac) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaNacimiento = formatter.parse(fechanac);
			jugador = new JugadorVo(0, nombre, apellidos, dni, Integer.parseInt(dorsal), fechanac, 0, 0, 0, 0, 0, false, null ,null);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public CrearJugadorControlador(String nombre, String apellidos, String dni, String dorsal, boolean capitan, String usuario,
			String contrasena) {
		
	}
	
	public CrearJugadorControlador() {

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

	public void crearJugador(String nombre, String apellidos, String dni, String dorsal, String fechaNac, int idEquipo ,boolean capitan,
			String usuario, String contrasena) {
		try {
			jugadorDao = new JugadorDao();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaNacimiento = formatter.parse(fechaNac);
			int dorsalInt = Integer.parseInt(dorsal);
			JugadorVo jugador = new JugadorVo(0, nombre, apellidos, dni, dorsalInt, fechaNac, 0, 0, 0, 0, idEquipo, capitan, usuario, contrasena);
			jugadorDao.crearJugador(jugador);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error! El formato del dorsal debe ser un numérico de 2 cifras máximo, y la fecha yyyy-MM-dd");
			e.printStackTrace();
		}
	}

}
