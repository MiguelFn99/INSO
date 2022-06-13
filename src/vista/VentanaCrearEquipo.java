package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Coordinador;
import controlador.CrearEquipoControlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.border.EmptyBorder;

public class VentanaCrearEquipo extends JFrame implements ActionListener {

	private JLabel nombreLb;
	private Coordinador coordinador;
	private JTextField nombreTf;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private JButton crearEquipoBtn;
	private JLabel lblInfo;
	private CrearEquipoControlador crearEquipoControlador = new CrearEquipoControlador();

	public VentanaCrearEquipo() {
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		setSize(400,350);
		setLocationRelativeTo(null);
		setResizable(false);
		
		nombreLb = new JLabel("Nombre: ");
		nombreLb.setLocation(31, 159);
		nombreLb.setSize(66, 30);
		nombreTf = new JTextField();
		nombreTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		nombreTf.setLocation(107, 159);
		nombreTf.setSize(201, 30);
		getContentPane().add(nombreLb);
		getContentPane().add(nombreTf);
		
		crearEquipoBtn = new JButton("Crear Equipo");
		crearEquipoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearEquipoBtn.setBackground(new Color(255, 255, 255));
		crearEquipoBtn.setLocation(121, 236);
		crearEquipoBtn.setSize(159, 40);
		crearEquipoBtn.addActionListener(this);
		getContentPane().add(crearEquipoBtn);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(107, 6, 201, 87);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		lblInfo = new JLabel("Seleccione el Nombre del Equipo");
		lblInfo.setBounds(95, 105, 275, 23);
		getContentPane().add(lblInfo);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==crearEquipoBtn) {
			crearEquipoControlador.crearEquipo(nombreTf.getText());
			coordinador.cerrarVentanaCrearEquipo();
		}

	}

	public void setCoordinador(Coordinador coordinador) {
		// TODO Auto-generated method stub
		this.coordinador = coordinador;
	}
	
}