package vista;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import controlador.Coordinador;
import controlador.CrearJugadorControlador;
import modelo.vo.EquipoVo;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.EmptyBorder;

public class VentanaCrearJugador extends JFrame implements ActionListener{
	
	private JTextField nombreTf;
	private JTextField apellidosTf;
	private JTextField dniTf;
	private JTextField dorsalTf;
	private JTextField usuarioTf;
	private JPasswordField contrasenaTf;
	private JCheckBox capitanCb;
	private Coordinador coordinador;
	private JButton crearJugadorBtn;
	private JComboBox equipoCb;
	CrearJugadorControlador crearJugadorControlador;

	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private JTextField fechaNacTf;
	
	public VentanaCrearJugador() {
		crearJugadorControlador = new CrearJugadorControlador();
		
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(420,660);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel nombreLb = new JLabel("Nombre:");
		nombreLb.setBounds(58, 106, 200, 61);
		getContentPane().add(nombreLb);
		
		nombreTf = new JTextField();
		nombreTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		nombreTf.setBounds(180, 121, 200, 30);
		getContentPane().add(nombreTf);
		nombreTf.setColumns(10);
		
		JLabel apellidosLb = new JLabel("Apellidos:");
		apellidosLb.setBounds(58, 153, 200, 61);
		getContentPane().add(apellidosLb);
		
		apellidosTf = new JTextField();
		apellidosTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		apellidosTf.setBounds(180, 168, 200, 30);
		getContentPane().add(apellidosTf);
		apellidosTf.setColumns(10);
		
		JLabel dniLb = new JLabel("DNI:");
		dniLb.setBounds(58, 200, 200, 61);
		getContentPane().add(dniLb);
		
		dniTf = new JTextField();
		dniTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		dniTf.setBounds(180, 215, 200, 30);
		getContentPane().add(dniTf);
		dniTf.setColumns(10);
		
		JLabel dorsalLb = new JLabel("Dorsal:");
		dorsalLb.setBounds(56, 302, 200, 61);
		getContentPane().add(dorsalLb);
		
		dorsalTf = new JTextField();
		dorsalTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		dorsalTf.setBounds(180, 315, 200, 30);
		getContentPane().add(dorsalTf);
		dorsalTf.setColumns(10);
		
		JLabel capitanLb = new JLabel("Capit\u00E1n:");
		capitanLb.setBounds(55, 355, 110, 61);
		getContentPane().add(capitanLb);
		
		EquipoVo[] equipos = crearJugadorControlador.listarEquipos();
		equipoCb = new JComboBox(equipos);
		equipoCb.setLocation(173, 516);
		equipoCb.setSize(213, 40);
		getContentPane().add(equipoCb);
		

		capitanCb = new JCheckBox("SI");
		capitanCb.setBackground(new Color(135, 206, 235));
		capitanCb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		capitanCb.setBounds(177, 367, 55, 38);
		capitanCb.addActionListener(this);
		getContentPane().add(capitanCb);
		
		JLabel usuariolb = new JLabel("Usuario:");
		usuariolb.setBounds(56, 408, 200, 61);
		getContentPane().add(usuariolb);
		
		usuarioTf = new JTextField();
		usuarioTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		usuarioTf.setBounds(178, 423, 200, 30);
		usuarioTf.setEditable(false);
		getContentPane().add(usuarioTf);
		usuarioTf.setColumns(10);
		
		JLabel contrasenaLb = new JLabel("Contrase\u00F1a:");
		contrasenaLb.setBounds(56, 457, 200, 61);
		getContentPane().add(contrasenaLb);
		
		contrasenaTf = new JPasswordField();
		contrasenaTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		contrasenaTf.setBounds(180, 472, 200, 30);
		contrasenaTf.setEditable(false);
		getContentPane().add(contrasenaTf);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(149, 19, 109, 48);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblNewLabel = new JLabel("Introduzca los Datos del Jugador");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel.setBounds(96, 79, 274, 16);
		getContentPane().add(lblNewLabel);
		
		crearJugadorBtn = new JButton("Crear Jugador");
		crearJugadorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearJugadorBtn.setBackground(new Color(255, 255, 255));
		crearJugadorBtn.setBounds(117, 579, 159, 38);
		crearJugadorBtn.addActionListener(this);
		getContentPane().add(crearJugadorBtn);
		
		JLabel fechaNacLb = new JLabel("Fecha Nacimiento:");
		fechaNacLb.setBounds(56, 249, 200, 61);
		getContentPane().add(fechaNacLb);
		
		fechaNacTf = new JTextField();
		
		//PlaceHolder
		fechaNacTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fechaNacTf.setForeground(new Color(0,0,0));
			}
		});
		fechaNacTf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(fechaNacTf.getText().equals("AAAA-MM-DD")) {
					fechaNacTf.setText("");
					fechaNacTf.setForeground(new Color(153,153,153));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(fechaNacTf.getText().equals("")) {
					fechaNacTf.setText("AAAA-MM-DD");
					fechaNacTf.setForeground(new Color(153,153,153));
				}
			}
		});
		fechaNacTf.setForeground(Color.LIGHT_GRAY);
		//------
		
		fechaNacTf.setText("AAAA-MM-DD");
		fechaNacTf.setColumns(10);
		fechaNacTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		fechaNacTf.setBounds(181, 263, 200, 30);
		getContentPane().add(fechaNacTf);
		
		JLabel lblequipo = new JLabel("Equipo:");
		lblequipo.setBounds(56, 529, 73, 14);
		getContentPane().add(lblequipo);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==capitanCb) {
			if(capitanCb.isSelected()) {
				usuarioTf.setEditable(true);
				contrasenaTf.setEditable(true);
			} else {
				usuarioTf.setEditable(false);
				contrasenaTf.setEditable(false);
				usuarioTf.setText("");
				contrasenaTf.setText("");
			}
			
		}
		if(e.getSource()==crearJugadorBtn) {
			String usuario;
			String contrasena;
			if(capitanCb.isSelected()) {
				usuario = usuarioTf.getText();
				contrasena = String.valueOf(contrasenaTf.getPassword());
			} else {
				usuario=null;
				contrasena=null;
			}
			EquipoVo equipo = (EquipoVo) equipoCb.getSelectedItem();
			crearJugadorControlador.crearJugador(nombreTf.getText(), apellidosTf.getText(), dniTf.getText(), dorsalTf.getText(), fechaNacTf.getText(), equipo.getIdEquipo(), capitanCb.isSelected(), usuario, contrasena);
		}

	}
	
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador=coordinador;
	}
}
