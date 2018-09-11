import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sorted set.
 */
 class Set {
    /**
     * This constant is used to create an array
     * with the initial capacity.
     */
    public static final int TEN = 10;

    /**
     * holds the elemtns in this Set array.
     */
    private int[] set;
    /**
     * indicates the number of elememnts of this set.
     */
    private int size;

    /**
     * Default constructor to create an array with the szie 10.
     */
    Set() {
        /**.
         * { item_description }
         */
        set = new int[TEN];
        size = 0;
    }
    /**.
     * { item_description }
     */
    /**
     * add the item to this set at the last.
     * If the set is full, resize the set to double
     * the size of the current set.
     * @param item to be inserted at the last.
     */
    // public void add(final int item) {
    //     if (size == set.length) {
    //         resize();
    //     }
    //     if (!contains(item)) {
    //         set[size++] = item;
    //     }
    // }
    public void add(final int item) {
        /**.
         * { item_description }
         */
        if (!contains(item)) {
            set[size++] = item;
        }
        sort(set);
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int[] get() {
    /**.
     * { item_description }
     */
        return set;
    }
    /**
     * resize the set by double, when it is full.
     */
    public void resize() {
        set = Arrays.copyOf(set, size * 2);
    }

    /**
     * add all elements of the array to this Set.
     * @param newArray as newArray to be added in this set,
     *            if the element is not present in this set.
     */
    public void add(final int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }

    /**
     * Finds the intersection of the two sets.
     * @param  newset as set 2.
     * @return the result that contains the common
     * elements of the two sets.
     */
    public Set intersection(final Set newset) {
        Set s1 = new Set();
        for (int i = 0; i < size; i++) {
            if (newset.contains(get(i))) {
                s1.add(get(i));
            }
        }
        return s1;
    }
    /**
     * retains all the elements from the set.
     * @param  newArray is a form of set2.
     * @return the set that contains all the elements
     * of this set.
     */
    public Set retainAll(final int[] newArray) {
        /**.
         * { var_description }
         */
        Set s2 = new Set();
        for (int item : newArray) {
            s2.add(item);
        }
        return intersection(s2);
    }
    /**.
     * { function_description }
     *
     * @param      array  The array
     */
    public void sort(final int[] array) {
        /**.
         * { var_description }
         */
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * This finds out the cartesian product of two sets.
     * @param  newset as a Set 2.
     * @return the cartesian product in the form of 2D array.
     */
    public int[][] cartesianProduct(final Set newset) {
        int[][] a1 = new int[this.size() * newset.size()][2];
        int k = -1;
        if (this.size() == 0 || newset.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < newset.size(); j++) {
                a1[++k][0] = this.get(i);
                a1[k][1] = newset.get(j);
            }
        }
        return a1;
    }

    /**
     * This methods finds out the number of elements in the set.
     * @return the integer value indicates the number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * This method finds out the elements
     * at a particular index.
     * @param  index to return the element at this index.
     * @return the element at this index, otherwise return -1.
     */
    public int get(final int index) {
        if (index < 0 || index >= size()) {
            return -1;
        } else {
            return set[index];
        }
    }

    /**
     * String version of the object.
     * @return string.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        for (int i = 0; i < size - 1; i++) {
            str = str + set[i] + ", ";
        } return str + set[size - 1] + "}";
    }
    /**
     * returns true if this set contains the item.
     * @param  item as a parameter to be checked in the set.
     * @return      true if the item present in the set,
     *                   otherwise false.
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Finds the index of the item in this set.
     * @param  item to be find in this set.
     * @return the index if the item is found in this set,
     * otherwise false.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
/**.
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**
     * sort function.
     *
     * @param      array  The array
     */
    /**
     * add function.
     *
     * @param      item  The item
     */
    /**
     * subset.
     *
     * { function_description }
     *
     * @param      start      The start
     * @param      end        The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    public int[] subSet(final int start, final int end) throws Exception {
        /**.
         * { item_description }
         */
        if (start > end) {
            //System.out.println("Invalid Arguments to Subset Exception");
            throw new Exception("Invalid Arguments to Subset Exception");
        }
        int[] result = new int[size()];
        int k = 0;
        for (int i = 0; i < size(); i++) {
            if (super.get()[i] >= start) {
                for (int j = i; j < size(); j++) {
                    if (super.get()[j] < end) {
                        result[k++] = super.get()[i];
                    }
                    break;
                }
            }
        }
        return Arrays.copyOf(result, k);
    }
    /**.
     * { function_description }
     *
     * @param      end        The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    public int[] headSet(final int end) throws Exception {
        /**.
         * { var_description }
         */
        int[] result = new int[size()];
        int temp = 0;
        for (int i = 0; i < size(); i++) {
            if (super.get()[i] < end) {
                result[i] = super.get()[i];
                temp++;
            }
        }
        if (temp == 0) {
            throw new Exception("Set Empty Exception");
       }
        return Arrays.copyOf(result, temp);
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    public int last() throws Exception {
        if (size() == 0) {
            //System.out.println("Set Empty Exception");
            throw new Exception("Set Empty Exception");
        }
        return super.get()[size() - 1];
    }
    /**
     * Adds all.
     *
     * @param      element  The element
     */
    public void addAll(final int[] element) {
        for (int i : element) {
            this.add(i);
        }
    }
}
/**.
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        /**.
         * { var_description }
         */
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**.
     * { function_description }
     *
     * @param      args       The arguments
     *
     * @throws     Exception  { exception_description }
     */
    public static void main(final String[] args) throws Exception {
        // instantiate this set
        SortedSet s = new SortedSet();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new SortedSet();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new SortedSet();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            case "subSet":
            try {
                if (tokens.length != 2) {
                    break;
                }
                String[] arrstring3 = tokens[1].split(",");
                int[] object = s.subSet(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                if (object != null) {
                    System.out.println(Arrays.toString(object).replace("[",
                        "{").replace("]", "}"));
                }
                } catch (Exception e) {
                    System.out.println("Invalid Arguments to Subset Exception");
                }
                break;
            case "headSet":
            try {
                if (tokens.length != 2) {
                    break;
                }
                int[] obj = s.headSet(Integer.parseInt(tokens[1]));
                if (obj != null) {
                    System.out.println(Arrays.toString(obj).replace("[",
                        "{").replace("]", "}"));
                }
                } catch (Exception e) {
                    System.out.println("Set Empty Exception");
                }
                break;
            case "last":
            try {

                if (tokens.length != 1) {
                    break;
                }
                int temp = s.last();
                System.out.println(temp);
                } catch (Exception e) {

                    System.out.println("Set Empty Exception");
                }
                break;
            case "addAll":
                int[] intArr = intArray(tokens[1]);
                if (intArr.length == 1) {
                    s.add(intArr[0]);
                } else {
                    s.add(intArr);
                }
                break;
            default:
                break;
            }
        }
    }
}
