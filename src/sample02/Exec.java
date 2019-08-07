package sample02;

class Node{
	String value;
	Node next;
	public Node(String value, Node next) {
		this.value = value;
		this.next = next;
	}
	//連結リストにもう一つ連結。実際に動かすときにはaddやremoveを使って動かすけど。
	void add(Node head, String value){
		Node current = head;

		while(current != null){
			if(current.next == null){break;}
			current = current.next;
		}
		current.next = new Node(value, null);//語尾に一つ加わる。

	}

}


public class Exec {

	public static void main(String[] args) {
		//2. 与えられた連結リストがcycleを含んでいた場合、どのように確認しますか？　cycleの最初のノードをどのように特定しますか？
		//つまり、1周バージョンと2周バージョン、　先頭が一緒なら、サークルしてるといえる！
		Node head = new Node("A",
				new Node("B",
						new Node("C",
								new Node("D",
										new Node("E",null)))));
//これだと効率悪いからwhile文に		head.next.next.next.next.next = head;//一番最後のnextのところにheadを入れてあげて連結させる。new Node("E",null)のnullの部分。
		//nullに参照を代入して、nullが消えてしまう。参照先headに変わるから。永遠にnullになることはない。サークル。無限ループ状態に陥る。

		head.add(head, "F");
		Node current = head;


		while(current!=null){
			if(current.next == null){//尻尾を見つけたら、break;breakするときcurrentはEだよ。尻尾まで(null)移動している状態。
				break;
			}
			current = current.next;//これでhead.next.next.next.next.next = headを表現。数がわからない場合でも代入できる。
		}

	//	current.next = head;//currentが一番後ろの状態。しっぽが頭につながる。currentがいまEしっぽになっている。current = new Node (E,null)がはいってる状態。
		//上のものを頭につなげないとエラーになってしまう。それを修正する

		current = head;//これで先頭に戻してあげる。
		//ここでcycleだと宣言するのは不確実だから、言えない。



		Node current2 = head;//ループを考えるときは二つのNODEで考える必要がある

		boolean b = false;
		while (current !=null && current2 != null){
			System.out.print(current.value+"/"+current2.value+"\t");
			current = current.next;
			if(current2.next.next!=null){//
				current2 = current2.next.next;//2つずつ動かしていく。一つ飛ばし。currentが1周するときに、current2が2周するということ。
			}else{
				break;
			}
				//2周まわった時に、値が同じであれば、サークルであるといえる。
			if(current.value.equals(current2.value)){
				System.out.println("circle!! head: " + current.value);
				b = true;
				break;
			}

		}
		//ABCDE [A] ここで判断させればいい。Aに何かしらのマークをして、また、そのマークが出てきたら、判断する。
		//1周のcurrentと2周のcurrent

		if(b){
			System.out.println("circle lined list"); //49行目でコントール。circleかcircleじゃないか。2番目のもサークル。
		}else{
			System.out.println("normal linked list");
		}

	}

}
