package sample08;

class Node{
	int value;
	Node next;
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}


	void print(){
		Node current = this;//thisというのは node1.print のnode1が該当。
		while(current != null){
			System.out.print(current.value+"\t");
			current = current.next;
		}

	}
}

public class Exec {

	public static void main(String[] args) {
		// 8. スタックを使用して、どのように2つの連結リストの合計を調べますか？　（解答）

		Node node1 = new Node(1,new Node(8,new Node(3,null)));//1桁の数字。2桁になったらキャリーオーバーしないといけない。
		Node node2 = new Node(0,new Node(4,new Node(5,null)));

//		int total=0;
//		while(node1!= null && node2 !=null){
//			total += node1.value;
//			total += node2.value;
//			node1 = node1.next;
//			node2 = node2.next;
//		}
//		System.out.println(total);

		System.out.println("node1");
		node1.print();

		System.out.println();
		System.out.println("node2");
		node2.print();

	}

}
