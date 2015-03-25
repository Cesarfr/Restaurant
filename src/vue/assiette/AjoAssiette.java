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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue AjoAssiette
 */
public class AjoAssiette extends JFrame {

	private JPanel contentPane;
	private JLabel lblType;
	public JTextField txtDes;
	private JLabel lblPrix;
	public JTextField txtPrix;
	private JLabel lblIngred;
	public JTextField txtIngred;
	public JButton btnEnregistrer;
	public JButton btnSortir;
	private JLabel lblDescripcion;
	private JLabel lblTitle;
	public JComboBox<String> cmbType;
	private JLabel lblsp;
	private JLabel lblBase1;
	private JLabel lblBase2;
	private JLabel lblBase3;
	private JLabel lblNom;
	public JTextField txtAjoAssNom;
	public JComboBox<String> cmbSalSuc;
	public JLabel lblIDAssi;

	/**
	 * Create the frame.
	 */
	public AjoAssiette() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AjoAssiette.class.getResource("../../images/Food_Icon_32.png")));
		setResizable(false);
		setTitle("Ajouter Assiette");
		setBounds(100, 100, 872, 257);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("AJOUTER ASSIETTE");
		lblTitle.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(51, 11, 589, 31);
		contentPane.add(lblTitle);

		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setBounds(10, 53, 46, 14);
		contentPane.add(lblType);

		lblDescripcion = new JLabel("Description:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setBounds(341, 52, 78, 14);
		contentPane.add(lblDescripcion);

		txtDes = new JTextField();
		txtDes.setBounds(315, 73, 166, 20);
		contentPane.add(txtDes);
		txtDes.setColumns(10);

		lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setBounds(503, 52, 46, 14);
		contentPane.add(lblPrix);

		txtPrix = new JTextField();
		txtPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrix.setBounds(501, 73, 69, 20);
		contentPane.add(txtPrix);
		txtPrix.setColumns(10);

		lblIngred = new JLabel("Ingredients:");
		lblIngred.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngred.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngred.setBounds(598, 52, 86, 14);
		contentPane.add(lblIngred);

		txtIngred = new JTextField();
		txtIngred.setBounds(598, 74, 258, 20);
		contentPane.add(txtIngred);
		txtIngred.setColumns(10);

		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(new Color(152, 251, 152));
		btnEnregistrer.setBounds(291, 125, 100, 34);
		contentPane.add(btnEnregistrer);

		btnSortir = new JButton("Sortir");
		btnSortir.setBackground(new Color(255, 192, 203));
		btnSortir.setBounds(490, 125, 100, 34);
		contentPane.add(btnSortir);

		cmbType = new JComboBox<String>();
		cmbType.setModel(new DefaultComboBoxModel<String>(new String[] {"S\u00E9lectionnez un type", "Salade", "Entr\u00E9e", "Dessert"}));
		cmbType.setBounds(10, 74, 139, 20);
		contentPane.add(cmbType);

		lblsp = new JLabel("\u20AC");
		lblsp.setHorizontalAlignment(SwingConstants.CENTER);
		lblsp.setBounds(568, 76, 20, 14);
		contentPane.add(lblsp);

		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(AjoAssiette.class
				.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 182, 315, 24);
		contentPane.add(lblBase1);

		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(AjoAssiette.class
				.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(314, 182, 315, 24);
		contentPane.add(lblBase2);

		lblBase3 = new JLabel("");
		lblBase3.setIcon(new ImageIcon(AjoAssiette.class
				.getResource("../../images/BARRA.jpg")));
		lblBase3.setBounds(622, 182, 244, 24);
		contentPane.add(lblBase3);
		
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom.setBounds(199, 53, 46, 14);
		contentPane.add(lblNom);
		
		txtAjoAssNom = new JTextField();
		txtAjoAssNom.setBounds(170, 73, 123, 20);
		contentPane.add(txtAjoAssNom);
		txtAjoAssNom.setColumns(10);
		
		cmbSalSuc = new JComboBox<String>();
		cmbSalSuc.setVisible(false);
		cmbSalSuc.setBounds(96, 125, 125, 20);
		cmbSalSuc.setModel(new DefaultComboBoxModel<String>(new String[] {"S\u00E9lectionnez un type", "Sal\u00E9", "Sucr\u00E9"}));
		contentPane.add(cmbSalSuc);
		
		lblIDAssi = new JLabel("New label");
		lblIDAssi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDAssi.setBounds(10, 125, 46, 20);
		contentPane.add(lblIDAssi);
	}
}
