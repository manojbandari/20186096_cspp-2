import java.util.*;
import java.io.*;
class InvalidPositionException extends Exception {
	public String toString() {
		return "Invalid Position Exception";
	}
}
class Solution {
	private int[] list;
	private int size;
	Solution() {
		list = new int[10];
		size = 0;
	}
	public void add(int element) {
		if (size == list.length) {
			resize();
		}
		list[size++] = element;
	}
	public void add(int index, int element) {
		int i;
		for (i = size - 1; i > index; i++) {
			list[i + 1] = list[i];
		}
		list[i] = element;
		size++;
	}
	public void resize() {
		list = Arrays.copyOf(list, size * 2);
	}
	public int size() {
		return size;
	}
	public void clear() {
		size = 0;
		list = new int[10];
	}
	public boolean contains(int element) {
		return indexOf(element) != -1;
	}
	public int get(int index) {
		if (index < 0 || index > size) {
			return -1;
		}
		return list[index];
	}
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (list[i] == element) {
				return i;
			}
		}
		return -1;
	}
	public void remove(int index) throws InvalidPositionException {
		/*int m = indexOf(element);*/
		if(index<0 && index>size) {
			throw new InvalidPositionException();
		}
		for (int i = index; i < size; i++) {
			list[i] = list[i + 1];
		}
		size--;
	}
	public void addAll(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			add(arr[i]);
		}
	}
	public void removeAll(int[] arr) throws InvalidPositionException {
		for (int i = 0; i < arr.length; i++) {
			remove(indexOf(arr[i]));
		}
	}
	public int count(int element) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (list[i] == element) {
				count++;
			}
		}
		return count;
	}
	public boolean equals(List other) {
		return this.toString().equals(other.toString());
	}
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
	public Solution subList(int start, int end) throws IndexOutOfBoundsException{
		if(start<0||end<0||start>end||size==0) {
			throw new IndexOutOfBoundsException();
		}
		Solution newlist = new Solution();
		for (int i = start; i < end; i++) {
			newlist.add(list[i]);
		}
		return newlist;
	}
	public static void main(String[] args) {
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
				}
				catch(Exception e){
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
			}
			catch(Exception e1) {
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
					System.out.println("Index Out Of Bounds Exception");
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
			case "clear":
				l.clear();
				break;
			default :
				break;
			}
		}
	}
}