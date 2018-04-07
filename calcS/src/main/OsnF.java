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
public class OsnF extends JFrame {
	 static Formuly obj2 = new Formuly();
	/** 
	 * ����� ��������� �������� ���� ����������.
	 */ 
	public OsnF(){
		
		//��������� ��������� �������� �����
		setTitle("����� ����������!  �������� ������������: ");	
		setSize(600,400);           
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //���������, ��� ����� ��� ������� ��������
		setLocationRelativeTo(null);                      //��������� ����� �� �������� ������ 
		setLayout(new BorderLayout());
		
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
			}});
		
		/*��������� ��������� � ������ "����������".
		 *������ ��������� �� ������ �� ���, �������� ���� "����������"
		 */
		StrakhovshikB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strakhovshik strakh=new Strakhovshik();
				strakh.setVisible(true);  										//���������� �����
			}});
		
		panel.add(StrakhovatelB);
		panel.add(StrakhovshikB);

		//������� ������ � ��������� �� ��� ����� � ����������
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBackground(Color.WHITE);                  //������������� ���� ���� ������ 
		
		JLabel kopiright= new JLabel("copyright � 2018");
		panel1.add(kopiright);								//��������� ����� �� ������

		add(panel,BorderLayout.CENTER);
		add(panel1,BorderLayout.PAGE_END);
	}
	
	//�����, � �������� �������� ������ ����������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OsnF myOsnF= new OsnF();
		myOsnF.setVisible(true);
	}
} 
