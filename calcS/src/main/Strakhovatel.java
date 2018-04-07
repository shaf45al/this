//������������� �������������� ������ � ������
package main;

//��������� ����������� �����������
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * �����, � ������� �������� ������������ �����:
 * <br>	-������ ������� �� ��������� ������� (��������� ������)
 * <br>	-������ �����
 * <br>	-�������� ��������� �������
 * @see Formuly#StrPrem
 * @see LichnyKab#VnestiStrVznos()
 * @see Formuly#StrVyp
 */ 
public class Strakhovatel{
	
	/**
	 * � ������� ���� "������������" ����� ���������������� ������ ������������.
	 * <br>����������  Strakhovatel.isRun1 ����� ��� ����, ����� ����� ������� �� ���� �����������,
	 * <br>�.�. ������� ����� ���� ����� ������ ����� ����, ��� ����� ������� ������.
	 * <br> ���� ����������� ����������� ��� isRun1 ������ <b>false</b>.
	 */
	static boolean isRun1=false;

	/** 
	  * ����������� ������.
	  */
	protected Strakhovatel(){
	}
	
	/** 
	 * ��������� ���� "������������".
	 */ 
	protected void zapusk(){
		JFrame s=new JFrame();	
		//��������� ��������� ����� "������������"
		s.setTitle("������������");		
		s.setSize(500,400);           
		s.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //���������, ��� ����� ��� ������� ��������
		s.setLocationRelativeTo(null);                      //��������� ����� �� �������� ������
		s.setLayout(new GridLayout());
		
		/*� ��������� ��������� ���� ��������� ���������� ������������ ���������� ������������, 
		 * ����������� ������� �� ����� �������� � ������ �����, � ������, �� ������� ��� ����� �����������
		 */
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton zaregat=new JButton("�����������");
		zaregat.setForeground(Color.BLUE);
		JButton lichKab=new JButton("����� � ������ ������"); 
		JLabel podatZayavL=new JLabel("��� �� ����������������?");
		
		//������������� ������������ ����������� ������������ ����������(�� ��������)
		zaregat.setAlignmentX(Component.CENTER_ALIGNMENT); 
		lichKab.setAlignmentX(Component.CENTER_ALIGNMENT); 
		podatZayavL.setAlignmentX(Component.CENTER_ALIGNMENT); 
		
		panel.add(Box.createVerticalGlue(),0); //��������� ������� � ������� �������
		panel.add(lichKab);					   //��������� ��������� �� ������
		panel.add(Box.createVerticalGlue());   //��������� �������
		panel.add(podatZayavL);
		panel.add(zaregat);
		panel.add(Box.createVerticalGlue()); 

		/*��������� ��������� � ������ �����������.
		 *��� ������� �� ������ ����������� ����� "�����������"
		 */
		zaregat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registracya p=new Registracya();
				p.zapusk();
			}
		});
		
		/*��������� ��������� � ������ ����� � ������ �������.
		 *��� ������� �� ������ ����������� ����� "������ �������"
		 */
		lichKab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichnyKab l=new LichnyKab();
				l.zapusk();
			}
		});
	
		s.add(panel);
		s.setVisible(true); 
	}		
}
