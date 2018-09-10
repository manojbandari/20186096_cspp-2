public class SortedSet extends Set {
	/*SortedSet() {
        set = new int[10];
        size = 0;
    }*/
    public int[] set;
    public int size;
    SortedSet() {
    	set = new int[10];
        size = 0;
    }
	public void add(int value) {
		if(size==set.length) {
			resize();
		}
		for (int i = 0; i < size(); i++) {
            int count = 0;
            for (int j = 0; j < size(); j++)
                if (value == set[j]) {
                    count += 1;
                }
            if (count == 0) {
				if(!(value > set[i]))
				{	for(int j=i;j<size();j++) {
						set[j+1]=set[j];
					} 
					set[i]= value;
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
			if(set[i]==element) {
				return i;
			}
		}
		return -1;
	}
	public Set subSet(int fromElement, int toElement){
		SortedSet subset= new SortedSet();
		int start= indexOf(fromElement);
		int end= indexOf(toElement);
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
		return subSet(0,toElement);
	}
	public int last(){
		if(size()==0) {
			return 0;
		}
		return set[size-1];
	}
}