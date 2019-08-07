package sample04;

class Node{
	String value;
	Node next;
	public Node(String value, Node next) {
		this.value = value;
		this.next = next;
	}

	public void print(Node node){
		Node current = node;

		while(current != null){
			System.out.print(current.value+"\t");
			current = current.next;
		}
		System.out.println();
	}

	public Node reverse(Node node){//再帰を行う
		Node newNode;

		if(node == null) return node;
		if(node.next == null)return node;

		newNode = reverse(node.next);// D→E, C→D

		//ここの処理は、whileでprintするときに、逆転させるための処理。
		node.next.next = node;//null→D, E→C
		node.next = null;//E→null, D→null

		return newNode;//E (null, D), D(null, C)

	}

}
/*
 * reverse 1回目
 * node	A			reverse2回目
 * 					node B			3回目
 * 									node C		reverse4回目
 * 												node D
 *	node.next.next=node;
 *	┗B.next = A
 *	node.next = null
 *	┗A.next = null
 *					node.next.next=node;
 *					┗C.next = B
 *					node.next = null
 *					┗B.next = null
 *									node.next.next=node;
 *									┗D.next = C
 *									node.next = null
 *									┗C.next = null
 *												node.next.next=node;
 *												┗E.next = D
 *												node.next = null
 *												┗D.next = null
 *
 * node A B C D E
 * node.next null A B C D
 *
 * */




public class Exec {

	public static void main(String[] args) {
		//4. どのように、再帰せずに片方向連結リストを反転しますか？　（解答）

		Node head = new Node("A",new Node("B",new Node("C",new Node("D",new Node("E",null)))));

		System.out.println("変更前");
		head.print(head);

		head = head.reverse(head);

		System.out.println("逆転後");
		head.print(head);


	}

}
