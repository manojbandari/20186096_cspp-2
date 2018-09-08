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
    public int[] set;
    public int size;
    private int[] elements = null;
    Set() {
        set = new int[10];
        size =0;
    }
    public int size() {
        return size;
    }
    public boolean contains(int element) {
        for(int i=0; i<size;i++) {
            if(set[i]==element) {
                return true;
            }
        }
        return false;
        /*for (int i = 0; i < this.elements.length; i++) {
        if (this.elements[i] == element)
            return true;
        }
        return false;*/
    }
    public void add(int[] value) {
        for(int i=0;i<value.length;i++) {
            if(size == set.length) {
                resize();
            }
            int count=0;
            for(int j=0;j<size;j++)
                if(value[i]==set[j]){
                    count+=1;
                }
            if(count==0){
                set[size++]=value[i];
            }
        }
    }
    public void add(int value) {
        if(size == set.length) {
                resize();
            }
            set[size++]=value;
    }
    public void resize() {
        set = Arrays.copyOf(set, size*2);
    }
    public int[] intersection(Set value) {
        /*Set set1 = new Set();
        for(int i=0;i<size;i++) {
            for(int j=0; j<value.size();i++) {
                if(set[i]==value[j]) {
                    set1.add(value[j]);
               }
            }
        }
        return set1;*/
    int members = 0;
    for (int i = 0; i < elements.length; i++) {
        if (value.contains(elements[i]))
            members++;
    }

    int[] newMembers = new int[members];
    int position = 0;
    for (int i = 0; i < elements.length; i++) {
        if (value.contains(elements[i]))
            newMembers[position++] = this.elements[i];

    }
    return newMembers;
    }


    public Set retainAll(int[] value) {
        Set set1 = new Set();
        if (value.length==0 || size==0) {
            return null;
        }
        for(int i=0;i<size;i++) {
            for(int j=0; j<value.length;i++) {
                if(set[i]==value[j]) {
                    set1.add(value[j]);
               }
            }
        }
        return set1;
    }
    public int[][] cartesianProduct(Set value) {
        int[][] matrix = new int[size][value.size()];
        if(value.size()==0 || size==0) {
            return null;
        }
        for(int k=0;k<size;k++) {
            for(int j=0;j<value.size();j++) {
                matrix[k][j]=set[k];
            }
        }
        return matrix;

    }
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + set[i] + ",";
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
        Set s = new Set();
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
              /*  case "intersection":
                s = new Set();
                Set t = new Set();
                int[] intArray = intArray(tokens[1]);
                s.add(intArray);
                int[] intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;*/
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
