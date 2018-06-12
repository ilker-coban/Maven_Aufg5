package Aufgabe6;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	Queue schlange = new Queue(3);

	@Test(expected = IllegalArgumentException.class)
	public void kleinerAlsEins() {
		Queue kleiner = new Queue(0);

	}

	@Test
	public void einfuegen_entfernen() {
		schlange.enqueue(1);
		schlange.enqueue(2);
		schlange.enqueue(3);
		assertEquals(1,schlange.dequeue());
		assertEquals(2,schlange.dequeue());
		assertEquals(3,schlange.dequeue());
	}
	@Test
	public void QueueVoll(){
		schlange.enqueue(1);
		schlange.enqueue(2);
		schlange.enqueue(3);
		schlange.enqueue(4);
		
		assertFalse("Fehler",false);		
		
	}
	@Test(expected = IllegalStateException.class)
	public void QueueLeer(){
		schlange.dequeue();
		schlange.dequeue();
		schlange.dequeue();
		schlange.dequeue();
		schlange.dequeue();
	
	}
}
