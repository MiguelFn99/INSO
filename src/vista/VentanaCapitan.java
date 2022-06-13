package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controlador.EnviarMensajeControlador;

public class VentanaCapitan extends JFrame implements ActionListener {

	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private JLabel mensajeLb;
	private JTextArea mensajeTa;
	private JButton enviarBtn;
	private int idJugador;
	private EnviarMensajeControlador enviarMensajeControlador;
	
	public VentanaCapitan(int idJugador) {
		
		//Recoger el idJugador pasado por parámetros
		this.idJugador = idJugador;
		
		//
		enviarMensajeControlador = new EnviarMensajeControlador();
		
		//Ventana
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(500,400);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		//Logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(187, 0, 112, 100);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		//Texto
		mensajeLb = new JLabel("Escriba un mensaje al administrador: ");
		mensajeLb.setLocation(120, 91);
		mensajeLb.setSize(236, 43);
		getContentPane().add(mensajeLb);
		
		//Mensaje
		mensajeTa = new JTextArea();
		mensajeTa.setLocation(11, 138);
		mensajeTa.setSize(476, 144);
		mensajeTa.setLineWrap(true);
		getContentPane().add(mensajeTa);
		
		//Botón enviar
		enviarBtn = new JButton("Enviar mensaje");
		enviarBtn.setBounds(167, 302, 145, 37);
		enviarBtn.addActionListener(this);
		getContentPane().add(enviarBtn);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == enviarBtn) {
			enviarMensajeControlador.crearMensaje(idJugador, mensajeTa.getText());
			setVisible(false);
		}
	}

	
	
}