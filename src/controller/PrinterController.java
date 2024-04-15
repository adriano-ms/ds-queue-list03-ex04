package controller;

import br.edu.fateczl.queue.Queue;

public class PrinterController {
	
	public PrinterController() {
		super();
	}
	
	public void insertDocument(Queue<model.Document> queue, model.Document document) {
		queue.insert(document);
	}
	
	public void print(Queue<model.Document> queue) throws Exception {
		if(queue.isEmpty())
			throw new Exception("No documents to print!");
		
		while(!queue.isEmpty()) {
			Thread.sleep((int)((Math.random() * 1001) + 1000));
			System.out.println(queue.remove());
		}
	}

}
