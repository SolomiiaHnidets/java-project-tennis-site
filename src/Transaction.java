import java.util.ArrayList;
import java.util.List;

public class Transaction {

	List<Integer> transaction;

	public Transaction() {
		transaction = new ArrayList<Integer>();
	}

	public List<Integer> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Integer> transaction) {
		this.transaction = transaction;
	}

	public void print() {
		for (Integer item : this.transaction) {
			System.out.print(item);
		}
	}

	public void add_item(Integer item_id) {
		this.transaction.add(item_id);
	}

}
