package ex04;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Transaction last;
    private int size;

    public void addTransaction(Transaction transaction) {
        transaction.setNext(last);
        if(last != null)last.setPrev(transaction);
        last = transaction;
        ++size;
    }

    public void removeTransaction(UUID id) {
        if (last != null && last.getIdentifier() == id) {
            if(last.getNext() != null) last.getNext().setPrev(last.getPrev());
            last = last.getNext();
            --size;
        } else {
            Transaction tmp = last;

            while (tmp != null) {
                if (tmp.getIdentifier() == id) {
                    tmp.getPrev().setNext(tmp.getNext());
                    if(tmp.getNext() != null) tmp.getNext().setPrev(tmp.getPrev());
                    --size;
                    break;
                }
                tmp = tmp.getNext();
            }
            throw new TransactionNotFoundException("Transaction not found");
        }

    }

    public Transaction[] toArray() {
        Transaction[] array = new Transaction[size];
        Transaction tmp = last;
        for (int i = 0; i < size; ++i) {
            array[i] = tmp;
            tmp = tmp.getNext();
        }
        return array;
    }


}
