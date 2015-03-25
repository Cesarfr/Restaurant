package vue.employe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;
import javax.swing.JPasswordField;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue pour modifier employees
 */
public class ModEmploye extends JFrame {

	private JPanel contentPane;
	private JLabel lblemp;
	public JButton btnModEmpEditarReg;
	public JButton btnModEmpSortir;
	private JLabel lblIntroduceElNo;
	private JLabel lblNoEmpleado;
	public JTextField textModEmplNo;
	private JLabel lblNom;
	public JTextField txtModEmpNom;
	private JLabel lblModEmpPrenom;
	public JTextField txtModEmpPrenom;
	private JLabel lblFechaNac;
	private JLabel lblSexe;
	public JTextField txtModEmpRue;
	public JTextField txtModEmpNum;
	public JTextField txtModEmpVille;
	public JTextField txtModEmpPays;
	public JTextField txtModEmpTel;
	public JRadioButton rdbtnModEmpHomme;
	public JRadioButton rdbtnModEmpFemme;
	private JLabel lblVille;
	private JLabel lblNmero;
	private JLabel lblRue;
	private JLabel lblPays;
	private JLabel lblTelfono;
	public JButton btnModEmpSearch;
	public JCalendarCombo calModEmp;
	
	private JLabel lblPuesto;
	public JComboBox<String> cmbModEmpNouPuesto;
	public JComboBox<String> cmbModEmpPuesto;
	private JLabel lblPuesto_1;
	public JComboBox<String> cmbModEmpNom;
	
	private JLabel lblBase1;
	private JLabel lblBase2;
	private JLabel lblBase3;
	private JLabel lblUser;
	public JPasswordField txtModEmpPass;
	public JTextField txtModEmpUser;
	private JLabel lblPassword;

	/**
	 * Create the frame.
	 */
	public ModEmploye() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModEmploye.class.getResource("../../images/FormatFactoryempleado.png")));
		setResizable(false);
		setTitle("Modifier Employ\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblemp = new JLabel("MODIFIER EMPLOY\u00C9");
		lblemp.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblemp.setBounds(263, 11, 316, 20);
		contentPane.add(lblemp);
		
		btnModEmpSortir = new JButton("Sortir");
		btnModEmpSortir.setBackground(new Color(255, 192, 203));
		btnModEmpSortir.setBounds(384, 566, 137, 36);
		contentPane.add(btnModEmpSortir);
		
		btnModEmpEditarReg = new JButton("Modifier Employ\u00E9");
		btnModEmpEditarReg.setBackground(new Color(152, 251, 152));
		btnModEmpEditarReg.setBounds(112, 566, 207, 36);
		contentPane.add(btnModEmpEditarReg);
		
		lblIntroduceElNo = new JLabel("Chercher employ\u00E9 (il choisisse emploi et nom) :");
		lblIntroduceElNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntroduceElNo.setBounds(24, 54, 316, 14);
		contentPane.add(lblIntroduceElNo);
		
		lblNoEmpleado = new JLabel("No. Employ\u00E9");
		lblNoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoEmpleado.setBounds(67, 171, 86, 14);
		contentPane.add(lblNoEmpleado);
		
		textModEmplNo = new JTextField();
		textModEmplNo.setEditable(false);
		textModEmplNo.setBounds(65, 196, 86, 20);
		contentPane.add(textModEmplNo);
		textModEmplNo.setColumns(10);
		
		lblNom = new JLabel("NOM");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom.setBounds(232, 171, 76, 14);
		contentPane.add(lblNom);
		
		txtModEmpNom = new JTextField();
		txtModEmpNom.setBounds(174, 196, 194, 20);
		contentPane.add(txtModEmpNom);
		txtModEmpNom.setColumns(10);
		
		lblModEmpPrenom = new JLabel("Prenom");
		lblModEmpPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModEmpPrenom.setBounds(433, 171, 102, 14);
		contentPane.add(lblModEmpPrenom);
		
		txtModEmpPrenom = new JTextField();
		txtModEmpPrenom.setColumns(10);
		txtModEmpPrenom.setBounds(391, 196, 194, 20);
		contentPane.add(txtModEmpPrenom);
		
		lblFechaNac = new JLabel("Date de Naissance");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNac.setBounds(148, 259, 125, 14);
		contentPane.add(lblFechaNac);
		
		lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexe.setBounds(423, 259, 46, 14);
		contentPane.add(lblSexe);
		
		rdbtnModEmpHomme = new JRadioButton("Homme");
		rdbtnModEmpHomme.setBackground(new Color(238, 232, 170));
		rdbtnModEmpHomme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnModEmpFemme.setSelected(false);
			}
		});
		rdbtnModEmpHomme.setBounds(360, 280, 109, 23);
		contentPane.add(rdbtnModEmpHomme);
		
		rdbtnModEmpFemme = new JRadioButton("Femme");
		rdbtnModEmpFemme.setBackground(new Color(238, 232, 170));
		rdbtnModEmpFemme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnModEmpHomme.setSelected(false);
			}
		});
		rdbtnModEmpFemme.setBounds(470, 280, 109, 23);
		contentPane.add(rdbtnModEmpFemme);
		
		lblRue = new JLabel("Rue");
		lblRue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRue.setBounds(112, 352, 46, 14);
		contentPane.add(lblRue);
		
		txtModEmpRue = new JTextField();
		txtModEmpRue.setColumns(10);
		txtModEmpRue.setBounds(42, 375, 194, 20);
		contentPane.add(txtModEmpRue);
		
		lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNmero.setBounds(295, 352, 58, 14);
		contentPane.add(lblNmero);
		
		txtModEmpNum = new JTextField();
		txtModEmpNum.setBounds(273, 375, 86, 20);
		contentPane.add(txtModEmpNum);
		txtModEmpNum.setColumns(10);
		
		lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVille.setBounds(467, 352, 46, 14);
		contentPane.add(lblVille);
		
		txtModEmpVille = new JTextField();
		txtModEmpVille.setColumns(10);
		txtModEmpVille.setBounds(382, 375, 194, 20);
		contentPane.add(txtModEmpVille);
		
		lblPays = new JLabel("Pays");
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPays.setBounds(123, 434, 86, 14);
		contentPane.add(lblPays);
		
		txtModEmpPays = new JTextField();
		txtModEmpPays.setColumns(10);
		txtModEmpPays.setBounds(42, 474, 194, 20);
		contentPane.add(txtModEmpPays);
		
		lblTelfono = new JLabel("Telephone");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelfono.setBounds(342, 434, 69, 14);
		contentPane.add(lblTelfono);
		
		txtModEmpTel = new JTextField();
		txtModEmpTel.setColumns(10);
		txtModEmpTel.setBounds(273, 474, 194, 20);
		contentPane.add(txtModEmpTel);
		
		btnModEmpSearch = new JButton("Chercher registre");
		btnModEmpSearch.setEnabled(false);
		btnModEmpSearch.setBackground(new Color(152, 251, 152));
		btnModEmpSearch.setBounds(513, 88, 137, 53);
		contentPane.add(btnModEmpSearch);
		
		calModEmp=new JCalendarCombo();
		calModEmp.setBounds(80, 284, 236, 20);
		contentPane.add(calModEmp);
		
		lblPuesto = new JLabel("Puesto");
		lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuesto.setBounds(559, 434, 58, 14);
		contentPane.add(lblPuesto);
		
		cmbModEmpNouPuesto = new JComboBox<String>();
		cmbModEmpNouPuesto.setModel(new DefaultComboBoxModel<String>(new String[] {"Emploi", "Caissier", "Cuisinier", "Serveur"}));
		cmbModEmpNouPuesto.setBounds(519, 474, 117, 20);
		contentPane.add(cmbModEmpNouPuesto);
		
		cmbModEmpPuesto = new JComboBox<String>();
		cmbModEmpPuesto.setToolTipText("Puesto");
		cmbModEmpPuesto.setModel(new DefaultComboBoxModel<String>(new String[] {"Emploi", "Caissier", "Cuisinier", "Serveur"}));
		cmbModEmpPuesto.setBounds(26, 104, 151, 20);
		contentPane.add(cmbModEmpPuesto);
		
		lblPuesto_1 = new JLabel("Emploi :");
		lblPuesto_1.setBounds(65, 79, 86, 14);
		contentPane.add(lblPuesto_1);
		
		cmbModEmpNom = new JComboBox<String>();
		cmbModEmpNom.setEnabled(false);
		cmbModEmpNom.setBounds(246, 104, 221, 20);
		contentPane.add(cmbModEmpNom);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(ModEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 634, 315, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(ModEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(316, 634, 315, 24);
		contentPane.add(lblBase2);
		
		lblBase3 = new JLabel("");
		lblBase3.setIcon(new ImageIcon(ModEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase3.setBounds(606, 634, 203, 24);
		contentPane.add(lblBase3);
		
		lblUser = new JLabel("User");
		lblUser.setBounds(217, 506, 70, 15);
		contentPane.add(lblUser);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(432, 506, 103, 15);
		contentPane.add(lblPassword);
		
		txtModEmpPass = new JPasswordField();
		txtModEmpPass.setBounds(419, 524, 102, 19);
		contentPane.add(txtModEmpPass);
		
		txtModEmpUser = new JTextField();
		txtModEmpUser.setBounds(173, 524, 114, 19);
		contentPane.add(txtModEmpUser);
		txtModEmpUser.setColumns(10);
		
	}
}
