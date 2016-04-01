package studi.oop1.kapitel8;

public class StackTest {

	public static void main(String[] args) {
		Stack myList = new Stack(5);
		if (!myList.isFull()) {
			myList.push(new Book("Harry Potter", "Rowling"));
		}
		if (!myList.isFull()) {
			myList.push(new Book("Der Schwarm", "Schaetzing"));
		}
		if (!myList.isEmpty()) {
			Object element = myList.pop();
			if (element instanceof Book) {
				System.out.print("Jetzt lese ich: ");
				Book book = (Book) element;
				book.print();
			}
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

	public void push(Object element) {
		array[top++] = element;
	}

	public Object pop() {
		return array[--top];
	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (top == array.length) {
			return true;
		} else {
			return false;
		}
	}
}
