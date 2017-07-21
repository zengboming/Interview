import java.util.ArrayList;

public class PrintListFromTailToHead {
	public class ListNode {
		int val;
		ListNode next = null;
	
		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
	    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	    	ArrayList<Integer> arrayList = new ArrayList<>();
	    	if (listNode == null) {
	    		return arrayList;
	    	}
	    	
	        ListNode pre = listNode;
	        ListNode mid = listNode.next;
	        ListNode nex;
	        pre.next = null;
	        while (mid != null) {
	        	nex = mid.next;
	        	mid.next = pre;
	        	pre = mid;
	        	mid = nex;
	        }
	        
	        while(pre != null) {
	        	arrayList.add(pre.val);
	        	pre = pre.next;
	        }
	        
	        return arrayList;
	    }
	}
}
