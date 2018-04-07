//устанавливаем принадлежность класса к пакету
package main;

//добавляем необходимые библиотеки
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 * Класс, с помощью которого пользователь может зарегистрироваться в системе.
 */
public class Registracya extends JFrame {
	static String login="hahaha";
	static String parol="hahaha";
	
	/** 
	 * Метод открывает окно регистрации.
	 * В этом окне пользователь может ввести личные данные, а также данные по страхованию, необходимые для дальнейших расчетов.
	 */ 
	public Registracya(){		
		
		/*проверяется, открыто ли окно регистрации на момент подачи новой заявки.
		 * Открыть новое окно можно только после того, как будет закрыто старое(когда переменная Strakhovatel.isRun1 равна false)
		 */
		if(Strakhovatel.isRun1==false){
			
			//сообщение о потере предыдущих данных
			int opcion=JOptionPane.showConfirmDialog(null, "При подаче новой заявки, старая будет недействительна. Продолжить?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	
			if(opcion==JOptionPane.YES_OPTION){
					
				/* При регистрации нового случая страхования переменной LichnyKab.isRun1 задается значение false.
				 * Это необходимо для того, чтобы пользователь смог получить выплату по новому случаю страхования,
				 * т.к. после получения предыдущей страховой выплаты, переменная LichnyKab.isRun1 установится true,
				 * что приведет к невозможности повторного ее получения.
				 */
				LichnyKab.isRun1=false;	
				
				Strakhovatel.isRun1=true;	//переменная устанавливается true, т.к. открыто новое окно регистрации
				
				//выполняем настройку формы "Регистрация"
				setTitle("Создание новой учетной записи");
				setSize(600,400);           
				setLocationRelativeTo(null);           				    //размещаем форму по середине экрана  
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   //указываем, что будет при нажатии крестика
				setLayout(new FlowLayout());
				
				/*В следующем фрагменте кода создаются компоненты графического интерфейса пользователя, 
				 * посредством которых он будет работать с данным окном, и панель, на которой они будут расположены
				 */
				JPanel panel=new JPanel();
				panel.setLayout(new GridBagLayout());
				
				JButton vykhod=new JButton("Выход"); 
				JButton prodolj=new JButton("Продолжить"); 
				JTextField FIO=new JTextField();
				JTextField parolTF=new JTextField(9);
				JTextField loginTF=new JTextField(9);
				String[] vidStr = {                         		//устанавливаем варианты для combobox
					    "страхование предпринимательких рисков"
					};
				JComboBox comboBoxVidStr = new JComboBox(vidStr);   //создаем combobox для выбора вида страхования
				JButton PodatZayavky=new JButton("Завершить регистрацию"); 
				
				JLabel FIOL= new JLabel("Введите ФИО: ");
				JLabel parolL= new JLabel("Придумайте пароль: ");
				JLabel loginL= new JLabel("Придумайте логин: ");
				JLabel VidStrL= new JLabel("Выберите вид страхования: ");


				//добавляем компоненты на панель
				panel.add(FIOL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(loginL,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(parolL,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(VidStrL,new GridBagConstraints(0,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		
				panel.add(parolTF,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(loginTF,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(FIO,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(comboBoxVidStr,new GridBagConstraints(1,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(prodolj,new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(vykhod,new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));

				//добавляем панель на форму
				add(panel);
								
				//создаем компоненты для страхования предпринимательских рисков		
				JTextField PrognozirDoh=new JTextField("0");
				JTextField proczOtvetStrahovshikaP=new JTextField("0");
				JLabel PrognozirDohL= new JLabel("Прогнозируемый доход, руб: ");
				JLabel proczOtvetStrahovshikaPL= new JLabel("Процент ответственности страховщика,%: ");

				/*Добавляем слушателя к кнопке выхода.
				 *При нажатии на кнопку форма перестает отображаться, а значение переменной Strakhovatel.isRun1 становится false
				 */
				vykhod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Strakhovatel.isRun1=false;
						setVisible(false);
					}
				});
				
				/*Добавляем слушателя к кнопке "Продолжить".
				 * При нажатии на кнопку в окне появляются компоненты для ввода данных по случаю страхования
				 */
				prodolj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parol=parolTF.getText();
						login=loginTF.getText();

								panel.remove(parolTF);
								panel.remove(loginTF);
								panel.remove(FIO);
								panel.remove(comboBoxVidStr);
								panel.remove(parolL);
								panel.remove(loginL);
								panel.remove(FIOL);
								panel.remove(VidStrL);
								panel.remove(prodolj);
								
								panel.add(PrognozirDoh,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(proczOtvetStrahovshikaP,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));

								panel.add(PrognozirDohL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(proczOtvetStrahovshikaPL,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(PodatZayavky,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(vykhod,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								
								panel.revalidate();				//сообщает менеджеру компоновки пересчитать макет
						}
					});
				
				/*Добавляем слушателя к кнопке завершения регистрации.
				 * При нажатии на кнопку устанавливаются значения переменных DPr и a.
				 */
				PodatZayavky.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						OsnF.obj2.setdPr(Integer.parseInt(PrognozirDoh.getText()));
						OsnF.obj2.setA(Integer.parseInt(proczOtvetStrahovshikaP.getText()));
						 LichnyKab.ostatokPoVznosam.setText("");
					}
				});
				setVisible(true); 								 //устанавливаем видимость формы
			} 													 //завершение if(opcion==JOptionPane.YES_OPTION)
		}else
			System.out.println("Вы уже открыли форму");
	}
} 

