package vue.assiette;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vue.employe.AjoEmploye;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue MenuAssitte
 */
public class MenuAssiette extends JFrame {

	private JPanel contentPane;
	private JLabel lblBase1;
	private JLabel lblBase2;
	public JButton btnMAssNouveau;
	public JButton btnMAssModifier;
	public JButton btnMAssConsulter;
	public JButton btnMAssEffacer;
	public JButton btnMAssSalir;
	private JLabel lblMAss;


	/**
	 * Create the frame.
	 */
	public MenuAssiette() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuAssiette.class.getResource("../../images/Food_Icon_32.png")));
		setResizable(false);
		setTitle("Menu assiettes");
		setBounds(100, 100, 538, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(238, 232, 170));
		setContentPane(contentPane);
		
		btnMAssSalir = new JButton("Salir");
		btnMAssSalir.setBounds(423, 11, 89, 23);
		btnMAssSalir.setBackground(new Color(210, 180, 140));
		contentPane.setLayout(null);
		contentPane.add(btnMAssSalir);
		
		lblMAss = new JLabel("MENU ASSIETTES");
		lblMAss.setBounds(191, 206, 174, 20);
		lblMAss.setForeground(Color.BLACK);
		lblMAss.setFont(new Font("Rockwell", Font.BOLD, 16));
		contentPane.add(lblMAss);
		
		btnMAssConsulter = new JButton("Consulter");
		btnMAssConsulter.setBackground(new Color(255, 255, 153));
		btnMAssConsulter.setBounds(159, 317, 89, 34);
		contentPane.add(btnMAssConsulter);
		
		btnMAssEffacer = new JButton("Effacer");
		btnMAssEffacer.setBackground(new Color(255, 102, 102));
		btnMAssEffacer.setBounds(286, 317, 89, 34);
		contentPane.add(btnMAssEffacer);
		
		btnMAssNouveau = new JButton("Nouveau");
		btnMAssNouveau.setBackground(new Color(152, 251, 152));
		btnMAssNouveau.setBounds(39, 317, 89, 34);
		contentPane.add(btnMAssNouveau);
		
		btnMAssModifier = new JButton("Modifier");
		btnMAssModifier.setBackground(new Color(204, 204, 255));
		btnMAssModifier.setBounds(405, 317, 89, 34);
		contentPane.add(btnMAssModifier);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(MenuAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 381, 315, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(MenuAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(312, 381, 220, 24);
		contentPane.add(lblBase2);
	}
}