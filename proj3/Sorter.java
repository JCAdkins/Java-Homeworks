package proj3;

import java.util.ArrayList;

public class Sorter {

    // Sort array and then split the array at point i > j
    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx){
        // Set pivot
        Student pivot = pList.get(pToIdx);

        int i = pFromIdx;
        int j = pToIdx;


        while (i < j){

            // Sort lastName's less than pivot to the low side
            while (pList.get(i).compareTo(pivot) < 0 && i < pToIdx) {
                i++;
            }

            // Sort lastName's greater than pivot to the high side
            while (pList.get(j).compareTo(pivot) >= 0 && j > pFromIdx) {
                j--;
            }

            // Swap elements
            if (j > i)
                swap(pList, i, j);

            }


        // Need to switch i and pivot if i > pivot
        if (pList.get(i).compareTo(pivot) > 0)
        swap(pList, i, pList.indexOf(pivot));

        return i;
    }

    // Recursive quickSort method
    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx){
        if (pFromIdx >= pToIdx)
            return;

        int partition = partition(pList, pFromIdx, pToIdx);

        quickSort(pList, pFromIdx, partition-1);
        quickSort(pList, partition + 1, pToIdx);
    }

    public static void sort(ArrayList<Student> pList){
        quickSort(pList, 0, pList.size() - 1);
    }

    // Swap element at pIdx1 with element at pIdx2
    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2){
        Student temp1 = pList.get(pIdx1);
        pList.set(pIdx1, pList.get(pIdx2));
        pList.set(pIdx2, temp1);
    }

}
