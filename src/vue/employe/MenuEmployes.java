package vue.employe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vue.assiette.MenuAssiette;
import javax.swing.SwingConstants;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue pour le menu des employees
 */
public class MenuEmployes extends JFrame {

	private JPanel contentPane;
	private JLabel lblBase1;
	private JLabel lblBase2;
	public JButton btnMEmpNouveau;
	public JButton btnMEmpModifier;
	public JButton btnMEmpConsulter;
	public JButton btnmEmpEffacer;
	public JButton btnMEmpSalir;
	private JLabel lblMEmp;
	private JLabel lblIcono;

	/**
	 * Create the frame.
	 */
	public MenuEmployes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuAssiette.class.getResource("../../images/FormatFactoryempleado.png")));
		setResizable(false);
		setTitle("Menu employ\u00E9s");
		setBounds(100, 100, 538, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(238, 232, 170));
		setContentPane(contentPane);
		
		btnMEmpSalir = new JButton("Sortir");
		btnMEmpSalir.setBounds(423, 11, 89, 23);
		btnMEmpSalir.setBackground(new Color(210, 180, 140));
		contentPane.setLayout(null);
		contentPane.add(btnMEmpSalir);
		
		lblMEmp = new JLabel("MENU EMPLOY\u00C9S");
		lblMEmp.setBounds(186, 234, 174, 20);
		lblMEmp.setForeground(Color.BLACK);
		lblMEmp.setFont(new Font("Rockwell", Font.BOLD, 16));
		contentPane.add(lblMEmp);
		
		btnMEmpConsulter = new JButton("Consulter");
		btnMEmpConsulter.setBackground(new Color(255, 255, 153));
		btnMEmpConsulter.setBounds(159, 317, 89, 34);
		contentPane.add(btnMEmpConsulter);
		
		btnmEmpEffacer = new JButton("Effacer");
		btnmEmpEffacer.setBackground(new Color(255, 102, 102));
		btnmEmpEffacer.setBounds(286, 317, 89, 34);
		contentPane.add(btnmEmpEffacer);
		
		btnMEmpNouveau = new JButton("Nouveau");
		btnMEmpNouveau.setBackground(new Color(152, 251, 152));
		btnMEmpNouveau.setBounds(39, 317, 89, 34);
		contentPane.add(btnMEmpNouveau);
		
		btnMEmpModifier = new JButton("Modifier");
		btnMEmpModifier.setBackground(new Color(204, 204, 255));
		btnMEmpModifier.setBounds(405, 317, 89, 34);
		contentPane.add(btnMEmpModifier);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(MenuAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 381, 315, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(MenuAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(312, 381, 220, 24);
		contentPane.add(lblBase2);
		
		lblIcono = new JLabel("");
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setIcon(new ImageIcon(MenuAssiette.class.getResource("../../images/FormatFactoryempleado.png")));
		lblIcono.setBounds(159, 90, 216, 133);
		contentPane.add(lblIcono);
	}

}
