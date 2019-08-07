package sample05;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


class Node{
	String value;
	Node next;
	public Node(String value, Node next) {
		this.value = value;
		this.next = next;
	}


	public void print(Node node){
		Node current = node;

		while(current !=null){
			System.out.print(current.value+"\t");
			current = current.next;

		}
	}
}

public class Exec {

	public static void main(String[] args) {
		// 5. ソートされていない連結リストにおいて、重複したノードはどのように排除されますか？

		Node head = new Node("A",new Node("A",new Node("C",new Node("D",new Node("D", null)))));

		System.out.println("重複データのあるデータ");
		head.print(head);

		System.out.println();
		System.out.println();

		Map<String, Node> map = new TreeMap<>();//辞書順
		Set<String> set = new TreeSet<>();//辞書順、重複登録NG


		System.out.println("★★mapで★★");
		//Mapでの処理
		Node current = head;
		while(current != null){
			boolean b;
			Node node = map.put(current.value, current);
			b = (null == node);//String, Node. 値が入っていない、つまりキーnullの場合は、値が入っていたら、false　nullだと追加できないからその判定
			// putで入れることに成功したら(true)戻り値としてnullを返す、いれられなかったら(false)、nodeのValueのほうを返す仕組み。
			System.out.println(current.value+"\t"+b);//重なっている場合は　falseの場合は飛ばす。
			if(!b){
				System.out.println("false ::: node value="+node.value);
			}
			//つまりAとDが重複しているということ。

			current = current.next;
		}

		System.out.println();
		System.out.println("★★setで★★");

		Node current2 = head;
		Node previous = null;//next nextでうごくときにその一つ前を覚えておこうという話。
		//箱を一個用意して、currentのカタチを変えていく。参照だからできる技。

		//Setでの処理
		while(current2 != null){
			Boolean b2 = set.add(current2.value);//setはaddした後の結果として、戻り値型がBooleanになる。
			System.out.println(current2.value+": set:"+b2);//trueであれば、入れることができた。falseは入れられなかった,false=重複。

			if(!b2){//もし重複したらの処理　falseを反転trueにさせてif文実行
				//最後にNodeを編集するプログラム
				previous.next = current2.next;

			}else{//こっちが主。
				previous = current2;

			}

			current2 = current2.next;
		}
		System.out.println();

		System.out.println("重複データのあるデータ　処理後");
		head.print(head);


	}

}
