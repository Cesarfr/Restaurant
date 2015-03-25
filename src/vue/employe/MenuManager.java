package vue.employe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import vue.assiette.MenuAssiette;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue pour le menu du manager
 */
public class MenuManager extends JFrame {

	private JPanel contentPane;
	public JButton btnMenManEmp;
	private JLabel lblMEN;
	public JButton btnMenManAss;
	private JLabel lblBase1;


	/**
	 * Create the frame.
	 */
	public MenuManager() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuAssiette.class.getResource("../../images/FormatFactoryempleado.png")));
		setResizable(false);
		setTitle("Menu manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMEN = new JLabel("M E N \u00DA      M A N A G E R");
		lblMEN.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblMEN.setBounds(66, 29, 221, 14);
		contentPane.add(lblMEN);
		
		btnMenManEmp = new JButton("   Employé");
		btnMenManEmp.setIcon(new ImageIcon(MenuManager.class.getResource("../../images/FormatFactoryempleado.png")));
		btnMenManEmp.setForeground(new Color(0, 0, 0));
		btnMenManEmp.setBackground(new Color(189, 183, 107));
		btnMenManEmp.setBounds(80, 85, 142, 49);
		contentPane.add(btnMenManEmp);
		
		btnMenManAss = new JButton("    Assiette");
		btnMenManAss.setIcon(new ImageIcon(MenuManager.class.getResource("../../images/Food_Icon_32.png")));
		btnMenManAss.setForeground(new Color(0, 0, 0));
		btnMenManAss.setBackground(new Color(189, 183, 107));
		btnMenManAss.setBounds(80, 169, 142, 49);
		contentPane.add(btnMenManAss);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(MenuManager.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 272, 315, 24);
		contentPane.add(lblBase1);
	}

}
