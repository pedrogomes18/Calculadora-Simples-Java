/**
 * 
 */
package br.com.calculadora;

import java.awt.EventQueue;

import br.com.view.JFrTela;

/**
 * @author pedro
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrTela frame = new JFrTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
