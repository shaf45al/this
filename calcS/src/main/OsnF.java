//������������� �������������� ������ � ������
package main;

//���������� ����������� ����������
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * �����, � ������� �������� ������������ ����� ������� ��� ������������.
 */
public class OsnF {
	 static Formuly obj2 = new Formuly();
	
	 /** 
	  * ����������� ������.
	  */ 
	public OsnF(){
		
	}
		
	/** 
	 * ��������� �������� ����.
	 */ 
	public void zapusk(){
		JFrame s=new JFrame();
		
		//��������� ��������� �������� �����
		s.setTitle("����� ����������!  �������� ������������: ");	
		s.setSize(600,400);           
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //���������, ��� ����� ��� ������� ��������
		s.setLocationRelativeTo(null);                      //��������� ����� �� �������� ������ 
		s.setLayout(new BorderLayout());
		
		//������� ������ � ������ ��� ������ ���� ������������
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,2));
	
		JButton StrakhovatelB=new JButton("������������");   
		JButton StrakhovshikB=new JButton("����������");  
 
		StrakhovatelB.setForeground(Color.BLUE);                  //������������� ���� ������ ������ 
		StrakhovshikB.setForeground(Color.RED);                   //������������� ���� ������ ������ 
		
		/*��������� ��������� � ������ "������������".
		 *������ ��������� �� ������ �� ���, �������� ���� "������������"
		 */
		StrakhovatelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strakhovatel myStrakhovatel= new Strakhovatel();                               //���������� �����
				myStrakhovatel.zapusk();
			}});
		
		/*��������� ��������� � ������ "����������".
		 *������ ��������� �� ������ �� ���, �������� ���� "����������"
		 */
		StrakhovshikB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strakhovshik strakh=new Strakhovshik();
				strakh.zapusk();  										//���������� �����
			}});
		
		panel.add(StrakhovatelB);
		panel.add(StrakhovshikB);

		//������� ������ � ��������� �� ��� ����� � ����������
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBackground(Color.WHITE);                  //������������� ���� ���� ������ 
		
		JLabel kopiright= new JLabel("copyright � 2018");
		panel1.add(kopiright);								//��������� ����� �� ������

		s.add(panel,BorderLayout.CENTER);
		s.add(panel1,BorderLayout.PAGE_END);
		s.setVisible(true);
	}
} 
