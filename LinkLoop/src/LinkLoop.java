
public class LinkLoop {

	static class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static boolean hasLoop(Node node) {
		Node fast = node;
		Node slow = node;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int getLoopLength(Node node) {
		if (!hasLoop(node)) {
			return 0;
		}
		Node fast = node;
		Node slow = node;
		boolean begin = false;
		boolean again = false;
		int length = 0;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (begin) {
				length++;
			}
			
			if (fast == slow) {
				if (!again) {
					again = true;
					begin = true;
				} else {
					break;
				}
			}
		}
		
		return length;
	}
	
	public static Node getLoopEntrance(Node node) {
		if (!hasLoop(node)) {
			return null;
		}
		Node fast = node;
		Node slow = node;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				break;
			}
		}
		
		if (fast == null || fast.next == null) {
			return null;
		}
		
		slow = node;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		 Node n1 = new Node(1);  
	     Node n2 = new Node(3);  
	     Node n3 = new Node(6);  
	     Node n4 = new Node(4);  
	     Node n5 = new Node(5);  
	     Node n6 = new Node(10); 
	     n1.next = n2;  
	     n2.next = n3;  
	     n3.next = n4;  
	     n4.next = n5;  
	     n5.next = n6;  
	     n6.next = n5;  
	     boolean hasLoop = hasLoop(n1);
	     int length = getLoopLength(n1);
	     Node node = getLoopEntrance(n1);
	     System.out.println(hasLoop);
	     System.out.println(length);
	     if (node != null) {
	    	 System.out.println(node.value);
	     }
	}
}
