package sample07;

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
		//7. 片方向連結リストにおいて、どのように最後から3番目のノードを探しますか？　（解答）

		Node head = new Node("A",new Node("A",new Node("B",new Node("C",new Node("D",new Node("E", new Node("F",null)))))));

		Node current = head;
		Node later = head; //ちょっと遅れてすすむnodeを置く。おなじ参照をとる。並走。


		int count=0;
		while(current!=null){
			System.out.print(current.value+"\t");
			current = current.next;
			count++;

			if(count>3){
				later = later.next;
			}
		}
		System.out.println();
		System.out.println("最後から三番目："+ later.value);




		/*
		 * 			A B C D E
		 * current	A→B→C→D→E
		 * later	later→later→later　2つ分遅らせてから動かし始める。
		 *
		 *
		 * */


	}

}
