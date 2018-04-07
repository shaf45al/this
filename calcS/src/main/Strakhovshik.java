//������������� �������������� ������ � ������
package main;

//��������� ����������� ����������
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 * �����, � ������� �������� ������������ ����� ���������� ��������� ����� (��������� ������������).
 * @see Strakhovshik#predprKoef
 */ 
public class Strakhovshik{

	 /** 
	  * ����������� ������.
	  */ 
	protected Strakhovshik(){
	}

	/** 
	 * ��������� ���� "����������".
	 */
	protected void zapusk(){
		JFrame s=new JFrame();		
		//��������� ��������� ����� "����������"
		s.setTitle("����������");	
		s.setSize(600,400);           
		s.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //���������, ��� ����� ��� ������� ��������
		s.setLocationRelativeTo(null);                      //��������� ����� �� �������� ������
		s.setLayout(new FlowLayout());
		
		//������� �������� ������, �� ������� ����� ����������� ������ ��� ���� �����������, ����� � ������ "���������"
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//������� ������ ��� ���� �����������, �����, ���������� ����� ������ �����, � ������ ���������� ������
		JPanel panelStrPredpRisk=new JPanel();
		JLabel label=new JLabel("������� ��������� ������!");
		label.setForeground(Color.RED);          			 //������������� ���� ������ �����
		JButton VnestiKoef=new JButton("���������");   
		 JTextField predprKoefTF=new JTextField("0");
		 
		//������������� ������������ (�� ��������) ����������� (������ ���� �����������, ����� � ������ "���������")
		panelStrPredpRisk.setAlignmentX(Component.CENTER_ALIGNMENT); 
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		VnestiKoef.setAlignmentX(Component.CENTER_ALIGNMENT);

		//��������� ������ ���� �����������, ����� � ������ ���������� �� �������� ������
		panel.add(label);
		panel.add(panelStrPredpRisk);
		panel.add(VnestiKoef);	
		
		s.add(panel);  //��������� �������� ������ �� �����
	
		//������������� ��� ��������� ��� ���������� ����������� 
		panelStrPredpRisk.setLayout(new GridBagLayout());

		//////////////////////////////////////////////////////////////////////
		//������� ���������� ��� ������ panelStrPredpRisk
		JLabel predprKoefL=new JLabel("����������� ��� ������� ��������� �������: ");
		predprKoefTF.setText(Double.toString(OsnF.obj2.getPredKoef()));                  									  //� ���� ������������� ����� � �������� �������
		System.out.println("������ ��� ��������� "+predprKoefTF.getText());
		
		//��������� ��������� ���������� �� ������ panelStrPredpRisk
		panelStrPredpRisk.add(predprKoefL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		panelStrPredpRisk.add(predprKoefTF,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		panelStrPredpRisk.add(VnestiKoef,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		
		/*��������� ��������� � ������ VnestiKoef.
		 *��� ������� �� ������ ���������� ���������� ���������� ������������� �������� ������������ � ��������� predprKoef
		 */
		VnestiKoef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sohranitKoef(Double.parseDouble(predprKoefTF.getText()));
				System.out.println("����������� �������� "+OsnF.obj2.getPredKoef());
			}
		});

		s.setVisible(true);
	}
	
	protected void sohranitKoef(double koef) {
		OsnF.obj2.setPredKoef(koef);
	}
}
