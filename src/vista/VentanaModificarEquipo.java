package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controlador.Coordinador;
import controlador.ModificarEquipoControlador;
import modelo.dao.EquipoDao;
import modelo.vo.EquipoVo;

public class VentanaModificarEquipo extends JFrame implements ActionListener {

	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	JComboBox<String> equipoCb;
	JLabel equipoLb, nombreLb, puntosLb, golesFavorLb, golesContraLb;
	JTextField nombreTf, puntosTf, golesFavorTf, golesContraTf;
	JFileChooser escudoFc;
	JButton modificarEquipoBtn, elegirEscudoBtn;
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "jpg");
	Blob imagenBlob;
	ModificarEquipoControlador controlador = new ModificarEquipoControlador();
	Coordinador coordinador;
	EquipoVo equipoVo;
	EquipoDao equipoDao;	
	
	public VentanaModificarEquipo() {
		
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(400,560);
		setLocationRelativeTo(null);
		setResizable(false);
		equipoDao = new EquipoDao();
		getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(154, 4, 100, 100);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		equipoLb = new JLabel("Seleccione Equipo: ");
		equipoLb.setLocation(38, 145);
		equipoLb.setSize(141, 16);
		getContentPane().add(equipoLb);
		
		EquipoVo[] equipos = controlador.listaEquipos();
		equipoCb = new JComboBox(equipos);
		equipoCb.setLocation(190, 141);
		equipoCb.setSize(168, 27);
		equipoCb.addActionListener(this);
		getContentPane().add(equipoCb);
		
		nombreLb = new JLabel("Nombre: ");
		nombreLb.setLocation(38, 196);
		nombreLb.setSize(58, 16);
		getContentPane().add(nombreLb);
		
		nombreTf = new JTextField();
		nombreTf.setLocation(195, 191);
		nombreTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		nombreTf.setSize(157, 27);
		getContentPane().add(nombreTf);
		
		elegirEscudoBtn = new JButton("Elegir escudo");
		elegirEscudoBtn.setBackground(new Color(255, 255, 255));
		elegirEscudoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		elegirEscudoBtn.addActionListener(this);
		elegirEscudoBtn.setBounds(189, 244, 168, 29);
		getContentPane().add(elegirEscudoBtn);
		getContentPane().add(elegirEscudoBtn);
		
		puntosLb = new JLabel("Puntos: ");
		puntosLb.setLocation(39, 303);
		puntosLb.setSize(51, 16);
		getContentPane().add(puntosLb);
		
		puntosTf = new JTextField();
		puntosTf.setLocation(197, 298);
		puntosTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		puntosTf.setSize(156, 27);
		getContentPane().add(puntosTf);
		
		golesFavorLb = new JLabel("Goles a favor: ");
		golesFavorLb.setLocation(39, 359);
		golesFavorLb.setSize(90, 16);
		getContentPane().add(golesFavorLb);
		
		golesFavorTf = new JTextField();
		golesFavorTf.setLocation(197, 354);
		golesFavorTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		golesFavorTf.setSize(155, 27);
		getContentPane().add(golesFavorTf);
		
		golesContraLb = new JLabel("Goles en Contra: ");
		golesContraLb.setLocation(38, 418);
		golesContraLb.setSize(157, 16);
		getContentPane().add(golesContraLb);
		
		golesContraTf = new JTextField();
		golesContraTf.setLocation(198, 411);
		golesContraTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		golesContraTf.setSize(154, 27);
		getContentPane().add(golesContraTf);
		
		modificarEquipoBtn = new JButton("Modificar Equipo");
		modificarEquipoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificarEquipoBtn.setBackground(Color.WHITE);
		modificarEquipoBtn.setLocation(109, 472);
		modificarEquipoBtn.setSize(157, 35);
		modificarEquipoBtn.addActionListener(this);
		getContentPane().add(modificarEquipoBtn);
		
		JLabel lblNewLabel = new JLabel("Introduzca los Valores del Equipo a Modificar");
		lblNewLabel.setBounds(55, 98, 326, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblEscudo = new JLabel("Escudo:");
		lblEscudo.setBounds(38, 249, 61, 16);
		getContentPane().add(lblEscudo);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modificarEquipoBtn) {
			EquipoVo equipoSelec = (EquipoVo) equipoCb.getSelectedItem();
			controlador.modificarEquipo(equipoSelec.getIdEquipo(), nombreTf.getText(), Integer.parseInt(puntosTf.getText()), 
					Integer.parseInt(golesFavorTf.getText()), Integer.parseInt(golesContraTf.getText()));
			coordinador.cerrarVentanaModificarEquipo();
		}
		
		if (e.getSource() == equipoCb ) {
			EquipoVo equipoSelec = (EquipoVo) equipoCb.getSelectedItem();
			nombreTf.setText(equipoSelec.getNombre());
			puntosTf.setText(equipoSelec.getPuntos()+"");
			golesFavorTf.setText(equipoSelec.getGolesFav()+"");
			golesContraTf.setText(equipoSelec.getGolesContra()+"");
		}
	}
	
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
}
