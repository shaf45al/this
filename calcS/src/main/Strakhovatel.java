//устанавливаем принадлежность класса к пакету
package main;

//добавляем необходимые бибилиотеки
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
 * Класс, с помощью которого пользователь может:
 * <br>	-узнать остаток по страховым взносам (страховой премии)
 * <br>	-внести взнос
 * <br>	-получить страховую выплату
 * @see Formuly#StrPrem
 * @see LichnyKab#VnestiStrVznos()
 * @see Formuly#StrVyp
 */ 
public class Strakhovatel{
	
	/**
	 * С помощью окна "Страхователь" можно зарегистрировать нового пользователя.
	 * <br>Переменная  Strakhovatel.isRun1 нужна для того, чтобы знать открыто ли окно регистрации,
	 * <br>т.к. открыть новое окно можно только после того, как будет закрыто старое.
	 * <br> Окно регистрации открывается при isRun1 равным <b>false</b>.
	 */
	static boolean isRun1=false;

	/** 
	  * Конструктор класса.
	  */
	protected Strakhovatel(){
	}
	
	/** 
	 * Открывает окно "Страхователь".
	 */ 
	protected void zapusk(){
		JFrame s=new JFrame();	
		//выполняем настройку формы "Страхователь"
		s.setTitle("Страхователь");		
		s.setSize(500,400);           
		s.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //указываем, что будет при нажатии крестика
		s.setLocationRelativeTo(null);                      //размещаем форму по середине экрана
		s.setLayout(new GridLayout());
		
		/*В следующем фрагменте кода создаются компоненты графического интерфейса пользователя, 
		 * посредством которых он будет работать с данным окном, и панель, на которой они будут расположены
		 */
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton zaregat=new JButton("Регистрация");
		zaregat.setForeground(Color.BLUE);
		JButton lichKab=new JButton("Войти в личный кабнет"); 
		JLabel podatZayavL=new JLabel("Еще не зарегистрированы?");
		
		//устанавливаем выравнивание компонентов графического интерфейса(по середине)
		zaregat.setAlignmentX(Component.CENTER_ALIGNMENT); 
		lichKab.setAlignmentX(Component.CENTER_ALIGNMENT); 
		podatZayavL.setAlignmentX(Component.CENTER_ALIGNMENT); 
		
		panel.add(Box.createVerticalGlue(),0); //вставляем пружину в нулевую позицию
		panel.add(lichKab);					   //добавляем компонент на панель
		panel.add(Box.createVerticalGlue());   //вставляем пружину
		panel.add(podatZayavL);
		panel.add(zaregat);
		panel.add(Box.createVerticalGlue()); 

		/*Добавляем слушателя к кнопке регистрации.
		 *При нажатии на кнопку открывается форма "Регистрация"
		 */
		zaregat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registracya p=new Registracya();
				p.zapusk();
			}
		});
		
		/*Добавляем слушателя к кнопке входа в личный кабинет.
		 *При нажатии на кнопку открывается форма "Личный кабинет"
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
