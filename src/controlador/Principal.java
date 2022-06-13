package controlador;

import vista.VentanaAdministrador;
import vista.VentanaCrearArbitro;
import vista.VentanaCrearEquipo;
import vista.VentanaCrearPartido;
import vista.VentanaEliminarEquipo;
import vista.VentanaEliminarJugador;
import vista.VentanaEliminarPartido;
import vista.VentanaEstadisticas;
import vista.VentanaEliminarArbitro;
import vista.VentanaCrearJugador;
import vista.VentanaLogin;
import vista.VentanaMensajes;
import vista.VentanaModificarArbitro;
import vista.VentanaModificarEquipo;
import vista.VentanaModificarJugador;
import vista.VentanaModificarPartido;
import vista.VentanaPartidos;
import vista.VentanaTablas;

public class Principal {
	
	private Coordinador coordinador;
	private VentanaTablas ventanaTablas;
	private VentanaLogin ventanaLogin;
	private VentanaAdministrador ventanaAdministrador;
	private VentanaCrearEquipo ventanaCrearEquipo;
	private VentanaCrearPartido ventanaCrearPartido;
	private VentanaCrearJugador ventanaCrearJugador;
	private VentanaCrearArbitro ventanaCrearArbitro;
	private VentanaModificarEquipo ventanaModificarEquipo;
	private VentanaModificarPartido ventanaModificarPartido;
	private VentanaEliminarEquipo ventanaEliminarEquipo;
	private VentanaModificarArbitro ventanaModificarArbitro;
	private VentanaEliminarArbitro ventanaEliminarArbitro;
	private VentanaEliminarPartido ventanaEliminarPartido;
	private VentanaEliminarJugador ventanaEliminarJugador;
	private VentanaModificarJugador ventanaModificarJugador;
	private VentanaEstadisticas ventanaEstadisticas;
	private VentanaPartidos ventanaPartidos;
	private VentanaMensajes ventanaMensajes;
	
	public static void main (String[] args) {
		Principal principal = new Principal();
		principal.iniciar();
	}
	
	public void iniciar() {
		
		coordinador = new Coordinador();
		
		ventanaTablas = new VentanaTablas();
		ventanaTablas.setCoordinador(coordinador);
		coordinador.setVentanaTablas(ventanaTablas);
		
		ventanaLogin = new VentanaLogin();
		ventanaLogin.setCoordinador(coordinador);
		coordinador.setVentanaLogin(ventanaLogin);
		
		ventanaAdministrador = new VentanaAdministrador();
		ventanaAdministrador.setCoordinador(coordinador);
		coordinador.setVentanaAdministrador(ventanaAdministrador);
		
		ventanaCrearEquipo = new VentanaCrearEquipo();
		ventanaCrearEquipo.setCoordinador(coordinador);
		coordinador.setVentanaCrearEquipo(ventanaCrearEquipo);

		ventanaCrearPartido = new VentanaCrearPartido();
		ventanaCrearPartido.setCoordinador(coordinador);
		coordinador.setVentanaCrearPartido(ventanaCrearPartido);
		
		ventanaCrearJugador = new VentanaCrearJugador();
		ventanaCrearJugador.setCoordinador(coordinador);
		coordinador.setVentanaCrearJugador(ventanaCrearJugador);
		
		ventanaCrearArbitro = new VentanaCrearArbitro();
		ventanaCrearArbitro.setCoordinador(coordinador);
		coordinador.setVentanaCrearArbitro(ventanaCrearArbitro);
		
		ventanaModificarEquipo = new VentanaModificarEquipo();
		ventanaModificarEquipo.setCoordinador(coordinador);
		coordinador.setVentanaModificarEquipo(ventanaModificarEquipo);

		ventanaModificarPartido = new VentanaModificarPartido();
		ventanaModificarPartido.setCoordinador(coordinador);
		coordinador.setVentanaModificarPartido(ventanaModificarPartido);
		
		ventanaModificarJugador = new VentanaModificarJugador();
		ventanaModificarJugador.setCoordinador(coordinador);
		coordinador.setVentanaModificarJugador(ventanaModificarJugador);
		
		ventanaModificarArbitro = new VentanaModificarArbitro();
		ventanaModificarArbitro.setCoordinador(coordinador);
		coordinador.setVentanaModificarArbitro(ventanaModificarArbitro);
		
		ventanaEliminarArbitro = new VentanaEliminarArbitro();
		ventanaEliminarArbitro.setCoordinador(coordinador);
		coordinador.setVentanaEliminarArbitro(ventanaEliminarArbitro);
		
		ventanaEliminarPartido = new VentanaEliminarPartido();
		ventanaEliminarPartido.setCoordinador(coordinador);
		coordinador.setVentanaEliminarPartido(ventanaEliminarPartido);
		
		ventanaEliminarJugador = new VentanaEliminarJugador();
		ventanaEliminarJugador.setCoordinador(coordinador);
		coordinador.setVentanaEliminarJugador(ventanaEliminarJugador);
		
		ventanaEliminarEquipo = new VentanaEliminarEquipo();
		ventanaEliminarEquipo.setCoordinador(coordinador);
		coordinador.setVentanaEliminarEquipo(ventanaEliminarEquipo);
		
		ventanaEstadisticas = new VentanaEstadisticas();
		ventanaEstadisticas.setCoordinador(coordinador);
		coordinador.setVentanaEstadisticas(ventanaEstadisticas);
		
		ventanaPartidos = new VentanaPartidos();
		ventanaPartidos.setCoordinador(coordinador);
		coordinador.setVentanaPartidos(ventanaPartidos);
		
		ventanaMensajes = new VentanaMensajes();
		ventanaMensajes.setCoordinador(coordinador);
		coordinador.setVentanaMensajes(ventanaMensajes);
		
		ventanaTablas.setVisible(true);
	}
	
}
