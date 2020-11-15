package proj3;

import java.util.ArrayList;

public class Searcher {
    public static int search(ArrayList<Student> pList, String pKey){

        if (pList.size() == 1){
            if (pList.get(0).getLastName().equals(pKey))
                return 0;
            else
                return -1;
        }

            int l = 0, r = pList.size() - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;

                // Check if x is present at mid
                if (pList.get(m).getLastName().compareTo(pKey) == 0)
                    return m;

                // If x greater, ignore left half
                if (pList.get(m).getLastName().compareTo(pKey) > 0)
                    l = m + 1;

                    // If x is smaller, ignore right half
                else
                    r = m - 1;
            }

            // if we reach here, then element was
            // not present
            return -1;


        }



}
