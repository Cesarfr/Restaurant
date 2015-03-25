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
 * Description : Vue Modi Assiette
 */
public class ModAssiette extends JFrame {

	private JPanel contentPane;
	public JTextField txtDNI;
	public JTextField txtMAssDesc;
	public JTextField txtMAssPrix;
	public JTextField txtDAssIngre;
	private JLabel lblID;
	private JLabel lblDescr;
	private JLabel lblIngred;
	public JButton btnMAssSearch;
	public JButton btnMAssModif;
	public JButton btnMAssSortir;
	public JComboBox<String> cmbMAssType;
	public JComboBox<String> cmbMAssNom;
	private JLabel lblBase1;
	private JLabel lblBase2;
	private JLabel lblPrix;
	private JLabel lblNom;
	public JTextField txtMAssNom;
	public JLabel lblType;
	public JComboBox<String> cmbTypeDess;


	/**
	 * Create the frame.
	 */
	public ModAssiette() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModAssiette.class.getResource("../../images/Food_Icon_32.png")));
		setResizable(false);
		setTitle("Modifier assiette");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(188, 120, 65, 20);
		txtDNI.setFont(new Font("Arial Black", Font.BOLD, 11));
		txtDNI.setForeground(new Color(25, 25, 112));
		txtDNI.setBackground(new Color(248, 248, 255));
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblID.setBounds(33, 124, 46, 14);
		lblID.setForeground(new Color(0, 0, 0));
		contentPane.add(lblID);
		
		btnMAssSortir = new JButton("Sortir");
		btnMAssSortir.setBackground(new Color(255, 192, 203));
		btnMAssSortir.setForeground(Color.BLACK);
		btnMAssSortir.setBounds(330, 300, 89, 33);
		contentPane.add(btnMAssSortir);
		
		txtMAssDesc = new JTextField();
		txtMAssDesc.setBounds(188, 174, 184, 20);
		txtMAssDesc.setForeground(new Color(25, 25, 112));
		txtMAssDesc.setBackground(new Color(248, 248, 255));
		contentPane.add(txtMAssDesc);
		txtMAssDesc.setColumns(10);
		
		txtMAssPrix = new JTextField();
		txtMAssPrix.setBounds(188, 236, 77, 20);
		txtMAssPrix.setForeground(new Color(25, 25, 112));
		txtMAssPrix.setBackground(new Color(248, 248, 255));
		contentPane.add(txtMAssPrix);
		txtMAssPrix.setColumns(10);
		
		txtDAssIngre = new JTextField();
		txtDAssIngre.setBounds(188, 205, 184, 20);
		txtDAssIngre.setForeground(new Color(25, 25, 112));
		txtDAssIngre.setBackground(new Color(248, 248, 255));
		contentPane.add(txtDAssIngre);
		txtDAssIngre.setColumns(10);
		
		lblDescr = new JLabel("Description");
		lblDescr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescr.setBounds(33, 177, 86, 14);
		lblDescr.setForeground(new Color(0, 0, 0));
		contentPane.add(lblDescr);
		
		lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrix.setBounds(33, 237, 77, 19);
		lblPrix.setForeground(new Color(0, 0, 0));
		contentPane.add(lblPrix);
		
				
		lblIngred = new JLabel("Ingredients");
		lblIngred.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngred.setBounds(33, 208, 98, 14);
		lblIngred.setForeground(new Color(0, 0, 0));
		contentPane.add(lblIngred);
		
		btnMAssModif = new JButton("Modifier");
		btnMAssModif.setBackground(new Color(127, 255, 212));
		btnMAssModif.setForeground(Color.BLACK);
		btnMAssModif.setBounds(124, 300, 89, 33);
		contentPane.add(btnMAssModif);
		
		JLabel lblTitle = new JLabel("M O D I F I E R    A S S I E T T E ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setBounds(117, 28, 342, 14);
		contentPane.add(lblTitle);
		 
		
		cmbMAssType = new JComboBox<String>();
		cmbMAssType.setModel(new DefaultComboBoxModel<String>(new String[] {"S\u00E9lectionnez un type", "Salade", "Entree", "Dessert"}));
		cmbMAssType.setBounds(33, 75, 139, 20);
		contentPane.add(cmbMAssType);
		
		btnMAssSearch = new JButton("Chercher Assiette");
		btnMAssSearch.setEnabled(false);
		btnMAssSearch.setBackground(new Color(144, 238, 144));
		btnMAssSearch.setBounds(384, 63, 145, 44);
		contentPane.add(btnMAssSearch);
		
		cmbMAssNom = new JComboBox<String>();
		cmbMAssNom.setEnabled(false);
		cmbMAssNom.setBounds(212, 75, 123, 20);
		contentPane.add(cmbMAssNom);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(ModAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 357, 315, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(ModAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(311, 357, 250, 24);
		contentPane.add(lblBase2);		
		
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom.setBounds(33, 149, 46, 14);
		contentPane.add(lblNom);
		
		txtMAssNom = new JTextField();
		txtMAssNom.setBounds(188, 146, 184, 20);
		contentPane.add(txtMAssNom);
		txtMAssNom.setColumns(10);
		
		lblType = new JLabel("Type Dessert");
		lblType.setVisible(false);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setBounds(26, 265, 93, 20);
		contentPane.add(lblType);
		
		cmbTypeDess = new JComboBox<String>();
		cmbTypeDess.setVisible(false);
		cmbTypeDess.setModel(new DefaultComboBoxModel<String>(new String[] {"S\u00E9lectionnez un type","Sal\u00E9", "Sucr\u00E9"}));
		cmbTypeDess.setBounds(188, 267, 147, 20);
		contentPane.add(cmbTypeDess);
	}
}
