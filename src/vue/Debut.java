package vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue debut
 */
@SuppressWarnings("serial")
public class Debut extends JFrame {

	private JPanel contentPane;
	private JLabel lblTit;
	private JLabel lblElEmpleadoNo;
	public JTextField txtUser;
	public JPasswordField passPswd;
	private JLabel lblPass;
	private JLabel lblUser;
	public JComboBox<String> cmbEmployes;
	public JButton btnConnecter;
	int contador=0;
	private JLabel lblBase1;
	private JLabel lblBase2;

	/**
	 * Create the frame.
	 */
	public Debut() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Debut.class.getResource("../images/icon.png")));
		setResizable(false);
		setTitle("Restaurant d'Aix");
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setForeground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTit = new JLabel("BIENVENU");
		lblTit.setBounds(10, 11, 422, 26);
		lblTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTit.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblTit.setEnabled(true);
		contentPane.add(lblTit);
		
		cmbEmployes = new JComboBox<String>();
		cmbEmployes.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir votre emploi", "Serveur", "Caissier", "Cuisinier", "Manager"}));
		cmbEmployes.setBounds(125, 59, 205, 20);
		contentPane.add(cmbEmployes);
		
		btnConnecter = new JButton("Connecter");
		btnConnecter.setBackground(new Color(152, 251, 152));
		btnConnecter.setForeground(new Color(0, 0, 0));
		btnConnecter.setBounds(168, 219, 98, 36);
		contentPane.add(btnConnecter);
		
		lblElEmpleadoNo = new JLabel("");
		lblElEmpleadoNo.setForeground(Color.RED);
		lblElEmpleadoNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblElEmpleadoNo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblElEmpleadoNo.setBounds(67, 195, 306, 36);
		contentPane.add(lblElEmpleadoNo);
		
		txtUser = new JTextField();
		txtUser.setBounds(136, 110, 168, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		lblUser = new JLabel("Tapez votre nom d'utilisateur");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(125, 95, 194, 14);
		contentPane.add(lblUser);
		
		passPswd = new JPasswordField();
		passPswd.setBounds(148, 164, 145, 20);
		contentPane.add(passPswd);
		
		lblPass = new JLabel("Tapez votre password");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setBounds(136, 150, 168, 14);
		contentPane.add(lblPass);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(Debut.class.getResource("../images/BARRA.jpg")));
		lblBase1.setBounds(0, 291, 315, 55);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(Debut.class.getResource("../images/BARRA.jpg")));
		lblBase2.setBounds(316, 291, 135, 55);
		contentPane.add(lblBase2);
	}
}
