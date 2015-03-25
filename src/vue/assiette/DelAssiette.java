package vue.assiette;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue Del Assiette
 */
public class DelAssiette extends JFrame {

	private JPanel contentPane;
	public JButton btnDelAssSortir;
	public JComboBox<String> cmbDelAssTipo;
	public JComboBox<String> cmbDelAssNom;
	private JLabel lblBase1;
	private JLabel lblBase2;
	private JLabel lblELI;
	public JButton btnDelAssEffacer;


	/**
	 * Create the frame.
	 */
	public DelAssiette() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DelAssiette.class.getResource("../../images/Food_Icon_32.png")));
		setResizable(false);	
		setBounds(100, 100, 402, 291);
		setTitle("Effacer assiette");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		btnDelAssSortir = new JButton("Sortir");
		btnDelAssSortir.setBackground(new Color(255, 192, 203));
		btnDelAssSortir.setForeground(new Color(0, 0, 0));
		btnDelAssSortir.setBounds(244, 164, 89, 40);
		contentPane.add(btnDelAssSortir);
		
		cmbDelAssTipo = new JComboBox<String>();
		cmbDelAssTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"S\u00E9lectionnez un type", "Salade", "Entree", "Dessert"}));
		cmbDelAssTipo.setBounds(10, 85, 140, 23);
		contentPane.add(cmbDelAssTipo);
		
		cmbDelAssNom = new JComboBox<String>();
		cmbDelAssNom.setEnabled(false);
		cmbDelAssNom.setBounds(181, 86, 202, 20);
		contentPane.add(cmbDelAssNom);
		
		btnDelAssEffacer = new JButton("Effacer");
		btnDelAssEffacer.setEnabled(false);
		btnDelAssEffacer.setBackground(new Color(143, 188, 143));
		btnDelAssEffacer.setBounds(85, 164, 89, 40);
		contentPane.add(btnDelAssEffacer);
		
		lblELI = new JLabel("EFFACER ASSIETTE");
		lblELI.setHorizontalAlignment(SwingConstants.CENTER);
		lblELI.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblELI.setBounds(99, 24, 212, 14);
		contentPane.add(lblELI);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(DelAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 227, 315, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(DelAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(224, 227, 191, 24);
		contentPane.add(lblBase2);
	
	}

}
