//устанавливаем принадлежность класса к пакету
package main;

/** 
 * Класс для расчета значений полей:
 * <br>	<b>StrPrem </b> - Страховая премия (страховые взносы)
 * <br>	<b>Y</b> - Ущерб от предпринимательской деятельности
 * <br>	<b>StrVyp</b> - Страховая выплата
 * @see Formuly#StrPrem
 * @see Formuly#Y
 * @see Formuly#StrVyp
 */ 
public class Formuly {
	
	/** 
	 * Поле, обозначающее размер страховой выплаты.
	 */ 
	private int StrVyp;
	
	/** 
	 * Поле, обозначающее размер страховой премии.
	 */ 
	private int StrPrem;
	
	/** 
	 * Поле, обозначающее страховой коэффициент.
	 */ 
	private double predKoef=0.5;
	
	/** 
	 * Поле, обозначающее прогнозируемый доход.
	 */ 
	private int dPr;
	
	/** 
	 * Поле, обозначающее полученный доход.
	 */
	private int dPol;
	
	/** 
	 * Поле, обозначающее процент ответственности страховщика.
	 */
	private int a;
	
	/** 
	 * Метод для расчета размера страховой премии.
	 * 
	 * <br> Расчет размера страховой премии происходит по формуле: 
	 * <br> <b>StrPrem=DPr*k</b>, где
	 * <br> DPr - прогнозируемый доход от предпринимательской деятельности, руб.
	 * <br> k - константа, обозначающая страховой коэффициент.
	 * 
	 * @return Размер страховой премии, руб. 
	 */ 
	protected int RaschitatSP(){
		return this.setStrPrem((int)(this.dPr*this.predKoef));
	}
	
	/** 
	 * Метод для расчета ущерба от предпринимательской деятельности.
	 * 
	 * <br> Расчет ущерба происходит по формуле: 
	 * <br> <b>Y=DPr - DPol</b>, где
	 * <br> DPr - прогнозируемый доход от предпринимательской деятельности, руб.
	 * <br> DPol – полученный доход, руб. 
	 * 
	 * @return Размер ущерба, руб.
	 */ 
	private int RaschitatY(){
		int Y=0;

		if(this.dPol<this.dPr)	//если полученный доход меньше чем прогнозируемый
		 Y=this.dPr-this.dPol;
		else {						//если полученный доход больше или равен прогнозируемому
			System.out.println("ущерба не было нанесено");
			Y=0;
		}
		return Y;
	}
	
	/** 
	 * Метод для расчета размера страховой выплаты.
	 * 
	 * <br>Расчет размера страховой выплаты происходит по формуле: 
	 * <br> <b>StrVyp=Y*a/100</b>, где
	 * <br> Y - раземр ущерба, руб.
	 * <br> a - процент ответственности страховщика, %
	 * 
	 * @return Размер страховой выплаты, руб.
	 */
	protected int RaschitatSV(){
		return this.StrVyp= (int)(RaschitatY()*this.a/100);
	}
	
	/**
	 * сеттеры и геттеры для private переменных данного класса
	 */
	
	public double getPredKoef() {
		return predKoef;
	}

	public void setPredKoef(double predKoef) {
		this.predKoef = predKoef;
	}
	
	public int getdPol() {
		return dPol;
	}

	public void setdPol(int dPol) {
		this.dPol = dPol;
	}
	
	public int getdPr() {
		return dPr;
	}

	public void setdPr(int dPr) {
		this.dPr = dPr;
	}

	public int getStrVyp() {
		return StrVyp;
	}

	public void setStrVyp(int strVyp) {
		StrVyp = strVyp;
	}

	public int getStrPrem() {
		return StrPrem;
	}

	public int setStrPrem(int strPrem) {
		StrPrem = strPrem;
		return strPrem;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}

