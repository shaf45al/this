//устанавливаем принадлежность класса к пакету
package main;

//добавляем необходимые библиотеки
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** 
 * Класс, с помощью которого пользователь может узнать информацию относительно страховой выплаты.
 * @see StrVyplata#poluchD
 */
public class StrVyplata {
	
	/** 
	 * Поле, обозначающее полученный от предпринимательской деятельности доход, руб. 
	 */ 
	 String poluchD="0";
	
	/** 
	 * Метод открывает окно "Страховая выплата".
	 */
	protected StrVyplata(){
		JFrame s=new JFrame();
		
		/*Следующий фрагмент кода проверяет, получал ли до этого пользователь страховую выплату по данному случаю страхования, 
		 * т.к. повторное получение выплаты невозможно. 
		 * Окно страховой выплаты открывается при isRun1 равным false.
		 */
		if(LichnyKab.isRun1==false){
			LichnyKab.isRun1=true;
			
			//ввод полученного ущерба
			poluchD = JOptionPane.showInputDialog(null, "Введите полученный ущерб", null, JOptionPane.INFORMATION_MESSAGE);
			
			//если пользователь не ввел полученный ущерб, то окно не отобразится
			if (poluchD.equals("")) {
				LichnyKab.isRun1=false;				//окно страховой выплаты не отобразилось, значит страховой выплаты не произошло
				s.setVisible(false);
			}
			else {
			
				//выполняем настройку формы "Страхователь"
				s.setTitle("Страховая выплата");	
				s.setSize(600,400);  
				s.setLocationRelativeTo(null);                      //размещние формы по середине экрана 
				s.setLayout(new GridLayout());
		
				//создание панели и компонентов формы
				JPanel panel=new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

				JLabel label=new JLabel("Сумма страховой выплаты, руб:");
				JLabel strVyplataL=new JLabel(String.valueOf(UznatStrVyp()));
				JLabel pravila=new JLabel("Для получения страховой выплаты");
				JLabel pravila1=new JLabel("обратитесь в приемный отдел по адресу: ул.Гафури, д.76");

				//установка выравнивания компонентов (по середине)
				label.setAlignmentX(Component.CENTER_ALIGNMENT); 
				strVyplataL.setAlignmentX(Component.CENTER_ALIGNMENT); 
				pravila.setAlignmentX(Component.CENTER_ALIGNMENT); 
				pravila1.setAlignmentX(Component.CENTER_ALIGNMENT); 

				//добавление компонентов на панель
				panel.add(Box.createVerticalGlue()); 			//вставка верхней пружины в нулевую позицию.
				panel.add(label);
				panel.add(Box.createVerticalGlue());			 //вставка пружины.
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