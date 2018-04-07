package main;

import java.awt.EventQueue;

public class main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OsnF myOsnF= new OsnF();
					myOsnF.zapusk();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
