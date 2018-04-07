//������������� �������������� ������ � ������
package main;

//��������� ����������� ����������
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** 
 * �����, � ������� �������� ������������ ����� ������ ���������� ������������ ��������� �������.
 * @see StrVyplata#poluchD
 */
public class StrVyplata {
	
	/** 
	 * ����, ������������ ���������� �� ������������������� ������������ �����, ���. 
	 */ 
	 String poluchD="0";
	
	/** 
	 * ����� ��������� ���� "��������� �������".
	 */
	protected StrVyplata(){
		JFrame s=new JFrame();
		
		/*��������� �������� ���� ���������, ������� �� �� ����� ������������ ��������� ������� �� ������� ������ �����������, 
		 * �.�. ��������� ��������� ������� ����������. 
		 * ���� ��������� ������� ����������� ��� isRun1 ������ false.
		 */
		if(LichnyKab.isRun1==false){
			LichnyKab.isRun1=true;
			
			//���� ����������� ������
			poluchD = JOptionPane.showInputDialog(null, "������� ���������� �����", null, JOptionPane.INFORMATION_MESSAGE);
			
			//���� ������������ �� ���� ���������� �����, �� ���� �� �����������
			if (poluchD.equals("")) {
				LichnyKab.isRun1=false;				//���� ��������� ������� �� ������������, ������ ��������� ������� �� ���������
				s.setVisible(false);
			}
			else {
			
				//��������� ��������� ����� "������������"
				s.setTitle("��������� �������");	
				s.setSize(600,400);  
				s.setLocationRelativeTo(null);                      //��������� ����� �� �������� ������ 
				s.setLayout(new GridLayout());
		
				//�������� ������ � ����������� �����
				JPanel panel=new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

				JLabel label=new JLabel("����� ��������� �������, ���:");
				JLabel strVyplataL=new JLabel(String.valueOf(UznatStrVyp()));
				JLabel pravila=new JLabel("��� ��������� ��������� �������");
				JLabel pravila1=new JLabel("���������� � �������� ����� �� ������: ��.������, �.76");

				//��������� ������������ ����������� (�� ��������)
				label.setAlignmentX(Component.CENTER_ALIGNMENT); 
				strVyplataL.setAlignmentX(Component.CENTER_ALIGNMENT); 
				pravila.setAlignmentX(Component.CENTER_ALIGNMENT); 
				pravila1.setAlignmentX(Component.CENTER_ALIGNMENT); 

				//���������� ����������� �� ������
				panel.add(Box.createVerticalGlue()); 			//������� ������� ������� � ������� �������.
				panel.add(label);
				panel.add(Box.createVerticalGlue());			 //������� �������.
				panel.add(strVyplataL);
				panel.add(Box.createVerticalGlue());
				panel.add(pravila);
				panel.add(pravila1);
				panel.add(Box.createVerticalGlue()); 

				s.add(panel);
				s.setVisible(true);
			}
		}
	}
	
	protected int UznatStrVyp(){
		OsnF.obj2.setdPol(Integer.parseInt(poluchD));
		return OsnF.obj2.RaschitatSV();
	}
}