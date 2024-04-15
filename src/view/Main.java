package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import br.edu.fateczl.queue.Queue;
import controller.PrinterController;

public class Main {

	public static void main(String[] args) {

		try {
			Queue<model.Document> queue = new Queue<>();
			PrinterController printer = new PrinterController();
			String[] options = { "Insert document", "Print" };
			String option;
			Pattern pattern = Pattern.compile("\\d+;\\w+");
			do {
				option = (String) JOptionPane.showInputDialog(null, "Select Operation", "Printer Service",
						JOptionPane.DEFAULT_OPTION, null, options, options[0]);

				try {
					switch (option) {
					case null:
						break;

					case "Insert document":
						String input = JOptionPane.showInputDialog(null, "Document (PC_ID;File_Name):", option,
								JOptionPane.DEFAULT_OPTION);
						if (input != null) {
							Matcher matcher = pattern.matcher(input);
							if (!matcher.find())
								throw new Exception("Invalid format!");

							input = matcher.group();
							String[] aux = input.split(";");
							printer.insertDocument(queue, new model.Document(Integer.parseInt(aux[0]), aux[1]));
							JOptionPane.showMessageDialog(null, "Document inserted!", option,
									JOptionPane.INFORMATION_MESSAGE);
						}
						break;

					case "Print":
						printer.print(queue);
						break;
					default:
						throw new Exception("Invalid operation!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Printer Service", JOptionPane.ERROR_MESSAGE);
				}
			} while (option != null);

		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
	}

}
