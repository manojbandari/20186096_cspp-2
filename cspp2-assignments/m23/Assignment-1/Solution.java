import java.util.*;
import java.io.*;
class Plagarism {
	Plagarism() {
	}
	String DocToString(File doc) {
		String FileString = "";
		try {
			Scanner in = new Scanner(new FileReader(doc));
			StringBuilder sb = new StringBuilder();
			while (in.hasNext()) {
				sb.append(in.next());
				sb.append(" ");
			}
			in.close();
			FileString = sb.toString();
		} catch (FileNotFoundException ex) {
			System.out.println("no file");
		}
		return FileString;
	}
	String cleanDoc(String DocString) {
		String DocStr = DocString.toLowerCase();
		String  result = DocStr.replaceAll("[^a-zA-Z0-9\\s]", " ");
		// System.out.println(result);
		return result;
	}
	int Count(String keyWord, String[] list) {
		int count = 0;
		for (String word : list) {
			if (keyWord.equals(word))
				count++;
		}
		return count;
	}

	double EucledianNorm(HashMap<String, Integer> mappy) {
		double sum = 0;
		double result;
		for (String key : mappy.keySet()) {
			sum += Math.pow(mappy.get(key), 2);
		}
		return Math.sqrt(sum);
	}
	double dotProduct(HashMap<String, Integer> mappy1, HashMap<String, Integer> mappy2) {
		double Sum = 0;
		for (String word : mappy1.keySet()) {
			if (mappy2.containsKey(word)) {
				Sum += mappy1.get(word) * mappy2.get(word);
			}
		}
		return Sum;
	}
	double percentPlag(File doc1, File doc2) {
		// String DocString1 = cleanDoc(DocToString(doc1));
		// String DocString2 = cleanDoc(DocToString(doc2));
		String DocString1 = DocToString(doc1).toLowerCase();
		String DocString2 = DocToString(doc2).toLowerCase();
		// System.out.println(DocString1);
		String[] listStr1 = DocString1.split(" ");
		String[] listStr2 = DocString2.split(" ");
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		for (String word : listStr1) {
			map1.put(word, Count(word, listStr1));
		}
		for (String word : listStr2) {
			map2.put(word, Count(word, listStr2));
		}
		// for (String key : map2.keySet()) {
		// 	System.out.println(key + " " + map2.get(key));
		// }
		double EuNo1 = EucledianNorm(map1);
		double EuNo2 = EucledianNorm(map2);
		double Dot = dotProduct(map1, map2);
		double similarity = Dot / (EuNo1 * EuNo2);
		return similarity * 100;
	}

}
class Solution {
	public static void main(String[] args) {
		Plagarism PlagarismCheck = new Plagarism();
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		int len = listOfFiles.length;
		double[][] percent = new double[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				percent[i][j] = PlagarismCheck.percentPlag(listOfFiles[i], listOfFiles[j]);
			}
		}
		for (int i = 0; i < len ; i++ )
			System.out.print(" " + "\t" + listOfFiles[i].toString());
		System.out.println();
		for (int i = 0 ; i < len; i++) {
			System.out.print(listOfFiles[i] + " " + "\t");
			for (int j = 0; j < len; j++) {
				System.out.print((int)percent[i][j] + " " + "\t");
			}
			System.out.println("");

		}
	}
}