package sample06;

class Node{
	String value;
	Node next;
	public Node(String value, Node next) {
		this.value = value;
		this.next = next;
	}

}

public class Exec {

	public static void main(String[] args) {
		//6. どのように、片方向連結リストの長さを調べますか？　（解答）

		Node head = new Node("A",new Node("B",new Node("C",new Node("D",new Node("E",null)))));

		Node current = head;
		int total = 0;
		while(current != null){
			System.out.print(current.value + "\t");
			current = current.next;
			total++;
		}
		System.out.println();
		System.out.println("長さ："+ total);


		//7. 片方向連結リストにおいて、どのように最後から3番目のノードを探しますか？　（解答）
		Node current2 = head;
		int count=1;
		while(current2 != null){
			current2 = current2.next;
			if((total - count) == 3){
				System.out.println(current2.value);
				break;
			}
			count++;
		}

	}

}
