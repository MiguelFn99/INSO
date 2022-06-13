package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import controlador.ModificarJugadorControlador;
import modelo.vo.EquipoVo;
import modelo.vo.JugadorVo;

public class VentanaModificarJugador extends JFrame implements ActionListener {

	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private JLabel equipoLb1, jugadorLb, nombreLb, apellidosLb, dniLb, fechaNacLb, dorsalLb, capitanLb,
			golesLb, asistenciasLb, tarjAmaLb, tarjRojasLb, usuarioLb, contrasenaLb, equipoLb;
	private JTextField nombreTf, apellidosTf, dniTf, fechaNacTf, dorsalTf,
			golesTf, asistenciasTf, tarjAmaTf, tarjRojasTf, usuarioTf, contrasenaTf;
	private JCheckBox capitanCb;
	private JComboBox equipoCb1, jugadorCb, equipoCb;
	private JButton modificarJugadorBtn;
	private ModificarJugadorControlador controlador = new ModificarJugadorControlador();
	private Coordinador coordinador;
	private JLabel lblNewLabel;
	
	public VentanaModificarJugador() {
		
		//Ventana
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		//Logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(352, 4, 100, 100);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		//Seleccionar el equipo
		equipoLb1 = new JLabel("Seleccione Equipo: ");
		equipoLb1.setLocation(37, 151);
		equipoLb1.setSize(141, 16);
		getContentPane().add(equipoLb1);
		
		EquipoVo[] equipos = controlador.listaEquipos();
		equipoCb1 = new JComboBox(equipos);
		equipoCb1.setLocation(190, 149);
		equipoCb1.setSize(167, 27);
		equipoCb1.addActionListener(this);
		getContentPane().add(equipoCb1);
		
		//Seleccionar el jugador
		jugadorLb = new JLabel("Seleccione Jugador: ");
		jugadorLb.setLocation(37, 196);
		jugadorLb.setSize(141, 16);
		getContentPane().add(jugadorLb);
		
		JugadorVo[] jugadores = controlador.listaJugadores(); 
		jugadorCb = new JComboBox(jugadores);
		jugadorCb.setLocation(189, 192);
		jugadorCb.setSize(170, 27);
		jugadorCb.addActionListener(this);
		getContentPane().add(jugadorCb);
		
		//Nombre del jugador
		nombreLb = new JLabel("Nombre: ");
		nombreLb.setLocation(37, 242);
		nombreLb.setSize(58, 16);
		getContentPane().add(nombreLb);
		
		nombreTf = new JTextField();
		nombreTf.setLocation(194, 237);
		nombreTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		nombreTf.setSize(157, 27);
		getContentPane().add(nombreTf);
		
		//Apellidos del arbitro
		apellidosLb = new JLabel("Apellidos: ");
		apellidosLb.setLocation(37, 289);
		apellidosLb.setSize(116, 16);
		getContentPane().add(apellidosLb);
		
		apellidosTf = new JTextField();
		apellidosTf.setLocation(194, 284);
		apellidosTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		apellidosTf.setSize(157, 27);
		getContentPane().add(apellidosTf);
		
		//DNI del jugador
		dniLb = new JLabel("DNI: ");
		dniLb.setLocation(37, 341);
		dniLb.setSize(58, 16);
		getContentPane().add(dniLb);
		
		dniTf = new JTextField();
		dniTf.setLocation(194, 336);
		dniTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		dniTf.setSize(157, 27);
		getContentPane().add(dniTf);
		
		//Fecha del jugador
		fechaNacLb = new JLabel("Fecha Nacimiento: ");
		fechaNacLb.setLocation(37, 390);
		fechaNacLb.setSize(141, 16);
		getContentPane().add(fechaNacLb);
		
		fechaNacTf = new JTextField();
		fechaNacTf.setLocation(194, 385);
		fechaNacTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		fechaNacTf.setSize(157, 27);
		getContentPane().add(fechaNacTf);
		
		//Dorsal del jugador
		dorsalLb = new JLabel("Dorsal: ");
		dorsalLb.setLocation(434, 242);
		dorsalLb.setSize(58, 16);
		getContentPane().add(dorsalLb);
		
		dorsalTf = new JTextField();
		dorsalTf.setLocation(572, 238);
		dorsalTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		dorsalTf.setSize(157, 27);
		getContentPane().add(dorsalTf);
		
		//Capit�n
		capitanLb = new JLabel("Capitan: ");
		capitanLb.setLocation(433, 197);
		capitanLb.setSize(97, 16);
		getContentPane().add(capitanLb);
		
		capitanCb = new JCheckBox();
		capitanCb.setLocation(571, 196);
		capitanCb.setBorder(new EmptyBorder(0, 0, 0, 0));
		capitanCb.setBackground(new Color(135, 206, 235));
		capitanCb.setSize(43, 16);
		getContentPane().add(capitanCb);
		
		//Goles del jugador
		golesLb = new JLabel("Goles: ");
		golesLb.setLocation(435, 291);
		golesLb.setSize(58, 16);
		getContentPane().add(golesLb);
		
		golesTf = new JTextField();
		golesTf.setLocation(573, 285);
		golesTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		golesTf.setSize(157, 27);
		getContentPane().add(golesTf);
		
		//Asistencias del jugador
		asistenciasLb = new JLabel("Asistencias: ");
		asistenciasLb.setLocation(436, 343);
		asistenciasLb.setSize(99, 16);
		getContentPane().add(asistenciasLb);
		
		asistenciasTf = new JTextField();
		asistenciasTf.setLocation(573, 338);
		asistenciasTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		asistenciasTf.setSize(157, 27);
		getContentPane().add(asistenciasTf);
		
		//Tarjetas amarillas del jugador
		tarjAmaLb = new JLabel("Tarjetas Amarillas: ");
		tarjAmaLb.setLocation(434, 396);
		tarjAmaLb.setSize(127, 16);
		getContentPane().add(tarjAmaLb);
		
		tarjAmaTf = new JTextField();
		tarjAmaTf.setLocation(573, 391);
		tarjAmaTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		tarjAmaTf.setSize(157, 27);
		getContentPane().add(tarjAmaTf);
		
		//Tarjetas rojas del jugador
		tarjRojasLb = new JLabel("Tarjetas Rojas: ");
		tarjRojasLb.setLocation(434, 443);
		tarjRojasLb.setSize(127, 16);
		getContentPane().add(tarjRojasLb);
		
		tarjRojasTf = new JTextField();
		tarjRojasTf.setLocation(573, 438);
		tarjRojasTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		tarjRojasTf.setSize(157, 27);
		getContentPane().add(tarjRojasTf);
		
		//Usuario del jugador
		usuarioLb = new JLabel("Usuario: ");
		usuarioLb.setLocation(37, 437);
		usuarioLb.setSize(89, 16);
		getContentPane().add(usuarioLb);
		
		usuarioTf = new JTextField();
		usuarioTf.setLocation(194, 432);
		usuarioTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		usuarioTf.setSize(157, 27);
		getContentPane().add(usuarioTf);
		
		//Usuario del jugador
		contrasenaLb = new JLabel("Contraseña: ");
		contrasenaLb.setLocation(37, 489);
		contrasenaLb.setSize(116, 16);
		getContentPane().add(contrasenaLb);
		
		contrasenaTf = new JTextField();
		contrasenaTf.setLocation(194, 485);
		contrasenaTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		contrasenaTf.setSize(157, 27);
		getContentPane().add(contrasenaTf);
		
		//Seleccionar equipo para el jugador
		equipoLb = new JLabel("Equipo: ");
		equipoLb.setLocation(433, 152);
		equipoLb.setSize(58, 16);
		getContentPane().add(equipoLb);
		
		EquipoVo[] equipo = controlador.listaEquipos();
		equipoCb = new JComboBox(equipo);
		equipoCb.setLocation(563, 147);
		equipoCb.setSize(174, 27);
		equipoCb.addActionListener(this);
		getContentPane().add(equipoCb);
		
		//Bot�n de confirmaci�n
		modificarJugadorBtn = new JButton("Modificar Jugador");
		modificarJugadorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificarJugadorBtn.setBackground(Color.WHITE);
		modificarJugadorBtn.setLocation(499, 489);
		modificarJugadorBtn.setSize(157, 29);
		modificarJugadorBtn.addActionListener(this);
		getContentPane().add(modificarJugadorBtn);
		
		lblNewLabel = new JLabel("Seleccione los Datos del Jugador a Modificar");
		lblNewLabel.setBounds(263, 98, 325, 16);
		getContentPane().add(lblNewLabel);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == modificarJugadorBtn) {
			EquipoVo equipoSelec = (EquipoVo) equipoCb.getSelectedItem();
			JugadorVo jugadorSelec = (JugadorVo) jugadorCb.getSelectedItem();
			controlador.modificarJugador(jugadorSelec.getIdJugador(), nombreTf.getText(), apellidosTf.getText(),
					dniTf.getText(), Integer.parseInt(dorsalTf.getText()), fechaNacTf.getText(), 
					Integer.parseInt(golesTf.getText()), Integer.parseInt(asistenciasTf.getText()),
					Integer.parseInt(tarjAmaTf.getText()), Integer.parseInt(tarjRojasTf.getText()),
					equipoSelec.getIdEquipo(), capitanCb.isSelected(), 
					usuarioTf.getText(), contrasenaTf.getText());
			coordinador.cerrarVentanaModificarJugador();
		}
		
		if (e.getSource() == equipoCb1) {
			EquipoVo equiSelec = (EquipoVo) equipoCb1.getSelectedItem();
			JugadorVo[] jugadores = controlador.buscarJugadores(equiSelec.getIdEquipo());
			if (jugadorCb != null) {
				getContentPane().remove(jugadorCb);
			}
			jugadorCb = new JComboBox(jugadores);
			jugadorCb.setLocation(189, 192);
			jugadorCb.setSize(167, 27);
			jugadorCb.addActionListener(this);
			getContentPane().add(jugadorCb);
		}
		
		
	}
	
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

}