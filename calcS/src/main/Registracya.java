//������������� �������������� ������ � ������
package main;

//��������� ����������� ����������
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 * �����, � ������� �������� ������������ ����� ������������������ � �������.
 */
public class Registracya extends JFrame {
	static String login="hahaha";
	static String parol="hahaha";
	
	/** 
	 * ����� ��������� ���� �����������.
	 * � ���� ���� ������������ ����� ������ ������ ������, � ����� ������ �� �����������, ����������� ��� ���������� ��������.
	 */ 
	public Registracya(){		
		
		/*�����������, ������� �� ���� ����������� �� ������ ������ ����� ������.
		 * ������� ����� ���� ����� ������ ����� ����, ��� ����� ������� ������(����� ���������� Strakhovatel.isRun1 ����� false)
		 */
		if(Strakhovatel.isRun1==false){
			
			//��������� � ������ ���������� ������
			int opcion=JOptionPane.showConfirmDialog(null, "��� ������ ����� ������, ������ ����� ���������������. ����������?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	
			if(opcion==JOptionPane.YES_OPTION){
					
				/* ��� ����������� ������ ������ ����������� ���������� LichnyKab.isRun1 �������� �������� false.
				 * ��� ���������� ��� ����, ����� ������������ ���� �������� ������� �� ������ ������ �����������,
				 * �.�. ����� ��������� ���������� ��������� �������, ���������� LichnyKab.isRun1 ����������� true,
				 * ��� �������� � ������������� ���������� �� ���������.
				 */
				LichnyKab.isRun1=false;	
				
				Strakhovatel.isRun1=true;	//���������� ��������������� true, �.�. ������� ����� ���� �����������
				
				//��������� ��������� ����� "�����������"
				setTitle("�������� ����� ������� ������");
				setSize(600,400);           
				setLocationRelativeTo(null);           				    //��������� ����� �� �������� ������  
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   //���������, ��� ����� ��� ������� ��������
				setLayout(new FlowLayout());
				
				/*� ��������� ��������� ���� ��������� ���������� ������������ ���������� ������������, 
				 * ����������� ������� �� ����� �������� � ������ �����, � ������, �� ������� ��� ����� �����������
				 */
				JPanel panel=new JPanel();
				panel.setLayout(new GridBagLayout());
				
				JButton vykhod=new JButton("�����"); 
				JButton prodolj=new JButton("����������"); 
				JTextField FIO=new JTextField();
				JTextField parolTF=new JTextField(9);
				JTextField loginTF=new JTextField(9);
				String[] vidStr = {                         		//������������� �������� ��� combobox
					    "����������� ������������������ ������"
					};
				JComboBox comboBoxVidStr = new JComboBox(vidStr);   //������� combobox ��� ������ ���� �����������
				JButton PodatZayavky=new JButton("��������� �����������"); 
				
				JLabel FIOL= new JLabel("������� ���: ");
				JLabel parolL= new JLabel("���������� ������: ");
				JLabel loginL= new JLabel("���������� �����: ");
				JLabel VidStrL= new JLabel("�������� ��� �����������: ");


				//��������� ���������� �� ������
				panel.add(FIOL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(loginL,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(parolL,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(VidStrL,new GridBagConstraints(0,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		
				panel.add(parolTF,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(loginTF,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(FIO,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(comboBoxVidStr,new GridBagConstraints(1,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(prodolj,new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(vykhod,new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));

				//��������� ������ �� �����
				add(panel);
								
				//������� ���������� ��� ����������� ������������������� ������		
				JTextField PrognozirDoh=new JTextField("0");
				JTextField proczOtvetStrahovshikaP=new JTextField("0");
				JLabel PrognozirDohL= new JLabel("�������������� �����, ���: ");
				JLabel proczOtvetStrahovshikaPL= new JLabel("������� ��������������� �����������,%: ");

				/*��������� ��������� � ������ ������.
				 *��� ������� �� ������ ����� ��������� ������������, � �������� ���������� Strakhovatel.isRun1 ���������� false
				 */
				vykhod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Strakhovatel.isRun1=false;
						setVisible(false);
					}
				});
				
				/*��������� ��������� � ������ "����������".
				 * ��� ������� �� ������ � ���� ���������� ���������� ��� ����� ������ �� ������ �����������
				 */
				prodolj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parol=parolTF.getText();
						login=loginTF.getText();

								panel.remove(parolTF);
								panel.remove(loginTF);
								panel.remove(FIO);
								panel.remove(comboBoxVidStr);
								panel.remove(parolL);
								panel.remove(loginL);
								panel.remove(FIOL);
								panel.remove(VidStrL);
								panel.remove(prodolj);
								
								panel.add(PrognozirDoh,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(proczOtvetStrahovshikaP,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));

								panel.add(PrognozirDohL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(proczOtvetStrahovshikaPL,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(PodatZayavky,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(vykhod,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								
								panel.revalidate();				//�������� ��������� ���������� ����������� �����
						}
					});
				
				/*��������� ��������� � ������ ���������� �����������.
				 * ��� ������� �� ������ ��������������� �������� ���������� DPr � a.
				 */
				PodatZayavky.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						OsnF.obj2.setdPr(Integer.parseInt(PrognozirDoh.getText()));
						OsnF.obj2.setA(Integer.parseInt(proczOtvetStrahovshikaP.getText()));
						 LichnyKab.ostatokPoVznosam.setText("");
					}
				});
				setVisible(true); 								 //������������� ��������� �����
			} 													 //���������� if(opcion==JOptionPane.YES_OPTION)
		}else
			System.out.println("�� ��� ������� �����");
	}
} 

