package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import controlador.ModificarArbitroControlador;
import modelo.dao.ArbitroDao;
import modelo.vo.ArbitroVo;

public class VentanaModificarArbitro extends JFrame implements ActionListener {

	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	JLabel arbitroLb;
	JComboBox<String> arbitroCb;
	JLabel nombreLb, apellidosLb, dniLb, fechaNacLb, licenciaLb, emailLb, contrasenaLb;
	JTextField nombreTf, apellidosTf, dniTf, fechaNacTf, licenciaTf, emailTf;
	JPasswordField contrasenaPf;
	JButton modificarArbitroBtn;
	ModificarArbitroControlador controlador = new ModificarArbitroControlador();
	Coordinador coordinador;
	ArbitroVo arbitroVo;
	ArbitroDao arbitroDao;
	private JLabel lblInfo;
	
	public VentanaModificarArbitro() {
		
		//Ventana
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(400,675);
		setLocationRelativeTo(null);
		setResizable(false);
		arbitroDao = new ArbitroDao();
		getContentPane().setLayout(null);
		
		//Logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(154, 4, 100, 100);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		//Seleccionar el arbitro
		arbitroLb = new JLabel("Seleccione un Arbitro: ");
		arbitroLb.setLocation(38, 145);
		arbitroLb.setSize(157, 16);
		getContentPane().add(arbitroLb);
		
		ArbitroVo[] arbitros = controlador.listaArbitros();
		arbitroCb = new JComboBox(arbitros);
		arbitroCb.setLocation(190, 141);
		arbitroCb.setSize(157, 27);
		arbitroCb.addActionListener(this);
		getContentPane().add(arbitroCb);
		
		//Nombre del arbitro
		nombreLb = new JLabel("Nombre: ");
		nombreLb.setLocation(38, 196);
		nombreLb.setSize(58, 16);
		getContentPane().add(nombreLb);
		
		nombreTf = new JTextField();
		nombreTf.setLocation(190, 191);
		nombreTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		nombreTf.setSize(157, 27);
		getContentPane().add(nombreTf);
		
		//Apellidos del arbitro
		apellidosLb = new JLabel("Apellidos: ");
		apellidosLb.setLocation(38, 260);
		apellidosLb.setSize(107, 16);
		getContentPane().add(apellidosLb);
		
		apellidosTf = new JTextField();
		apellidosTf.setLocation(190, 255);
		apellidosTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		apellidosTf.setSize(157, 27);
		getContentPane().add(apellidosTf);
		
		//DNI del árbitro
		dniLb = new JLabel("DNI: ");
		dniLb.setLocation(38, 320);
		dniLb.setSize(58, 16);
		getContentPane().add(dniLb);
		
		dniTf = new JTextField();
		dniTf.setLocation(190, 315);
		dniTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		dniTf.setSize(157, 27);
		getContentPane().add(dniTf);
		
		//Fecha del árbitro
		fechaNacLb = new JLabel("Fecha de Nacimiento: ");
		fechaNacLb.setLocation(38, 378);
		fechaNacLb.setSize(141, 16);
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
		//------
		
		fechaNacTf.setForeground(Color.LIGHT_GRAY);
		fechaNacTf.setText("AAAA-MM-DD");
		fechaNacTf.setLocation(190, 373);
		fechaNacTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		fechaNacTf.setSize(157, 27);
		getContentPane().add(fechaNacTf);
		
		//Licencia del arbitro
		licenciaLb = new JLabel("Licencia: ");
		licenciaLb.setLocation(38, 433);
		licenciaLb.setSize(107, 16);
		getContentPane().add(licenciaLb);
		
		licenciaTf = new JTextField();
		licenciaTf.setLocation(190, 428);
		licenciaTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		licenciaTf.setSize(157, 27);
		getContentPane().add(licenciaTf);
		
		//Email del arbitro
		emailLb = new JLabel("Email: ");
		emailLb.setLocation(38, 492);
		emailLb.setSize(58, 16);
		getContentPane().add(emailLb);
		
		emailTf = new JTextField();
		emailTf.setLocation(190, 487);
		emailTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		emailTf.setSize(157, 27);
		getContentPane().add(emailTf);
		
		//Contrasena del arbitro
		contrasenaLb = new JLabel("Contrase\u00F1a:");
		contrasenaLb.setLocation(38, 552);
		contrasenaLb.setSize(107, 16);
		getContentPane().add(contrasenaLb);
		
		contrasenaPf = new JPasswordField();
		contrasenaPf.setLocation(190, 547);
		contrasenaPf.setBorder(new EmptyBorder(0, 0, 0, 0));
		contrasenaPf.setSize(157, 27);
		getContentPane().add(contrasenaPf);
		
		//Botón de confirmación
		modificarArbitroBtn = new JButton("Modificar Arbitro");
		modificarArbitroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificarArbitroBtn.setBackground(Color.WHITE);
		modificarArbitroBtn.setLocation(112, 598);
		modificarArbitroBtn.setSize(157, 29);
		modificarArbitroBtn.addActionListener(this);
		getContentPane().add(modificarArbitroBtn);
		
		lblInfo = new JLabel("Introduzca los Valores del Arbitro a Modificar");
		lblInfo.setBounds(57, 95, 317, 16);
		getContentPane().add(lblInfo);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == modificarArbitroBtn) {
			ArbitroVo arbSel = (ArbitroVo) arbitroCb.getSelectedItem();
			controlador.modificarArbitro(arbSel.getIdArbitro(), nombreTf.getText(), apellidosTf.getText(),
					dniTf.getText(), fechaNacTf.getText(), Integer.parseInt(licenciaTf.getText()),
					emailTf.getText(), String.valueOf(contrasenaPf.getPassword()));
			coordinador.cerrarVentanaModificarArbitro();
		}
		
		if (e.getSource() == arbitroCb) {
			ArbitroVo arbiSelec = (ArbitroVo) arbitroCb.getSelectedItem();
			nombreTf.setText(arbiSelec.getNombre());
			apellidosTf.setText(arbiSelec.getApellidos());
			dniTf.setText(arbiSelec.getDni());
			fechaNacTf.setText(arbiSelec.getFechanac());
			licenciaTf.setText(arbiSelec.getLicencia()+"");
			emailTf.setText(arbiSelec.getEmail());
			contrasenaPf.setText(arbiSelec.getContrasena());
		}
		
	}
	
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	
}
