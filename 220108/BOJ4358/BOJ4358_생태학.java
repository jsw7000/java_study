package day220108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BOJ4358_생태학 {
	public static void main(String[] args) throws IOException {

		Map<String,Integer> treeMap = new TreeMap<String,Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double count = 0; // 전체 나의 개수 카운
		while(true) {
			String str = br.readLine();
			if(str==null||str.equals("")) break;
			
			if(!treeMap.containsKey(str))
				treeMap.put(str, 1);
			else
				treeMap.put(str, treeMap.get(str)+1);
			
			count++;
			
		}
		
		StringBuilder sb = new StringBuilder();
		Set<String> sp = treeMap.keySet();
		
		ArrayList<String> list = new ArrayList<>();
		for(String str:sp) {
			list.add(str);
		}
		
		Collections.sort(list);
		
		for(String str : list) {
			
			int num = treeMap.get(str);
			
			String per = String.format("%.4f",(num/count)*100);
			sb.append(str+" "+per+"\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}
