package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.Coordinador;
import controlador.LoginControlador;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaLogin extends JFrame implements ActionListener{

	private Coordinador coordinador;
	private LoginControlador lc;
	private JButton acceder;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private Image img_usuario = new ImageIcon(VentanaLogin.class.getResource("/resources/usuario.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
	private Image img_contrasena = new ImageIcon(VentanaLogin.class.getResource("/resources/contrasena.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField contrasena;

	public VentanaLogin() {
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 205), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel userText = new JPanel();
		userText.setBorder(new EmptyBorder(0, 0, 0, 0));
		userText.setBackground(new Color(255, 255, 255));
		userText.setBounds(126, 120, 234, 30);
		contentPane.add(userText);
		userText.setLayout(null);
		
		usuario = new JTextField();
		usuario.setBorder(null);
		usuario.setBounds(48, -1, 184, 30);
		userText.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsuario.setBounds(4, 0, 37, 30);
		userText.add(lblUsuario);
		lblUsuario.setIcon(new ImageIcon(img_usuario));
		
		JPanel passText = new JPanel();
		passText.setBorder(new EmptyBorder(0, 0, 0, 0));
		passText.setBackground(new Color(255, 255, 255));
		passText.setLayout(null);
		passText.setBounds(126, 162, 234, 30);
		contentPane.add(passText);
		
		contrasena = new JPasswordField();
		contrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					acceder.doClick();
				}
			}
		});
		contrasena.setBorder(null);
		contrasena.setBounds(47, 0, 187, 30);
		passText.add(contrasena);
		
		JLabel lblContrasena = new JLabel("");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 10));
		lblContrasena.setBounds(10, 0, 31, 30);
		passText.add(lblContrasena);
		lblContrasena.setIcon(new ImageIcon(img_contrasena));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(137, 23, 223, 85);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		acceder = new JButton("Acceder");
		acceder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		acceder.setBackground(new Color(255, 255, 255));
		acceder.setForeground(new Color(0, 0, 0));
		acceder.setBounds(185, 223, 117, 29);
		acceder.addActionListener(this);
		contentPane.add(acceder);
		
		setLocationRelativeTo(null);
		
		//---------------- Una vez que le das al botón --------------
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		lc = new LoginControlador();
		
		if(e.getSource()==acceder) {
			if(lc.loginAdmin(usuario.getText(), String.valueOf(contrasena.getPassword()))) {
				coordinador.mostrarVentanaAdministrador();
				coordinador.cerrarVentanaLogin();
			} else if (lc.loginArbitro(usuario.getText(), String.valueOf(contrasena.getPassword())) != null) {
				int idArbitro = lc.loginArbitro(usuario.getText(), String.valueOf(contrasena.getPassword()));
				VentanaArbitro ventanaArbitro = new VentanaArbitro(idArbitro);
				coordinador.cerrarVentanaLogin();
			} else if (lc.loginCapitan(usuario.getText(), String.valueOf(contrasena.getPassword())) != null) {
				int idJugador = lc.loginCapitan(usuario.getText(), String.valueOf(contrasena.getPassword()));
				VentanaCapitan ventanaCapitan = new VentanaCapitan(idJugador);
				coordinador.cerrarVentanaLogin();
			} else{
				JOptionPane.showMessageDialog(null, "Usuario y/o contraseña erróneos");
			}
		}
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
	
}
