package vue.commande;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue paiementgroup
 */
public class PaiementGroup extends JFrame {

	private JPanel contentPane;
	private JLabel lblIndividual;
	private JLabel lblNoOrden;
	private JLabel lblComensal;
	public JScrollPane scrollTablaG;
	public JTable tabAssiG;
	public JTextField txtTotalG;
	private JLabel lblTotalAPagar;
	public DefaultTableModel dtm;
	private JLabel lblIngresaElMonto;
	public JTextField txtNoCommG;
	public JTextField txtNoPersG;
	public JTextField txtMontoG;
	public JTextField txtMonnG;
	private JLabel lblElCambioEs;
	public JButton btnPayerG;
	public JButton btnAnnulerG;
	public JButton btnMonnaieG;
	private JLabel label;
	private JLabel lbleuro;
	private JLabel lblBase1;
	private JLabel lblBase2;
	public JLabel lblLblemplo;


	/**
	 * Create the frame.
	 */
	public PaiementGroup() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaiementIndiv.class.getResource("../../images/Money_Bag_32.png")));
		setResizable(false);
		setTitle("Paiement par Table");
		setBounds(100, 100, 606, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIndividual = new JLabel("PAIEMENT PAR TABLE");
		lblIndividual.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndividual.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblIndividual.setBounds(146, 14, 327, 34);
		contentPane.add(lblIndividual);
		
		lblNoOrden = new JLabel("No. comm:");
		lblNoOrden.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoOrden.setBounds(31, 59, 68, 14);
		contentPane.add(lblNoOrden);
		
		lblComensal = new JLabel("Personne:");
		lblComensal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComensal.setHorizontalAlignment(SwingConstants.CENTER);
		lblComensal.setBounds(191, 59, 86, 14);
		contentPane.add(lblComensal);
		
		scrollTablaG = new JScrollPane();
		scrollTablaG.setBounds(31, 84, 530, 116);
		contentPane.add(scrollTablaG);
		
		String[] columnNames = {"No. Personne","No. Ligne","Assiette","Prix"};
		dtm= new DefaultTableModel(null, columnNames);
		tabAssiG = new JTable(dtm);
		tabAssiG.setBounds(31, 176, 129, 43);
		scrollTablaG.setViewportView(tabAssiG);
		
		txtTotalG = new JTextField();
		txtTotalG.setEditable(false);
		txtTotalG.setBounds(431, 199, 86, 20);
		contentPane.add(txtTotalG);
		txtTotalG.setColumns(10);
		
		lblTotalAPagar = new JLabel("Total:");
		lblTotalAPagar.setBounds(352, 203, 110, 14);
		contentPane.add(lblTotalAPagar);
		
		lblIngresaElMonto = new JLabel("Saisissez le montant du paiement:");
		lblIngresaElMonto.setBounds(31, 214, 246, 14);
		contentPane.add(lblIngresaElMonto);
		
		txtNoCommG = new JTextField();
		txtNoCommG.setEditable(false);
		txtNoCommG.setBounds(109, 56, 44, 20);
		contentPane.add(txtNoCommG);
		txtNoCommG.setColumns(10);
		
		txtNoPersG = new JTextField();
		txtNoPersG.setEditable(false);
		txtNoPersG.setBounds(279, 56, 44, 20);
		contentPane.add(txtNoPersG);
		txtNoPersG.setColumns(10);
		
		txtMontoG = new JTextField();
		txtMontoG.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMontoG.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtMontoG.setBounds(31, 236, 55, 20);
		contentPane.add(txtMontoG);
		txtMontoG.setColumns(10);
		
		txtMonnG = new JTextField();
		txtMonnG.setEditable(false);
		txtMonnG.setBounds(146, 278, 114, 20);
		contentPane.add(txtMonnG);
		txtMonnG.setColumns(10);
		
		lblElCambioEs = new JLabel("Le monnaie est:");
		lblElCambioEs.setBounds(31, 280, 122, 14);
		contentPane.add(lblElCambioEs);
		
		btnPayerG = new JButton("Payer"); // cambia de comensal
		btnPayerG.setBackground(new Color(152, 251, 152));
		btnPayerG.setEnabled(false);
		btnPayerG.setBounds(129, 327, 148, 32);
		contentPane.add(btnPayerG);
		
		btnAnnulerG = new JButton("Annuler");// cansela la operacion
		btnAnnulerG.setBackground(new Color(255, 192, 203));
		btnAnnulerG.setBounds(325, 327, 148, 32);
		contentPane.add(btnAnnulerG);
		
		btnMonnaieG = new JButton("Monnaie");
		btnMonnaieG.setBackground(new Color(245, 222, 179));
		btnMonnaieG.setBounds(127, 235, 105, 23);
		contentPane.add(btnMonnaieG);
		
		label = new JLabel("\u20AC");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(90, 237, 19, 14);
		contentPane.add(label);
		
		lbleuro = new JLabel("\u20AC");
		lbleuro.setHorizontalAlignment(SwingConstants.RIGHT);
		lbleuro.setBounds(258, 280, 19, 14);
		contentPane.add(lbleuro);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(PaiementIndiv.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 393, 315, 47);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(PaiementIndiv.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(314, 393, 286, 47);
		contentPane.add(lblBase2);
		
		JLabel label_5 = new JLabel("\u20AC");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(523, 201, 19, 14);
		contentPane.add(label_5);
		
		lblLblemplo = new JLabel("n");
		lblLblemplo.setBounds(427, 59, 46, 14);
		contentPane.add(lblLblemplo);
	}
}
