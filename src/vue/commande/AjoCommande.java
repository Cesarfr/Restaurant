package vue.commande;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue AjoCom
 */
public class AjoCommande extends JFrame {

	private JPanel contentPane;
	public JTextField txtDComm;
	public JTextField txtDNPer;
	public JTextField txtDNLin;
	private JLabel lblDComm;
	private JLabel lblDNPer;
	private JLabel lblDNLin;
	private JLabel lblDNomAss;
	private JLabel lblDTAss;
	public JButton btnDAjouter;
	public JButton btnPerSuiv;
	public JComboBox<String> cmbDTipAss;
	public JTextField txtPrix;
	private JLabel lblDPrix;
	public JButton btnDCancelar;
	private JLabel label;
	public JComboBox <String>cmbDNomAss;
	private JLabel lblBase1;
	private JLabel lblBase2;

	/**
	 * Create the frame.
	 */
	public AjoCommande() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjoCommande.class.getResource("../../images/steak-32.png")));
		setResizable(false);
		setTitle("D\u00E9tail de commande");
		setBounds(100, 100, 455, 301);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDComm = new JLabel("Numero de commande:");
		lblDComm.setBounds(36, 11, 120, 14);
		contentPane.add(lblDComm);
		
		txtDComm = new JTextField();
		txtDComm.setEditable(false);
		txtDComm.setColumns(10);
		txtDComm.setBounds(50, 29, 86, 20);
		contentPane.add(txtDComm);
		
		lblDNPer = new JLabel("Nombre de personne:");
		lblDNPer.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNPer.setBounds(166, 11, 132, 14);
		contentPane.add(lblDNPer);
		
		txtDNPer = new JTextField();
		txtDNPer.setEditable(false);
		txtDNPer.setColumns(10);
		txtDNPer.setBounds(189, 29, 86, 20);
		contentPane.add(txtDNPer);
		
		lblDNLin = new JLabel("Nombre de ligne");
		lblDNLin.setBounds(320, 11, 145, 14);
		contentPane.add(lblDNLin);
		
		txtDNLin = new JTextField();
		txtDNLin.setEditable(false);
		txtDNLin.setColumns(10);
		txtDNLin.setBounds(318, 29, 86, 20);
		contentPane.add(txtDNLin);
		
		lblDTAss = new JLabel("Type d'Assiette:");
		lblDTAss.setHorizontalAlignment(SwingConstants.CENTER);
		lblDTAss.setBounds(10, 87, 146, 14);
		contentPane.add(lblDTAss);
		
		lblDNomAss = new JLabel("Nom assiette:");
		lblDNomAss.setBounds(166, 87, 134, 14);
		contentPane.add(lblDNomAss);
		
		lblDPrix = new JLabel("Prix:");
		lblDPrix.setBounds(368, 87, 57, 14);
		contentPane.add(lblDPrix);
		
		btnDAjouter = new JButton("Ajouter");
		btnDAjouter.setEnabled(false);
		btnDAjouter.setBackground(new Color(152, 251, 152));
		btnDAjouter.setBounds(36, 178, 89, 23);
		contentPane.add(btnDAjouter);
		
		btnPerSuiv = new JButton("Personne suivante");
		btnPerSuiv.setBackground(new Color(173, 255, 47));
		btnPerSuiv.setBounds(150, 178, 170, 23);
		contentPane.add(btnPerSuiv);
		
		cmbDTipAss = new JComboBox<String>();
		cmbDTipAss.setModel(new DefaultComboBoxModel<String>(new String[] {"S\u00E9lectionnez un type", "Salade", "Entree", "Dessert"}));
		cmbDTipAss.setBounds(24, 104, 132, 20);
		contentPane.add(cmbDTipAss);
		
		txtPrix = new JTextField();
		txtPrix.setEditable(false);
		txtPrix.setBounds(355, 104, 71, 20);
		contentPane.add(txtPrix);
		txtPrix.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 60, 447, 2);
		contentPane.add(separator);
		
		btnDCancelar = new JButton("Annuler");
		btnDCancelar.setBackground(new Color(255, 192, 203));
		btnDCancelar.setBounds(333, 178, 89, 23);
		contentPane.add(btnDCancelar);
		
		label = new JLabel("\u20AC");
		label.setBounds(427, 107, 20, 14);
		contentPane.add(label);
		
		cmbDNomAss = new JComboBox<String>();
		cmbDNomAss.setEnabled(false);
		cmbDNomAss.setBounds(168, 104, 181, 20);
		contentPane.add(cmbDNomAss);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(AjoCommande.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 231, 315, 41);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(AjoCommande.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(308, 231, 139, 41);
		contentPane.add(lblBase2);
	}
}

