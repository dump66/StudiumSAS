package studi.oop1.kapitel10;

public class StackTest {

	public static void main(String[] args) {
		Stack myList = new Stack(10);
		try {
			myList.push(new Book("Harry Potter", "Rowling"));
		} catch (Exception e) {
			System.out.println("Der Stack ist voll");
		}
		try {
			myList.push(new Book("Der Schwarm", "Schaetzing"));
		} catch (Exception e) {
			System.out.println("Der Stack ist voll");
		}
		//Object element;
		try {
			Object element = myList.pop();

			if (element instanceof Book) {
				System.out.print("Jetzt lese ich: ");
				Book book = (Book) element;
				book.print();
			}
		} catch (Exception e) {
			System.out.println("Der Stack ist leer");
		}
	}
}

class Book {
	private String title;
	private String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void print() {
		System.out.println(title + " von " + author);
	}
}

class Stack {
	private Object[] array;
	private int top = 0;

	public Stack(int nr) {
		array = new Object[nr];
	}

	public void push(Object element) throws Exception {
		array[top] = element;
		top++;
	}

	public Object pop() throws Exception {
		Object element = array[top-1];
		top--;
		return element;
	}

	/*
	 * public boolean isEmpty() { if (top == 0) { return true; } else { return
	 * false; } }
	 * 
	 * public boolean isFull() { if (top == array.length) { return true; } else
	 * { return false; } }
	 */
}
