package leetcode.heap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ReorganizeString767 {
 
	class Solution {
		static class Node implements Comparable<Node> {
			char ch;
			Integer count;
			Node(char ch, int count) {
				this.ch = ch;
				this.count = count;
			}
			@Override
			public int compareTo(Node o) {
				return -count.compareTo(o.count);
			}
		}

		public String reorganizeString(String s) {
            Map<Character, Integer> map = new HashMap<>(26); 
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                int count = map.getOrDefault(ch, 0);
                map.put(ch, count+1);
            }
            
            List<Node> list = map
                .keySet()
                .stream()
                .map( key -> new Node(key, map.get(key)))
                .collect(Collectors.toList());
            PriorityQueue<Node> pq = new PriorityQueue<Node>(list);
            StringBuilder result = new StringBuilder(s.length());
            Node prev = null;
            
            while(pq.size() > 0 || prev != null){
                if(pq.size() == 0 && prev != null){
                    return "";
                }
                
                Node node = pq.poll();
                result.append(node.ch);
                node.count--;
                
                if(prev != null){
                    pq.offer(prev);
                    prev = null;
                }
                
                if(node.count > 0){
                    prev = node;
                }
                
            }
            return result.toString();
		}
	}
}
