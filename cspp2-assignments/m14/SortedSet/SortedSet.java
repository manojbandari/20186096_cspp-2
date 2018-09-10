public class SortedSet extends Set {
	public void add(int value) {
		if(size()==this.set.length) {
			resize();
		}
		if(size()==0) {
			set[0]=value;
			size++;
		}
		else {
            int count = 0;
            for (int j = 0; j < size(); j++) {
                if (value == get(j)){
                    count += 1;
                }
            }
            if(count==0) {
            	int k;
            	for(k=0;k<size();k++) {
            		if(value < get(k)) {
            			for(int z=k;z<size();z++)
            				set[k+1]=set[k];

            		}
            		set[k]=value;
            		size++;
            		break;
            	}
            }
            
		}
	
}
	public void addAll(int[] value) {
        for(int i=0;i<value.length;i++){
        	add(value[i]);
        }
    }
	public int indexOf(int element) {
		for(int i=0;i<size();i++) {
			if(get(i)==element) {
				return i;
			}
		}
		return -1;
	}
	public Set subSet(int fromElement, int toElement){
		SortedSet subset= new SortedSet();
		int start= indexOf(fromElement);
		int end= indexOf(toElement);
		if(start==-1 || end==-1) {
			return subset; 
		}
		if(start < end) {
			for(int i=start;i<end;i++) {
				subset.add(set[i]);
			}
		}
		else {
			System.out.println("Invalid Arguemnts to Subset Exception");
		}
		return null;
	}
	public Set headSet(int toElement) {
		return subSet(get(0),toElement);
	}
	public int last(){
		if(size()==0) {
			return 0;
		}
		return set[size-1];
	}
}