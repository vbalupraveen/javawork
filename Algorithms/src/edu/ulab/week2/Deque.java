package edu.ulab.week2;

//Node class
class Item {
	String name;
	Item next;
}

public class Deque {
	Item first, last, oldLast;

	public Deque() {
		first = null;
		last = null;
	}

	// is the Deque empty?
	public boolean isEmpty() {
		return (last == null);
	}

	// return the number of items on the Deque
	public int size() {
		Item i = first;
		int c = 0;
		while (i != null) {
			i = i.next;
			c++;
		}
		return c;
	}

	// insert the item at the front
	public void addFirst(Item item) {
		try {
			Item oldFirst = first;
			first = item;
			if (isEmpty()) {
				last = first;
			} else {
				first.next = oldFirst;
			}
		} catch (NullPointerException e) {
			System.out.println("Exception in adding first");
		}
	}

	// insert the item at the end
	public void addLast(Item item) {
		if (isEmpty()) {
			last = item;
			first = last;
		} else {
			oldLast = last;
			last.next = item;
			last = last.next;
		}
	}

	// remove first item
	public Item removeFirst() {
		if (isEmpty())
			first = null;
		else
			first = first.next;
		return first;
	}

	// remove last item
	public Item removeLast() {
		if (isEmpty())
			last = null;
		else {
			last = oldLast;
			last.next = null;
		}
		return last;
	}

	public static void main(String[] args) {
		Item i, j, k, newFirst, newLast;
		Deque deque = new Deque();
		i = new Item();
		i.name = "Balu";
		j = new Item();
		j.name = "Praveen";
		k = new Item();
		k.name = "Chandra";
		deque.addFirst(i);
		deque.addLast(j);
		deque.addLast(k);
		try {
			newFirst = deque.removeFirst();
			System.out.println("First elemenet after removeFirst:"
					+ newFirst.name);
			newLast = deque.removeLast();
			System.out.println("First elemenet after removeLast:"
					+ newLast.name);
		} catch (NullPointerException e) {
			System.out.println("No elements to remove");
		}
		System.out.println("Size of Deck:" + deque.size());

	}

}
