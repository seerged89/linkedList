package sample03;

class Node{
	String value;
	Node next;
	public Node(String value, Node next) {
		this.value = value;
		this.next = next;
	}
	public void print(Node head){//連結リスト内部の要素を出力するメソッド
		Node current = head;

		while(current!=null){
			System.out.print(current.value + "\t");
			current = current.next;
		}
		System.out.println();
	}
}

public class Exec {

	public static void main(String[] args) {
		/*	3. どのように、連結リストを反転しますか？　（解答）

		 */
		Node head = new Node("A",new Node("B",new Node("C",new Node("D",new Node("E",null)))));



		//リバースするために、2つNodeの変数を用意する
		Node pointer = head;
		Node current = null;
		Node previous = null;

		while(pointer!=null){

			//4つの要素があるから、5つの箱で入れ替えして順番を入れ替える。
			current = pointer;//currentのところにpointerを退避
			pointer = pointer.next;
			current.next = previous;
			previous = current;

			/**
			 * current= 	a	b	c	d	e	null
			 * pointer= 	b	c	d	e	null
			 * currentnext=	nullc	d	e	null
			 * previous=	a	b 	c	d	e	null
			 *
			 *
			 *
			 */
			head = current;// e, c d b a null

		}
		System.out.println("反転後の配置");
		head.print(head);

		/*先頭の動き
		 * 			1		2			3		4		5		6		7
		 * pointer	a		b			b		c
		 *
		 * previous	null	a			a		b
		 *
		 * current	null	a 			b		c
		 *					a.next=null	next=a	next=b
		 *
		 * head		a		a			b		c
		 *
		 * */



	}

}
