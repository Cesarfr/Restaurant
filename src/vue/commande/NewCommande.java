package vue.commande;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.freixas.jcalendar.JCalendarCombo;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue newcommnade
 */
public class NewCommande extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	public JTextField txtNTab;
	public JTextField txtNomPers;
	public JTextField txtEmplo;
	public JButton btnGenerar;
	public JButton btnAnnuler;
	public JCalendarCombo calendario;
	public JTextField txtNComm;
	private JLabel lblNumComm;
	private JLabel lblNmeroTable;
	private JLabel lblNPers;
	private JLabel lblNumEmpl;
	public JLabel lblStat;
	public JLabel lblEnProceso;
	private JLabel lblBase1;
	private JLabel lblBase2;

	/**
	 * Create the frame.
	 */
	public NewCommande() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewCommande.class.getResource("../../images/steak-32.png")));
		setTitle("Nouvelle Commande");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 295);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("NOUVELLE COMMANDE");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblTitle.setBounds(10, 11, 522, 17);
		contentPane.add(lblTitle);
		
		lblNmeroTable = new JLabel("Numero du Tableau");
		lblNmeroTable.setBounds(142, 66, 114, 14);
		contentPane.add(lblNmeroTable);
		
		lblNPers = new JLabel("Nombre de personnes");
		lblNPers.setBounds(266, 66, 135, 14);
		contentPane.add(lblNPers);
		
		lblNumEmpl = new JLabel("Nombre d'Employe");
		lblNumEmpl.setBounds(411, 66, 145, 14);
		contentPane.add(lblNumEmpl);
		
		txtNTab = new JTextField();
		txtNTab.setHorizontalAlignment(SwingConstants.CENTER);
		txtNTab.setBounds(152, 84, 86, 20);
		contentPane.add(txtNTab);
		txtNTab.setColumns(10);
		
		txtNomPers = new JTextField();
		txtNomPers.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomPers.setBounds(279, 84, 86, 20);
		contentPane.add(txtNomPers);
		txtNomPers.setColumns(10);
		
		txtEmplo = new JTextField();
		txtEmplo.setEnabled(false);
		txtEmplo.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmplo.setBounds(411, 84, 86, 20);
		contentPane.add(txtEmplo);
		txtEmplo.setColumns(10);
		
		btnGenerar = new JButton("G\u00E9n\u00E9rer");
		btnGenerar.setBackground(new Color(152, 251, 152));
		btnGenerar.setBounds(142, 181, 99, 23);
		contentPane.add(btnGenerar);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 192, 203));
		btnAnnuler.setBounds(287, 181, 89, 23);
		contentPane.add(btnAnnuler);
		
		calendario=new JCalendarCombo();
		calendario.setEditable(true);
		calendario.setEnabled(false);
		calendario.setBounds(287, 35, 232, 20);
		contentPane.add(calendario);
		
		lblStat = new JLabel("Status");
		lblStat.setVisible(false);
		lblStat.setHorizontalAlignment(SwingConstants.CENTER);
		lblStat.setBounds(212, 115, 89, 14);
		contentPane.add(lblStat);
		
		lblEnProceso = new JLabel("En Proceso");
		lblEnProceso.setVisible(false);
		lblEnProceso.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnProceso.setForeground(Color.RED);
		lblEnProceso.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnProceso.setBounds(165, 140, 174, 30);
		contentPane.add(lblEnProceso);
		
		txtNComm = new JTextField();
		txtNComm.setEnabled(false);
		txtNComm.setHorizontalAlignment(SwingConstants.CENTER);
		txtNComm.setBounds(27, 84, 77, 20);
		contentPane.add(txtNComm);
		txtNComm.setColumns(10);
		
		lblNumComm = new JLabel("Numero du Commande");
		lblNumComm.setBounds(0, 66, 145, 14);
		contentPane.add(lblNumComm);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(NewCommande.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 220, 315, 46);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(NewCommande.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(308, 220, 248, 46);
		contentPane.add(lblBase2);
	}
	
	public String recFech(){
		String fecha="";
		fecha=calendario.getCalendar().get(Calendar.YEAR)+"/"+(1+ calendario.getCalendar().get(Calendar.MONTH))+"/"+calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
		return fecha;
	}
	
//	public void verificar(){// validaciones
//		
//		boolean hac=Hacienda.buscarMesa(Integer.parseInt(txtmesa.getText()));
//		
//		if(txtOrden.getText().equals("") || txtOrden.getText().equals(null)){
//			JOptionPane.showMessageDialog(null, "La caja de Orden esta vacia");
//			txtOrden.requestFocus();
//		}else if(txtmesa.getText().equals("") || txtmesa.getText().equals("")){
//			JOptionPane.showMessageDialog(null, "La caja de mesa esta vacia");
//			txtmesa.requestFocus();
//		}else if(txtcomensal.getText().equals("") || txtcomensal.getText().equals(null)){
//			JOptionPane.showMessageDialog(null, "La caja de comensal esta vacia");
//			txtcomensal.requestFocus();
//		}else if(txtempleado.getText().equals("") || txtempleado.getText().equals(null)){
//			JOptionPane.showMessageDialog(null, "La caja de empleado esta vacia");
//			txtempleado.requestFocus();
//		}else if(hac){
//			JOptionPane.showMessageDialog(null, "La mesa esta ocupada");
//			txtmesa.requestFocus();
//		}else{
//			DetalleOrden detalle=new DetalleOrden();
//			detalle.llenar(Integer.parseInt(txtOrden.getText()), Integer.parseInt(txtcomensal.getText()));			
//			guarord.setNoOrd(Integer.parseInt(txtOrden.getText()));
//			guarord.setNoMes(Integer.parseInt(txtmesa.getText()));
//			guarord.setNoCom(Integer.parseInt(txtcomensal.getText()));
//			guarord.setNoEmpl(Integer.parseInt(txtempleado.getText()));
//			guarord.setEstado(lblEnProceso.getText());
//			guarord.setFecha(recFech());
//			guarord.setTotal(0.00f);
//			String orden = guarord.AgregOrden(guarord);
//			JOptionPane.showMessageDialog(null, orden);
//			
//			if(orden.equals("ORDEN GUARDADA CORRECTAMENTE")){
//				detalle.setVisible(true);
//				detalle.setLocationRelativeTo(null);
//				setVisible(false);
//			}
//			
//		}
//	}
//	
//	public void numord(String usuario){
//		try{
//			noempl=Hacienda.BuscarEmp(usuario);
//			while(noempl.next()){
//				txtempleado.setText(Integer.toString(noempl.getInt(1)));
//			}
//			//noempl.close();
//			
//			nom=Hacienda.NumactOrden();
//			int a=0;
//			while(nom.next()){
//				a=nom.getInt(1);
//			}
//			if(a==0){
//				txtOrden.setText(Integer.toString(1));
//			}else{
//				txtOrden.setText(Integer.toString(a+1));
//			}
//			System.err.println(a);
//			//nom.close();
//		}catch(SQLException ex){
//			JOptionPane.showMessageDialog(null, "Error al recuperar la orden y numero de empleado "+ex);
//		}
//		
//	}
}

