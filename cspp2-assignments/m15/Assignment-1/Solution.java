// @author : manojbandari
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Exception for signaling invalid position errors.
 */
class InvalidPositionException extends Exception {
    
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return "Invalid Position Exception";
    }
}

/**
 * Class for solution.
 */
class Solution {
    public final int TEMP=10;
    /**
     * { var_description }.
     */
    private int[] list;
    /**
     * { var_description }.
     */
    private int size;
    
    /**
     * Constructs the object.
     */
    Solution() {
        list = new int[TEMP];
        size = 0;
    }
    
    /**
     * { function_description }.
     *
     * @param      element  The element
     */
    public void add(final int element) {
        if (size == list.length) {
            resize();
        }
        list[size++] = element;
    }
    
    /**
     * { function_description }.
     *
     * @param      index    The index
     * @param      element  The element
     */
    public void add(final int index, final int element) {
        int i;
        for (i = size - 1; i > index; i++) {
            list[i + 1] = list[i];
        }
        list[i] = element;
        size++;
    }
    
    /**
     * { function_description }.
     */
    public void resize() {
        list = Arrays.copyOf(list, size * 2);
    }
    
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    
    /**
     * { function_description }.
     */
    public void clear() {
        size = 0;
        list = new int[10];
    }
    /**
     * { function_description }.
     *
     * @param      element  The element
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int element) {
        return indexOf(element) != -1;
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        return list[index];
    }
    /**
     * Searches for the first match.
     *
     * @param      element  The element
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int element) {
        for (int i = 0; i < size; i++) {
            if (list[i] == element) {
                return i;
            }
        }
        return -1;
    }
    /**
     * { function_description }.
     *
     * @param      index                     The index
     *
     * @throws     InvalidPositionException  { exception_description }
     */
    public void remove(final int index) throws InvalidPositionException {
        /*int m = indexOf(element);*/
        if (index < 0 && index > size) {
            throw new InvalidPositionException();
        }
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }
    /**
     * Adds all.
     *
     * @param      arr   The arr
     */
    public void addAll(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }
    /**
     * Removes all.
     *
     * @param      arr                       The arr
     *
     * @throws     InvalidPositionException  { exception_description }
     */
    public void removeAll(final int[] arr) throws InvalidPositionException {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i] == list[j]) {
                    remove(i);
                    j--;
                }
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      element  The element
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final int element) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] == element) {
                count++;
            }
        }
        return count;
    }
    /**
     * { function_description }.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final Solution other) {
        if (size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (list[i] != other.list[i]) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for ( i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
    /**
     * { function_description }.
     *
     * @param      start                      The start
     * @param      end                        The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     IndexOutOfBoundsException  { exception_description }
     */
    public Solution subList(final int start, final int end) throws IndexOutOfBoundsException {
        if (start < 0 || end < 0 || start > end || size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Solution newlist = new Solution();
        for (int i = start; i < end; i++) {
            newlist.add(list[i]);
        }
        return newlist;
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Solution l = new Solution();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "add":
                String[] a = tokens[1].split(",");
                if (a.length == 2) {
                    l.add(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
                } else if (a.length == 1) {
                    l.add(Integer.parseInt(a[0]));
                }
                break;
            case "size":
                System.out.println(l.size());
                break;
            case "remove":
                try {
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Position Exception");
                }
                break;
            case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                if (tokens.length == 2) {
                    System.out.println(l.contains(Integer.parseInt(tokens[1])));
                }
                break;
            case "indexOf":
                if (tokens.length == 2) {
                    System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                }
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] b = tokens[1].split(",");
                    int[] temp = new int[b.length];
                    for (int i = 0; i < b.length; i++) {
                        temp[i] = Integer.parseInt(b[i]);
                    }
                    l.addAll(temp);
                }
                break;
            case "removeAll":
                try {
                    if (tokens.length == 2) {
                        String[] c = tokens[1].split(",");
                        int[] temp = new int[c.length];
                        for (int i = 0; i < c.length; i++) {
                            temp[i] = Integer.parseInt(c[i]);
                        }
                        l.removeAll(temp);
                    }
                } catch (Exception e1) {
                    System.out.println("InvalidPositionException");
                }
                break;
            case "count":
                if (tokens.length == 2) {
                    System.out.println(l.count(Integer.parseInt(tokens[1])));
                }
                break;
            case "subList":
                if (tokens.length != 2) {
                    break;
                }
                String[] d = tokens[1].split(",");
                try {
                    System.out.println(l.subList(Integer.parseInt(d[0]), Integer.parseInt(d[1])));
                } catch (Exception e3) {
                    System.out.println("Index Out of Bounds Exception");
                }
                break;
            case "equals":
                if (tokens.length == 2) {
                    String[] lt = tokens[1].split(",");
                    Solution l2 = new Solution();
                    for (int k = 0; k < lt.length; k++) {
                        l2.add(Integer.parseInt(lt[k]));
                    }
                    System.out.println(l.equals(l2));
                }
                break;
            case "print":
                System.out.println(l);
                break;
            case "clear":
                l.clear();
                break;
            default :
                break;
            }
        }
    }
}