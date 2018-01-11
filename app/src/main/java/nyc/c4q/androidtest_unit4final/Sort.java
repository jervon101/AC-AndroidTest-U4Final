package nyc.c4q.androidtest_unit4final;

import java.util.List;

/**
 * Created by justiceo on 1/7/18.
 */

public class Sort {

    /**
     * Sorts a list using the selection sort algorithm.
     * See lecture on sorting: https://github.com/C4Q/AC-Android/tree/v2/DSA/sorting
     * <p>
     * When `isAscending` is true, the list is sorted in ascending alphabetical order from a to z,
     * otherwise it is sorted in descending order from z to a.
     *
     * @param list
     * @param isAscending
     */
    public static void selectionSort(List<String> list, boolean isAscending) {
        // TODO: Implement selection sort.
        // You may not use Collections.sort or its equivalent
        // You may not implement another sorting algorithm that is not "selection sort"
        // Tip: Try a version without ordering first.




        if (isAscending) {
            String[] arrBooks = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                arrBooks[i] = list.get(i);
            }

            int j;
            boolean is = true;
            String temp;

            while (is) {
                is = false;
                for (j = 0; j < arrBooks.length - 1; j++) {
                    if (arrBooks[j].compareToIgnoreCase(arrBooks[j + 1]) > 0) {

                        temp = arrBooks[j];


                        arrBooks[j] = arrBooks[j + 1];
                        arrBooks[j + 1] = temp;


                        is = true;
                    }
                }
            }

            list.clear();

            for (int i = 0; i < arrBooks.length; i++) {
                list.add(arrBooks[i]);
            }

        } else {

            String[] arrBooks = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                arrBooks[i] = list.get(i);
            }

            int j;
            boolean is = true;
            String temp;

            while (is) {
                is = false;
                for (j = arrBooks.length - 1; j < 0; j--) {
                    if (arrBooks[j].compareToIgnoreCase(arrBooks[j - 1]) > 0) {

                        temp = arrBooks[j];

                        arrBooks[j] = arrBooks[j - 1];
                        arrBooks[j - 1] = temp;

                        is = true;
                    }
                }
            }

            list.clear();

            for (int i = 0; i < arrBooks.length; i++) {
                list.add(arrBooks[i]);
            }
        }


    }
}
