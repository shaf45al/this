//устанавливаем принадлежность класса к пакету
package main;

//подключаем необходимые библиотеки
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
 * Класс, с помощью которого пользователь может выбрать вид пользователя.
 */
public class OsnF {
	 static Formuly obj2 = new Formuly();
	
	 /** 
	  * Конструктор класса.
	  */ 
	public OsnF(){
		
	}
		
	/** 
	 * Открывает Основное окно.
	 */ 
	public void zapusk(){
		JFrame s=new JFrame();
		
		//выполняем настройку Основной формы
		s.setTitle("Добро пожаловать!  Выберите пользователя: ");	
		s.setSize(600,400);           
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //указываем, что будет при нажатии крестика
		s.setLocationRelativeTo(null);                      //размещаем форму по середине экрана 
		s.setLayout(new BorderLayout());
		
		//создаем панель и кнопки для выбора вида пользователя
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,2));
	
		JButton StrakhovatelB=new JButton("Страхователь");   
		JButton StrakhovshikB=new JButton("Страховщик");  
 
		StrakhovatelB.setForeground(Color.BLUE);                  //устанавливаем цвет текста кнопки 
		StrakhovshikB.setForeground(Color.RED);                   //устанавливаем цвет текста кнопки 
		
		/*Добавляем слушателя к кнопке "Страхователь".
		 *Кнопка реагирует на щелчок по ней, открывая окно "Страхователь"
		 */
		StrakhovatelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strakhovatel myStrakhovatel= new Strakhovatel();                               //отобразить форму
				myStrakhovatel.zapusk();
			}});
		
		/*Добавляем слушателя к кнопке "Страховщик".
		 *Кнопка реагирует на щелчок по ней, открывая окно "Страховщик"
		 */
		StrakhovshikB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strakhovshik strakh=new Strakhovshik();
				strakh.zapusk();  										//отобразить форму
			}});
		
		panel.add(StrakhovatelB);
		panel.add(StrakhovshikB);

		//создаем панель и добавляем на нее метку с копирайтом
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBackground(Color.WHITE);                  //устанавливаем цвет фона панели 
		
		JLabel kopiright= new JLabel("copyright © 2018");
		panel1.add(kopiright);								//добавляем метку на панель

		s.add(panel,BorderLayout.CENTER);
		s.add(panel1,BorderLayout.PAGE_END);
		s.setVisible(true);
	}
} 
