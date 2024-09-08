package co.edu.uptc.view;

import javax.swing.JOptionPane;

/**
 * esta clase representa la vista permite la lectura e impresion de datos
 * 
 * @author Bryan
 * @version 1.0
 */

public class View {
	private String titlewindow;

	/**
	 * crea una instancia de la clase view
	 * 
	 * @param titlewindow este parametro define el titulo de la ventana emergente
	 */

	public View(String titlewindow) {
		this.titlewindow = titlewindow;
	}

	/**
	 * imprime un mensaje por ventana emergente
	 * 
	 * @param message es de tipo string lo imprime atravez de JOptionPane
	 */

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, titlewindow, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * abre una ventana emergente para ingresar informacion
	 * 
	 * @param message es de tipo string lo imprime atravez de JOptionPane
	 * @return devuelve un string con la informacion capturada por teclado
	 */

	public String readInfo(String message) {
		return JOptionPane.showInputDialog(null, message, titlewindow, JOptionPane.QUESTION_MESSAGE);
	}

	/**
	 * abre una ventana emergente para ingresar informacion dependiendo con el panel
	 * desplegable
	 * 
	 * @param message  es de tipo string lo imprime atravez de JOptionPane
	 * @param arrayopc es un arreglo de objetos que contiene la informacion del
	 *                 panel desplegable
	 * @return devuelve el objeto selecciopnado que pertenece al arreglo arrayopc
	 */

	public Object readInMenu(String message, Object[] arrayopc, int positionArr) {
		return JOptionPane.showInputDialog(null, message, titlewindow, JOptionPane.QUESTION_MESSAGE, null, arrayopc,
				arrayopc[positionArr]);
	}

	public int optionMenu(Object[] menu) {
		String opcString = (String) readInMenu("Ingrese la opcion deseada", menu, 0);
		if (opcString == null) {
			System.exit(0);
		}
		return Integer.parseInt(opcString.split("\\.")[0].trim());
	}
}
