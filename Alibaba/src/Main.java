import java.util.*;
public class Main {
/** ������������������ʵ����ĿҪ��Ĺ��� **/
/** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
	static int cut(int[] parts) {
	    PriorityQueue<Integer> que=new PriorityQueue<>(parts.length);

	    for(int i=0; i<parts.length; i++){
	        que.add(parts[i]);
	    }
	    int sum=0;
	    while (!que.isEmpty()) {
	        if (1 == que.size()) { break; }  

	        int first = que.poll(); 
	        int second = que.poll();

	        int temp = first + second; 
	        sum += temp; 
	        que.add(temp);
	    }
	    return sum;
	}
	
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));
    }
}