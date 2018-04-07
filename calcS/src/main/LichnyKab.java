//устанавливаем принадлежность класса к пакету
package main;

//подключаем необходимые библиотеки
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
 * Класс с помощью которого пользователь может:
 *  <br>узнать сумму страховой премии (страховых взносов),
 *  <br> внести очередной взнос,
 *  <br>получить страховую выплату. 
 */
public class LichnyKab extends JFrame{
	
	/**
	 * В личном кабинете пользователь может получить страховую выплату.
	 * <br> При этом повторное получение выплаты по данному случаю страхования невозможно.
	 * <br> Переменная <b>isRun1</b> нужна, чтобы проверить, получал ли пользователь до этого стр. выплату.
	 * <br> Окно страховой выплаты открывается при isRun1 равным <b>false</b>.
	 */
	static boolean isRun1=false;         //убрать в класс регистрации
	String loginProverka="";
	String parolProverka="";
	
	/**
	 * Метка, в которой указывается остаток по страховым взносам.
	 */
	static JLabel ostatokPoVznosam=new JLabel("");   

	/** 
	 * Метод открывает Личный кабинет
	 */ 
	protected LichnyKab(){
		//ввод логина
		loginProverka=JOptionPane.showInputDialog(null, "Введите логин", null, JOptionPane.INFORMATION_MESSAGE);
		//ввод пароля
		parolProverka=JOptionPane.showInputDialog(null, "Введите пароль", null, JOptionPane.INFORMATION_MESSAGE);
	
		//если введенные логин и пароль верные, то выполняется настройка формы "Личный кабинет"
		if(Registracya.parol.equals(parolProverka) & Registracya.login.equals(loginProverka)){	
				System.out.println("Вы правы");	
				
				 
				 setSize(600,400);           
				 setTitle("Личный кабинет");
				 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //указываем, что будет при нажатии крестика
				 setLocationRelativeTo(null);                      //размещаем форму по середине экрана 
				 setLayout(new GridLayout(2,20,1,20));
		
				/*В следующем фрагменте кода создаются компоненты графического интерфейса пользователя, 
				 * посредством которых он будет работать с приложением, и панель, на которой они будут расположены
				 */
				JPanel panel=new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

				JButton vykhod=new JButton("Выход");
				JButton vnestiVznos=new JButton("Внести взнос");  
				JLabel ostatokPoVznosamL= new JLabel("Остаток по страховым взносам,руб: ");
				JButton polychitVyplaty=new JButton("Получить страховую выплату");
				
				/*
				 * Следующий фрагмент кода необходим для правильного отображения остатка по страховым взносам в личном кабинете.
				 * Остаток по стр. взносам определяется каждый раз при входе в личный кабинет с помощью метода RaschitatSP() класса Formuly.
				 * Но, если остаток по стр. взносам равен 0(пользователь оплатил стр. взнос), то при повторном входе в личный кабинет остаток считаться не будет
				 */
				if(ostatokPoVznosam.getText().equals("0"))						   
					System.out.println("Остаток по взносам 0");
				else 	{
					System.out.println(OsnF.obj2.getdPr());
					System.out.println(OsnF.obj2.getPredKoef());
					ostatokPoVznosam.setText(String.valueOf(UznatOstatok()));  
				}
					//устанавливаем выравнивание компонентов графического интерфейса пользователя(по середине)
					ostatokPoVznosamL.setAlignmentX(Component.CENTER_ALIGNMENT); 
					ostatokPoVznosam.setAlignmentX(Component.CENTER_ALIGNMENT); 
					vnestiVznos.setAlignmentX(Component.CENTER_ALIGNMENT); 
					vykhod.setAlignmentX(Component.CENTER_ALIGNMENT); 
					polychitVyplaty.setAlignmentX(Component.CENTER_ALIGNMENT); 
					
					//добавляем компоненты графического интерфейса пользователя на панель
					panel.add(Box.createVerticalGlue()); //вставляем пружину.
					panel.add(ostatokPoVznosamL);		 //добавляем компонент
					panel.add(Box.createVerticalGlue()); 
					panel.add(ostatokPoVznosam);			
					panel.add(Box.createVerticalGlue()); 		
					panel.add(vnestiVznos);
					panel.add(Box.createVerticalGlue()); 
					panel.add(polychitVyplaty);
					panel.add(Box.createVerticalGlue()); 
					panel.add(vykhod);
					panel.add(Box.createVerticalGlue()); 

					/*Добавляем слушателя к кнопке выхода.
					 *При нажатии на кнопку, форма перестает отображаться
					 */
					vykhod.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							setVisible(false);								
						}
					});
					
					/*Добавляем слушателя к кнопке "Внести взнос".
					 *Кнопка реагирует на щелчок по ней, осуществляя взнос страховой премии с помощью метода VnestiStrVznos() класса LichnyKab
					 */
					vnestiVznos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							VnestiStrVznos();					
						}
					});
					
					/*Добавляем слушателя к кнопке "Получить выплату".
					 *Кнопка реагирует на щелчок по ней, проверяя внесен ли взнос и, в случае уплаты, открывает форму StrVyplata.
					 *
					 */
					polychitVyplaty.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(ostatokPoVznosam.getText().equals("0")) {
								StrVyplata myVyplata=new StrVyplata();
							}else
								System.out.println("остаток по страховой премии не 0");
						}
					});
					
					add(panel);
					setVisible(true); 
		}
	}
	
	/** 
	 * Метод осуществляет взнос страховой премии.
	 * <br>Остаток по страховым взносам будет указан в области {@link LichnyKab#ostatokPoVznosam}
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


