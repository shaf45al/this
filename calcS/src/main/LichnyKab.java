//������������� �������������� ������ � ������
package main;

//���������� ����������� ����������
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.StrVyplata;

/** 
 * ����� � ������� �������� ������������ �����:
 *  <br>������ ����� ��������� ������ (��������� �������),
 *  <br> ������ ��������� �����,
 *  <br>�������� ��������� �������. 
 */
public class LichnyKab extends JFrame{
	
	/**
	 * � ������ �������� ������������ ����� �������� ��������� �������.
	 * <br> ��� ���� ��������� ��������� ������� �� ������� ������ ����������� ����������.
	 * <br> ���������� <b>isRun1</b> �����, ����� ���������, ������� �� ������������ �� ����� ���. �������.
	 * <br> ���� ��������� ������� ����������� ��� isRun1 ������ <b>false</b>.
	 */
	static boolean isRun1=false;         //������ � ����� �����������
	String loginProverka="";
	String parolProverka="";
	
	/**
	 * �����, � ������� ����������� ������� �� ��������� �������.
	 */
	static JLabel ostatokPoVznosam=new JLabel("");   

	/** 
	 * ����� ��������� ������ �������
	 */ 
	protected LichnyKab(){
		//���� ������
		loginProverka=JOptionPane.showInputDialog(null, "������� �����", null, JOptionPane.INFORMATION_MESSAGE);
		//���� ������
		parolProverka=JOptionPane.showInputDialog(null, "������� ������", null, JOptionPane.INFORMATION_MESSAGE);
	
		//���� ��������� ����� � ������ ������, �� ����������� ��������� ����� "������ �������"
		if(Registracya.parol.equals(parolProverka) & Registracya.login.equals(loginProverka)){	
				System.out.println("�� �����");	
				
				 
				 setSize(600,400);           
				 setTitle("������ �������");
				 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //���������, ��� ����� ��� ������� ��������
				 setLocationRelativeTo(null);                      //��������� ����� �� �������� ������ 
				 setLayout(new GridLayout(2,20,1,20));
		
				/*� ��������� ��������� ���� ��������� ���������� ������������ ���������� ������������, 
				 * ����������� ������� �� ����� �������� � �����������, � ������, �� ������� ��� ����� �����������
				 */
				JPanel panel=new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

				JButton vykhod=new JButton("�����");
				JButton vnestiVznos=new JButton("������ �����");  
				JLabel ostatokPoVznosamL= new JLabel("������� �� ��������� �������,���: ");
				JButton polychitVyplaty=new JButton("�������� ��������� �������");
				
				/*
				 * ��������� �������� ���� ��������� ��� ����������� ����������� ������� �� ��������� ������� � ������ ��������.
				 * ������� �� ���. ������� ������������ ������ ��� ��� ����� � ������ ������� � ������� ������ RaschitatSP() ������ Formuly.
				 * ��, ���� ������� �� ���. ������� ����� 0(������������ ������� ���. �����), �� ��� ��������� ����� � ������ ������� ������� ��������� �� �����
				 */
				if(ostatokPoVznosam.getText().equals("0"))						   
					System.out.println("������� �� ������� 0");
				else 	{
					System.out.println(OsnF.obj2.getdPr());
					System.out.println(OsnF.obj2.getPredKoef());
					ostatokPoVznosam.setText(String.valueOf(UznatOstatok()));  
				}
					//������������� ������������ ����������� ������������ ���������� ������������(�� ��������)
					ostatokPoVznosamL.setAlignmentX(Component.CENTER_ALIGNMENT); 
					ostatokPoVznosam.setAlignmentX(Component.CENTER_ALIGNMENT); 
					vnestiVznos.setAlignmentX(Component.CENTER_ALIGNMENT); 
					vykhod.setAlignmentX(Component.CENTER_ALIGNMENT); 
					polychitVyplaty.setAlignmentX(Component.CENTER_ALIGNMENT); 
					
					//��������� ���������� ������������ ���������� ������������ �� ������
					panel.add(Box.createVerticalGlue()); //��������� �������.
					panel.add(ostatokPoVznosamL);		 //��������� ���������
					panel.add(Box.createVerticalGlue()); 
					panel.add(ostatokPoVznosam);			
					panel.add(Box.createVerticalGlue()); 		
					panel.add(vnestiVznos);
					panel.add(Box.createVerticalGlue()); 
					panel.add(polychitVyplaty);
					panel.add(Box.createVerticalGlue()); 
					panel.add(vykhod);
					panel.add(Box.createVerticalGlue()); 

					/*��������� ��������� � ������ ������.
					 *��� ������� �� ������, ����� ��������� ������������
					 */
					vykhod.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							setVisible(false);								
						}
					});
					
					/*��������� ��������� � ������ "������ �����".
					 *������ ��������� �� ������ �� ���, ����������� ����� ��������� ������ � ������� ������ VnestiStrVznos() ������ LichnyKab
					 */
					vnestiVznos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							VnestiStrVznos();					
						}
					});
					
					/*��������� ��������� � ������ "�������� �������".
					 *������ ��������� �� ������ �� ���, �������� ������ �� ����� �, � ������ ������, ��������� ����� StrVyplata.
					 *
					 */
					polychitVyplaty.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(ostatokPoVznosam.getText().equals("0")) {
								StrVyplata myVyplata=new StrVyplata();
							}else
								System.out.println("������� �� ��������� ������ �� 0");
						}
					});
					
					add(panel);
					setVisible(true); 
		}
	}
	
	/** 
	 * ����� ������������ ����� ��������� ������.
	 * <br>������� �� ��������� ������� ����� ������ � ������� {@link LichnyKab#ostatokPoVznosam}
	 */ 
	protected void VnestiStrVznos(){
		OsnF.obj2.setStrPrem(0);
		ostatokPoVznosam.setText("0");
	}	
	
	protected int UznatOstatok(){
		System.out.println(OsnF.obj2.RaschitatSP());
		return OsnF.obj2.RaschitatSP();
	}
}


