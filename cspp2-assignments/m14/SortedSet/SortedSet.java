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
            int k;
            int flag=0;
            if(count==0) {
            	for(k=0;k<size();k++) {
            		if(value < get(k)) {
            			for(int z=size()-1;z>=k;z--) {
            				set[z+1]=set[z];
            			}
            			set[k]=value;
            			size++;
            			flag=1;
            			break;
            		}
            	}
            	if(flag==0) {
            		set[k]=value;
            		size++;
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
		int i;
		int flag = 0;
		for(i=0;i<size();i++) {
			if(get(i)==element) {
				return i;
			}
			if(get(i)< element) {
					flag=i;
			}
		}
		return flag+1;
	}
	public Set subSet(int fromElement, int toElement){
		SortedSet subset= new SortedSet();
		int start= indexOf(fromElement);
		int end= indexOf(toElement);
		if(start > end) {
			System.out.println("Invalid Arguments to Subset Exception");
            return null;
		}
		if(get(toElement)==0) {
			return subset;
		}
		if(size()!=0) {
		 	if(start<end) {
				for(int i=start;i<end;i++) {
					subset.add(get(i));
				}
			return subset;
		}
		else {
			return null;
		}
	}
		System.out.println("Invalid Arguemnts to Subset Exception");
		return subset;
	}
	public Set headSet(int toElement) {
		return subSet(get(0),toElement);
	}
	public int last(){
		if (size() == 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
		return set[size-1];
	}
}