package proj3;

import java.util.ArrayList;

public class Sorter {

    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx){
        Student pivot = pList.get(pToIdx);

        int i = pFromIdx;
        int j = pToIdx;

        while (i < j){

            while (pList.get(i).compareTo(pivot) < 0 && i < pToIdx) {
                i++;
            }

            while (pList.get(j).compareTo(pivot) >= 0 && j > pFromIdx) {
                j--;
            }

            if (j > i)
                swap(pList, i, j);
            }

        if (pList.get(i).compareTo(pivot) > 0)
        swap(pList, i, pList.indexOf(pivot));

        return i;
    }

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

    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2){
        System.out.println("Before Swapping item: "+ pIdx1 +" with item: "+ pIdx2);
        System.out.println(pList.toString());
        Student temp1 = pList.get(pIdx1);
        pList.set(pIdx1, pList.get(pIdx2));
        pList.set(pIdx2, temp1);





        System.out.println("After Swapping: ");
        System.out.println(pList.toString());
    }

}
