//������������� �������������� ������ � ������
package main;

/** 
 * ����� ��� ������� �������� �����:
 * <br>	<b>StrPrem </b> - ��������� ������ (��������� ������)
 * <br>	<b>Y</b> - ����� �� ������������������� ������������
 * <br>	<b>StrVyp</b> - ��������� �������
 * @see Formuly#StrPrem
 * @see Formuly#Y
 * @see Formuly#StrVyp
 */ 
public class Formuly {
	
	/** 
	 * ����, ������������ ������ ��������� �������.
	 */ 
	private int StrVyp;
	
	/** 
	 * ����, ������������ ������ ��������� ������.
	 */ 
	private int StrPrem;
	
	/** 
	 * ����, ������������ ��������� �����������.
	 */ 
	private double predKoef=0.5;
	
	/** 
	 * ����, ������������ �������������� �����.
	 */ 
	private int dPr;
	
	/** 
	 * ����, ������������ ���������� �����.
	 */
	private int dPol;
	
	/** 
	 * ����, ������������ ������� ��������������� �����������.
	 */
	private int a;
	
	/** 
	 * ����� ��� ������� ������� ��������� ������.
	 * 
	 * <br> ������ ������� ��������� ������ ���������� �� �������: 
	 * <br> <b>StrPrem=DPr*k</b>, ���
	 * <br> DPr - �������������� ����� �� ������������������� ������������, ���.
	 * <br> k - ���������, ������������ ��������� �����������.
	 * 
	 * @return ������ ��������� ������, ���. 
	 */ 
	protected int RaschitatSP(){
		return this.setStrPrem((int)(this.dPr*this.predKoef));
	}
	
	/** 
	 * ����� ��� ������� ������ �� ������������������� ������������.
	 * 
	 * <br> ������ ������ ���������� �� �������: 
	 * <br> <b>Y=DPr - DPol</b>, ���
	 * <br> DPr - �������������� ����� �� ������������������� ������������, ���.
	 * <br> DPol � ���������� �����, ���. 
	 * 
	 * @return ������ ������, ���.
	 */ 
	private int RaschitatY(){
		int Y=0;

		if(this.dPol<this.dPr)	//���� ���������� ����� ������ ��� ��������������
		 Y=this.dPr-this.dPol;
		else {						//���� ���������� ����� ������ ��� ����� ���������������
			System.out.println("������ �� ���� ��������");
			Y=0;
		}
		return Y;
	}
	
	/** 
	 * ����� ��� ������� ������� ��������� �������.
	 * 
	 * <br>������ ������� ��������� ������� ���������� �� �������: 
	 * <br> <b>StrVyp=Y*a/100</b>, ���
	 * <br> Y - ������ ������, ���.
	 * <br> a - ������� ��������������� �����������, %
	 * 
	 * @return ������ ��������� �������, ���.
	 */
	protected int RaschitatSV(){
		return this.StrVyp= (int)(RaschitatY()*this.a/100);
	}
	
	/**
	 * ������� � ������� ��� private ���������� ������� ������
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

