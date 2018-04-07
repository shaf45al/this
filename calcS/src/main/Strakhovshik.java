//устанавливаем принадлежность класса к пакету
package main;

//добавляем необходимые библиотеки
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
 * Класс, с помощью которого пользователь может установить страховой тариф (страховые коэффициенты).
 * @see Strakhovshik#predprKoef
 */ 
public class Strakhovshik{

	 /** 
	  * Конструктор класса.
	  */ 
	protected Strakhovshik(){
	}

	/** 
	 * Открывает окно "Страховщик".
	 */
	protected void zapusk(){
		JFrame s=new JFrame();		
		//выполняем настройку формы "Страховщик"
		s.setTitle("Страховщик");	
		s.setSize(600,400);           
		s.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //указываем, что будет при нажатии крестика
		s.setLocationRelativeTo(null);                      //размещаем форму по середине экрана
		s.setLayout(new FlowLayout());
		
		//создаем основную панель, на которой будут расположены панель для вида страхования, метка и кнопка "Сохранить"
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//создаем панель для вида страхования, метку, уточняющую смысл данной формы, и кнопку сохранения данных
		JPanel panelStrPredpRisk=new JPanel();
		JLabel label=new JLabel("Введите страховые тарифы!");
		label.setForeground(Color.RED);          			 //устанавливаем цвет текста метки
		JButton VnestiKoef=new JButton("Сохранить");   
		 JTextField predprKoefTF=new JTextField("0");
		 
		//устанавливаем выравнивание (по середине) компонентов (панель вида страхования, метка и кнопка "Сохранить")
		panelStrPredpRisk.setAlignmentX(Component.CENTER_ALIGNMENT); 
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		VnestiKoef.setAlignmentX(Component.CENTER_ALIGNMENT);

		//добавляем панель вида страхования, метку и кнопку сохранения на основную панель
		panel.add(label);
		panel.add(panelStrPredpRisk);
		panel.add(VnestiKoef);	
		
		s.add(panel);  //добавляем основную панель на форму
	
		//устанавливаем вид менеджера для размещения компонентов 
		panelStrPredpRisk.setLayout(new GridBagLayout());

		//////////////////////////////////////////////////////////////////////
		//создаем компоненты для панели panelStrPredpRisk
		JLabel predprKoefL=new JLabel("Коэффициент для расчета страховых взносов: ");
		predprKoefTF.setText(Double.toString(OsnF.obj2.getPredKoef()));                  									  //в поле устанавливаем текст в качестве примера
		System.out.println("первый раз установил "+predprKoefTF.getText());
		
		//добавляем созданные компоненты на панель panelStrPredpRisk
		panelStrPredpRisk.add(predprKoefL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		panelStrPredpRisk.add(predprKoefTF,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		panelStrPredpRisk.add(VnestiKoef,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		
		/*Добавляем слушателя к кнопке VnestiKoef.
		 *При нажатии на кнопку происходит сохранение введенного пользователем значения коэффициента в пременную predprKoef
		 */
		VnestiKoef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sohranitKoef(Double.parseDouble(predprKoefTF.getText()));
				System.out.println("коеффициент сохранен "+OsnF.obj2.getPredKoef());
			}
		});

		s.setVisible(true);
	}
	
	protected void sohranitKoef(double koef) {
		OsnF.obj2.setPredKoef(koef);
	}
}
