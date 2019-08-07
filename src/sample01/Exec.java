package sample01;
	//連結リスト(LinkedList)のプログラミングに関する質問
	//1. どのように、1つのパスの中で片方向連結リストの真ん中の要素を探しますか？　（解答）
	//2.サイクル　→　nullで終了してから　nullにheadを入れる。終わりがなくなる。
	//3.反転させる headをAじゃなくてEにする。　再帰
	//5. a b c a d e みたいな重複のこと。重複に対する排除が効率的にできる。uniqueで置き換えられる。
	//6. 長さはどうやって調べる？　全件調べればOK
	//7.
	//8.2つの連結リストの合計、例えば、3つの箱があって
	/*
	 * A a-b-c
	 *   1 8 3   123    183+45 キャリーオーバーして 一桁目が1から2になるよね。ということ。
	 * B a-b-c
	 *   0 4 5   45  全部足すと168
	 * */

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

		//1. どのように、1つのパスの中で片方向連結リストの真ん中の要素を探しますか？　（解答） 1つのパスの中で=一回のループの中で。

		//頭を最初に作る
		Node head = new Node("A",
						new Node("B",
							new Node("C",//つまりCを求めるのか。
								new Node("D",
									new Node("E", null)
					))));//連結していく。 A→new Node B→ new Node C ... という感じ。
		Node current = head;//headの参照と同じにする。
		Node middle = head;//真ん中のものを見つけるために、変数を立てる。
		int length =0;

		while(current != null){//currentがnullじゃない場合は繰り返し
				System.out.print(current.value+"\t");//最初はA
				length++;//カウントをとることで、要素数がわかる。
				if(length % 2 == 0){//一つ置き飛ばしに移動していく用になる。currentは全部の時に1個ずつずれていくが。
					middle = middle.next;
				}
				current = current.next;//currentを次のところに与えてあげる。current.nextで連結
		}
		System.out.println();
		System.out.println("length = "+length);
		System.out.println("middle = "+middle.value);//半分ずつ進んでいくから、Currentが終わる頃には、middleは中間に至っている。
	}

}
