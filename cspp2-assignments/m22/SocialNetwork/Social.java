import java.util.*;
class User {
	private String userName;
	private ArrayList<String> friends;
	User(String userName1,ArrayList<String> friends1) {
		userName=userName1;
		friends=friends1;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName1) {
		this.userName=userName1;
	}
	public ArrayList<String> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<String> friends1) {
		this.friends=friends1;
	}
	public String toString(){
		return userName+":"+friends;
	}
	public static Comparator<User>  username= new Comparator<User>() {
		public int compare(User s1, User s2) {
	   	String userName1 = s1.getUserName();
	  	String userName2 = s2.getUserName();

		return userName1.compareTo(userName2);
		
	}};
}
class Network {
	ArrayList<User> users;
	Network() {
		users= new ArrayList<User>();
	}
	public void addUser(String name,User user) {
		//users.add(user);
		for(User a: users) {
			if(name.equals(a.getUserName())) {
				return;
			}
		}
		users.add(user);
		//System.out.println(users);
		/*System.out.println(users.size());
		if(users.size()==0) {
			users.add(user);
		}
		for(int i=0;i<users.size();i++) {
			if(!(users.get(i).getUserName().equals(user)) {
				return ;
			}
			else {
			users.add(user);
			}
		}
		System.out.println(users);*/
	}
	public void addConnection(String user,String newFriend) {
		/*for(User a: users) {
			if(newFriend.equals(a.getUserName())) {
				return;
			}
		}*/
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getUserName().equals(newFriend)) {
				for(int index=0;index<users.size();index++)
				if(users.get(index).getUserName().equals(user)) {
					ArrayList<String> update= new ArrayList<String>();
					update=users.get(index).getFriends();
					update.add(newFriend);
					users.get(index).setFriends(update);
					return;
				}
			}
		}
		System.out.println("Not a user in Network");
	

		/*for(int i=0;i<size;i++)
			if(users.get(i).getUserName().equals(user)) {
				//String[] oldFriends=users[i].getFriends();
				//String[] newFriends=user.getFriends();
				//String[] updatedFriends=new String[100];
				int j=0;
				while(j<) {
					updatedFriends[j]=oldFriends[j];
					j++;
					number++;
				}
				int k=0;
				int m=oldFriends.length;
				while(k<newFriends.length) {
					updatedFriends[m++]=newFriends[k];
					k++;
					number++;
				}
				users[i].setFriends(updatedFriends);
				users[i].setSize(number);
			}*/
}
	public void getConnections(String name) {
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getUserName().equals(name)) {
				System.out.println(users.get(i).getFriends());
				return;
			}
		}
		System.out.println("Not a user in Network");
	}
	public void commonConnection(String name1,String name2) {
		//System.out.println("manoj");
		ArrayList<String> update= new ArrayList<String>();
		ArrayList<String> friends1= new ArrayList<String>();
		ArrayList<String> friends2= new ArrayList<String>();
			for(int i=0;i<users.size();i++) {
				if(users.get(i).getUserName().equals(name1)) {
					friends1=users.get(i).getFriends();
				}
				if(users.get(i).getUserName().equals(name2)) {
					friends2=users.get(i).getFriends();
				}
			}
			for (String s2 : friends2) {
        		for (String s1 : friends1) {
           			if(s2.contains(s1)){
               			update.add(s2);
           			}
        		}
    		}
			
			String temp="[";
			for(String m : update) {
				temp=temp+m+", ";
			}
				System.out.println(temp.substring(0,temp.length()-2)+"]");
	}
	public void print() {
		Collections.sort(users, User.username);
		String temp="";
		for(User user : users) {
			temp=temp+user.getUserName()+": ";
			temp+= user.getFriends()+", ";
		}
		System.out.println(temp.substring(0,temp.length()-2));
	}
		
}
class Social {

	public static void main(String[] args) {
		Network n = new Network();
		Scanner s= new Scanner(System.in);
		while(s.hasNext()) {
			String[] line= s.nextLine().split(" ");
			switch(line[0]) {
				case "Create":
				int i=0;
				while(i<Integer.parseInt(line[1])) {
					String[] token= s.nextLine().split(" is connected to ");
					String[] fl=token[1].replace(".","").split(", ");
					ArrayList<String> lis=new ArrayList(Arrays.asList(fl));
					n.addUser(token[0],new User(token[0],lis));
					i++;
				}
				break;
				case "addConnections":
					n.addConnection(line[1],line[2]); 
				break;
				case "getConnections":
					n.getConnections(line[1]);
				break;
				case "CommonConnections":
					n.commonConnection(line[1],line[2]);
				break;
				case "Network":
				n.print();
				break;
		}
		}
	}
}