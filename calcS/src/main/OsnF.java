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
public class OsnF extends JFrame {
	 static Formuly obj2 = new Formuly();
	/** 
	 * Метод открывает Основное окно приложения.
	 */ 
	public OsnF(){
		
		//выполняем настройку Основной формы
		setTitle("Добро пожаловать!  Выберите пользователя: ");	
		setSize(600,400);           
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //указываем, что будет при нажатии крестика
		setLocationRelativeTo(null);                      //размещаем форму по середине экрана 
		setLayout(new BorderLayout());
		
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
			}});
		
		/*Добавляем слушателя к кнопке "Страховщик".
		 *Кнопка реагирует на щелчок по ней, открывая окно "Страховщик"
		 */
		StrakhovshikB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strakhovshik strakh=new Strakhovshik();
				strakh.setVisible(true);  										//отобразить форму
			}});
		
		panel.add(StrakhovatelB);
		panel.add(StrakhovshikB);

		//создаем панель и добавляем на нее метку с копирайтом
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBackground(Color.WHITE);                  //устанавливаем цвет фона панели 
		
		JLabel kopiright= new JLabel("copyright © 2018");
		panel1.add(kopiright);								//добавляем метку на панель

		add(panel,BorderLayout.CENTER);
		add(panel1,BorderLayout.PAGE_END);
	}
	
	//Метод, с которого начнется запуск приложения
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OsnF myOsnF= new OsnF();
		myOsnF.setVisible(true);
	}
} 
