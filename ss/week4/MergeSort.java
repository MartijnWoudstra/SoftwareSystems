package ss.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    public static <Elem extends Comparable<Elem>>
           void mergesort(List<Elem> list) {
    	   List<Elem> res = new ArrayList<Elem>();
    	   
    	if (list.size() > 1) {
    		int split = list.size() / 2;
    		List<Elem> fst, snd;
    		fst = list.subList(0, split);
    		snd = list.subList(split, list.size());
    		mergesort(fst);
    		mergesort(snd);
    		
    		int fi = 0;
    		int si = 0;
    		
    		while (fi < fst.size() && si < snd.size()) {
    			if (fst.get(fi).compareTo(snd.get(si)) < 0) {
    				res.add(fst.get(fi));
    				fi++;
    			} else {
    				res.add(snd.get(si));
    				si++;
    			}
    		}
    		if(fi < fst.size()) {
    			res.addAll(fst.subList(fi, fst.size()));
    		} else {
   				res.addAll(snd.subList(si, snd.size()));
  			}
    			
    		Collections.copy(list, res);
     	}
    }
}
