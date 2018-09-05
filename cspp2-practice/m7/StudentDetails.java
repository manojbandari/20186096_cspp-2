class StudentDetails {
	String student;
	String rollno;
	double m1;
	double m2;
	double m3;
	public StudentDetails(String student, String rollno, double m1, double m2, double m3) {
		this.student = student;
		this.rollno = rollno;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
	public double GPA() {
		return (m1+m2+m3)/3;
	}
	public static void main(String[] args) {
		StudentDetails s1= new StudentDetails("manoj","96",9.3,9.4,9.5);
		System.out.println(s1.GPA());
		StudentDetails s2= new StudentDetails("kumar","95",9.7,9.6,9.5);
		System.out.println(s2.GPA());
		StudentDetails s3= new StudentDetails("bandari","97",9.2,9.9,9.7);
		System.out.println(s3.GPA());

		
	}
}