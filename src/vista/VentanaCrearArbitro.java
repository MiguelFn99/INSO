package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.Coordinador;
import controlador.CrearArbitroControlador;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;

public class VentanaCrearArbitro extends JFrame implements ActionListener {

	private JLabel nombreLb, apellidosLb, dniLb, fechaNacLb, licenciaLb, emailLb, contrasenaLb;
	private JTextField nombreTf, apellidosTf, dniTf, fechaNacTf, licenciaTf, emailTf;
	private JPasswordField contrasenaPf;
	private JButton crearArbitroBtn;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage()
			.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private Coordinador coordinador;
	private JLabel lblNewLabel;
	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == crearArbitroBtn) {
			CrearArbitroControlador crearArbitroControlador = new CrearArbitroControlador();
			crearArbitroControlador.crearArbitro(nombreTf.getText(), apellidosTf.getText(), dniTf.getText(),
					fechaNacTf.getText(), Integer.parseInt(licenciaTf.getText()),
					emailTf.getText(), String.valueOf(contrasenaPf.getPassword()));
		}

	}

	public VentanaCrearArbitro() {

		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(400, 600);
		setLocationRelativeTo(null);
		setResizable(false);

		nombreLb = new JLabel("Nombre: ");
		nombreLb.setBounds(29, 146, 66, 30);
		nombreTf = new JTextField();
		nombreTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		nombreTf.setBounds(176, 146, 201, 30);
		getContentPane().setLayout(null);
		getContentPane().add(nombreLb);
		getContentPane().add(nombreTf);

		apellidosLb = new JLabel("Apellidos: ");
		apellidosLb.setBounds(29, 193, 94, 30);
		apellidosTf = new JTextField();
		apellidosTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		apellidosTf.setBounds(176, 193, 201, 30);
		getContentPane().add(apellidosLb);
		getContentPane().add(apellidosTf);

		dniLb = new JLabel("DNI: ");
		dniLb.setBounds(29, 245, 66, 30);
		dniTf = new JTextField();
		dniTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		dniTf.setBounds(176, 245, 201, 30);
		getContentPane().add(dniLb);
		getContentPane().add(dniTf);

		fechaNacLb = new JLabel("Fecha Nacimiento: ");
		fechaNacLb.setBounds(29, 297, 154, 30);
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
		//------
		
		fechaNacTf.setForeground(Color.LIGHT_GRAY);
		fechaNacTf.setText("AAAA-MM-DD");
		fechaNacTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		fechaNacTf.setBounds(177, 297, 200, 30);
		getContentPane().add(fechaNacLb);
		getContentPane().add(fechaNacTf);

		licenciaLb = new JLabel("Licencia: ");
		licenciaLb.setBounds(29, 349, 66, 30);
		licenciaTf = new JTextField();
		licenciaTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		licenciaTf.setBounds(176, 349, 201, 30);
		getContentPane().add(licenciaLb);
		getContentPane().add(licenciaTf);

		emailLb = new JLabel("Email: ");
		emailLb.setBounds(29, 400, 66, 30);
		emailTf = new JTextField();
		emailTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		emailTf.setBounds(176, 400, 201, 30);
		getContentPane().add(emailLb);
		getContentPane().add(emailTf);

		contrasenaLb = new JLabel("Contraseña: ");
		contrasenaLb.setBounds(29, 451, 94, 30);
		contrasenaPf = new JPasswordField();
		contrasenaPf.setBorder(new EmptyBorder(0, 0, 0, 0));
		contrasenaPf.setBounds(176, 451, 201, 30);
		getContentPane().add(contrasenaLb);
		getContentPane().add(contrasenaPf);

		crearArbitroBtn = new JButton("Crear Arbitro");
		crearArbitroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearArbitroBtn.setBackground(Color.WHITE);
		crearArbitroBtn.setBounds(114, 507, 144, 40);
		crearArbitroBtn.addActionListener(this);
		getContentPane().add(crearArbitroBtn);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(155, 25, 90, 50);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));

		lblNewLabel = new JLabel("Introduzca los Datos del Arbitro");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel.setBounds(101, 87, 282, 21);
		getContentPane().add(lblNewLabel);

	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
}
