//�ֿ���Storageʵ�ֻ�����
public class Storage {
	
	private int number = 0;
	// �ֿ����洢�� 
	private final int MAX_NUM = 5;
	// �ֿ�洢������ 
	private Object obj = new Object();
	
	public void produce() throws InterruptedException {
		//ͬ��
		synchronized (obj) {
			while (number == MAX_NUM) {
				System.out.println("box is full,size = " + number);
				//����,�̵߳ȴ�,�ͷ���
				obj.wait();
			}
			
			number++;
			System.out.println("produce success number = " + number);
			//���ѵ�ǰ��������еȴ����߳�
			obj.notifyAll();
		}
	}
	
	public void consume() throws InterruptedException {
		//ͬ��
		synchronized (obj) {
			while (number == 0) {
				System.out.println("box is empty,size = " + number);
				//����
				obj.wait();
			}
			
			number--;
			System.out.println("comsume success number = " + number);
			obj.notifyAll();
		}
	}
	
}
