package coding.leetCode.mayChalange;


class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
	
}


public class OddEvenLinkList {
	public static ListNode addNode(ListNode head, int value) {
		ListNode node = new ListNode(value);
		if(head == null) {
			head = node;
		}else {
			ListNode ptr = head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = node;
		}
		return head;
	}
	
	public static ListNode oddEvenList(ListNode head){
		ListNode oddPointer = head;
		ListNode evenPointer = head.next;
		ListNode evenNextPointer = evenPointer;
		while(oddPointer.next != null && evenPointer.next != null) {
			if(evenPointer.next != null) {
				oddPointer.next = evenPointer.next;
				oddPointer = oddPointer.next;
			}
			if(oddPointer.next != null) {
				evenPointer.next = oddPointer.next;
				evenPointer = evenPointer.next;
			}
		}
		
		oddPointer.next = evenNextPointer;
		evenPointer.next = null;
		return head;
		
	}
	

	public static void main(String[] args) {
		ListNode head = null;
		head = addNode(head, 1);
		head = addNode(head, 2);
		head = oddEvenList(head);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}

}
