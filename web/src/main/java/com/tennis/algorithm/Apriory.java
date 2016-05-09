package com.tennis.algorithm;

/**
 * Created by John on 09.05.2016.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tennis.domain.Transaction;

public class Apriory {

    private int support;
    private static int SUPPORT = 2;

    public Apriory() {
        this.support = SUPPORT;
    }
    // 1 video find in two-cobination where mentioned this video and has max
    // support
    public List<Transaction> AprioriAlgorithm() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        Transaction transaction1 = new Transaction();
        Transaction transaction2 = new Transaction();
        Transaction transaction3 = new Transaction();
        Transaction transaction4 = new Transaction();
        Transaction transaction5 = new Transaction();
        Transaction transaction6 = new Transaction();
        Transaction transaction7 = new Transaction();
        Transaction transaction8 = new Transaction();
        transaction1.add_item(1);
        transaction1.add_item(3);
        transaction1.add_item(4);

        transaction2.add_item(2);
        transaction2.add_item(3);
        transaction2.add_item(4);

        transaction3.add_item(1);
        transaction3.add_item(2);

        transaction4.add_item(1);
        transaction4.add_item(4);
        transaction4.add_item(3);
        transaction4.add_item(5);

        transaction5.add_item(6);
        transaction5.add_item(2);

        transaction6.add_item(1);
        transaction6.add_item(3);
        transaction6.add_item(4);
        transaction6.add_item(6);

        transaction7.add_item(2);
        transaction7.add_item(6);
        transaction7.add_item(5);

        transaction8.add_item(1);
        transaction8.add_item(6);
        transaction8.add_item(4);
        transaction8.add_item(3);
        transaction8.add_item(5);
//        transaction1.add_item(1);
//        transaction1.add_item(3);
//        transaction1.add_item(4);
//
//        transaction2.add_item(2);
//        transaction2.add_item(3);
//        transaction2.add_item(5);
//
//        transaction3.add_item(1);
//        transaction3.add_item(2);
//        transaction3.add_item(3);
//        transaction3.add_item(5);
//
//        transaction4.add_item(1);
//        transaction4.add_item(2);
//        transaction4.add_item(4);
//        transaction4.add_item(3);
//        transaction4.add_item(5);
//
//        transaction5.add_item(6);
//        transaction5.add_item(7);
//
//        transaction6.add_item(1);
//        transaction6.add_item(3);
//        transaction6.add_item(4);
//        transaction6.add_item(7);
//
//        transaction7.add_item(2);
//        transaction7.add_item(6);
//        transaction7.add_item(5);
//
//        transaction8.add_item(1);
//        transaction8.add_item(6);
//        transaction8.add_item(4);
//        transaction8.add_item(3);
//        transaction8.add_item(5);

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);
        transactions.add(transaction6);
        transactions.add(transaction7);
        transactions.add(transaction8);

        // for (Transaction transact : transactions) {
        // transact.print();
        // System.out.println();
        // }
        return transactions;
    }

    // single element - support
    private static List<Integer> GetFrequent_1Itemsets(
            List<Transaction> transactions, int support) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Transaction transaction : transactions) {
            List<Integer> itemList = transaction.getTransaction();
            for (Integer item : itemList) {
                Integer count = map.get(item);
                map.put(item, (count == null) ? 1 : count + 1);
            }
        }
        // Output
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // System.out.println("Key : " + entry.getKey() + " Value : "
        // + entry.getValue());
        // }
        List<Integer> frequentItemsets = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= support) {
                frequentItemsets.add(entry.getKey());
            }
        }
        // for (Integer item : frequentItemsets) {
        // System.out.print(item);
        // }
        return frequentItemsets;
    }

    public void GetMaximalItemsets(List<Transaction> transactions, int support) {
        List<Integer> items = Apriory.GetFrequent_1Itemsets(transactions,
                support);
        int itemCount = 3; // indicate count of elements in pair
        Boolean flag = true;
        while (flag) {// items.size() > 1) {
            // List<Transaction> combination = GenerareCandidates(items,
            // itemCount);
            List<Transaction> combination = printCombination(items,
                    items.size(), itemCount);
            RemoveNotFrequent(combination, transactions, support);
            flag = false;
        }
        // while (combination.size() > 1) {
        // List<string> Ck = GenerareCandidati(Lk, k);
        // Lk = RemoveNotFrequent(Ck);
        // SeeItemsets(Lk, k);
        // k++;
        // }
    }

    // return sets of elements(combination)
    @SuppressWarnings("null")
    private List<Transaction> GenerareCandidates(List<Integer> items,
                                                 int combinationLength) {
        // List<string> candidateSets = new List<string>();
        List<Transaction> candidateSets = new ArrayList<Transaction>();
        List<Integer> combination;
        Transaction itemList;
        for (Integer firstItem : items) {
            for (Integer secondItem : items) {
                if ((combinationLength == 2 && firstItem < secondItem)) {
                    // String FinalItem;
                    combination = new ArrayList<Integer>();
                    combination.add(firstItem);
                    combination.add(secondItem);
                    itemList = new Transaction();
                    // FinalItem = firstItem
                    // + secondItem.Substring(combinationLength - 2);
                    Boolean flag = true;
                    if (flag == true && !combination.isEmpty()) {
                        itemList.setTransaction(combination);
                        candidateSets.add(itemList);
                    }
                }
            }
        }
        // for (Transaction transact : candidateSets) {
        // transact.print();
        // System.out.println(" ");
        // }
        return candidateSets;
    }

    // ----------------------------
	/*
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination start & end ---> Staring and Ending indexes in arr[] index
	 * ---> Current index in data[] r ---> Size of a combination to be printed
	 */
    static void combinationUtil(List<Integer> arr, List<Integer> data,
                                int start, int end, int index, int r,
                                List<Transaction> candidateSets) {
        Transaction itemList;
        List<Integer> combination;
        // Current combination is ready to be printed, print it
        if (index == r) {
            combination = new ArrayList<Integer>();
            for (int j = 0; j < r; j++) {
                // System.out.print(data.get(j) + " ");
                combination.add(data.get(j));
            }
            System.out.println("");
            itemList = new Transaction();
            itemList.setTransaction(combination);
            candidateSets.add(itemList);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data.add(index, arr.get(i));
            combinationUtil(arr, data, i + 1, end, index + 1, r, candidateSets);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    private List<Transaction> printCombination(List<Integer> arr, int n, int r) {
        List<Transaction> candidateSets = new ArrayList<Transaction>();
        // A temporary array to store all combination one by one
        List<Integer> data = new ArrayList<Integer>();

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r, candidateSets);
        for (Transaction transact : candidateSets) {
            transact.print();
            System.out.println(" tran ");
        }
        return candidateSets;
    }
    // ---------------------------------

    // remove that pairs that has support< min_support
    private List<Transaction> RemoveNotFrequent(List<Transaction> combination,
                                                List<Transaction> transactions, int support) {
        List<Transaction> frequentCombination = new ArrayList<Transaction>();
        List<Integer> itemSet = new ArrayList<Integer>();
        Transaction itemList;
        for (Transaction transact : combination) {
            itemSet = transact.getTransaction();
            for (Integer item : itemSet) {
                System.out.print(item);
            }
            System.out.print(" ");
            System.out.println(ItemsetFrequency(itemSet, transactions));
            if (ItemsetFrequency(itemSet, transactions) >= support) {
                // frequentSets.Add(item);
                itemList = new Transaction();
                itemList.setTransaction(itemSet);
                frequentCombination.add(itemList);
            }
        }
        for (Transaction transact : frequentCombination) {
            transact.print();
            System.out.println(" ");
        }
        return frequentCombination;
    }
    // Return frequency of set
    private int ItemsetFrequency(List<Integer> itemSet,
                                 List<Transaction> transactions) {
        List<Integer> userTransaction = new ArrayList<Integer>();
        int frequency = 0;
        boolean index;
        for (Transaction transact : transactions) {
            userTransaction = transact.getTransaction();
            index = false;
            for (Integer item : itemSet) {
                index = userTransaction.contains(item);
                if (!index)
                    break;
            }
            if (index)
                frequency++;
        }
        return frequency;
    }
//    public static void main(String[] args) {
//        Apriory a = new Apriory();
//        int support = 4;
//        List<Transaction> transactions = a.AprioriAlgorithm();
//        // Apriory.GetFrequent_1Itemsets(transactions, support);
//        a.GetMaximalItemsets(transactions, support);
//    }
}