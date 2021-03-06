import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : manojbandari
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
    */
    protected int[] set;
    protected int size;

    /**
     * Constructs the object.
     */
    Set() {
        set = new int[10];
        size = 0;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * { function_description }
     *
     * @param      element  The element
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (set[i] == element) {
                return true;
            }
        }
        return false;
    }
    /**
     * { function_description }
     *
     * @param      value  The value
     */
    /**
     * { function_description }
     *
     * @param      value  The value
     */
    public void add(int value) {
        if (size == set.length) {
            resize();
        }
        set[size++] = value;
    }
    /**
     * { function_description }
     */
    public void resize() {
        set = Arrays.copyOf(set, size * 2);
    }
    /*public Set intersection(Set value) {
        Set set1 = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < value.size(); j++) {
                if (set[i] == value.set[j]) {
                    set1.add(set[i]);
                }
            }
        }
        return set1 };*/
    // return this.retainAll(value.set);

    /**
     * { function_description }.
     *
     * @param      value  The value
     *
     * @return     { description_of_the_return_value }
     */
    /*public Set retainAll(int[] value) {
        Set set1 = new Set();
        if (value.length == 0 || size == 0) {
            return set1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < value.length; j++) {
                if (set[i] == value[j]) {
                    set1.add(value[j]);
                }
            }
        }
        return set1;
    }*/
    
    /**
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(int index) {
        return set[index];
    }
    /*public int[][] cartesianProduct(Set value) {
        int[][] matrix = new int[size * value.size][2];
        if (value.size == 0 || size == 0) {
            return null;
        }
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < value.size; j++) {
                    matrix[k][0] = set[i];
                    matrix[k][1] = value.get(j);
                    k++;

            }
        }
        return matrix;
    }*/

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + set[i] + ", ";
        }
        str = str + set[i] + "}";
        return str;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
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
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
                s.add(Integer.parseInt(tokens[1]));
                break;
            case "addAll" :
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;

            /*case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;*/
            case "subSet":
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
                break;
            case "headSet":
                if (tokens.length != 2) {
                    break;
                }
                int[] obj = s.headSet(Integer.parseInt(tokens[1]));
                if (obj != null) {
                    System.out.println(Arrays.toString(obj).replace("[",
                        "{").replace("]", "}"));
                }
                break;
            case "last":
                if (tokens.length != 1) {
                    break;
                }
                int temp = s.last();
                System.out.println(temp);
                break;
            /*case "subSet":
                String[] elements = tokens[1].split(",");
                Set m = s.subSet(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
                if (m != null) {
                    System.out.println(m);
                }
                break;
            case "headSet":
                Set n = s.headSet(Integer.parseInt(tokens[1]));
                if (n != null) {
                    System.out.println(n);
                } else {
                    System.out.println("{}");
                }
                break;
            case "last":
                System.out.println(s.last());
                break;*/
            default:
                break;

            }
        }
    }
}

