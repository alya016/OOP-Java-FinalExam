package course;

public class Mark {
	
	private double firstAttestation;
	private double secondAttestation;
	private double finalExam;
	private boolean isSetFirst;
	private boolean isSetSecond;
	private boolean isSetFinal;
	
	public Mark() {
		firstAttestation = 0.0;
		secondAttestation = 0.0;
		finalExam = 0.0;
		isSetFirst = false;
		isSetSecond = false;
		isSetFinal = false;
	}
	
	public Mark(double firstAttestation, double secondAttestation, double finalExam) {
		super();
		this.firstAttestation = firstAttestation;
		this.secondAttestation = secondAttestation;
		this.finalExam = finalExam;
		isSetFirst = true;
		isSetSecond = true;
		isSetFinal = true;
	}
	
	public double getMark() {
		return this.firstAttestation + this.secondAttestation + this.finalExam;
	}
	
	public String getGrade() {
		if (!isSetFirst || !isSetSecond || !isSetFinal) {
			return "-";
		} else if (firstAttestation + secondAttestation < 29.5) {
			return "F";
		} else if (finalExam < 19.5) {
			return "FX";
		} else {
			double mark = getMark();
			if (mark >= 94.5) {
				return "A";
			} else if (mark>=89.5) {
				return "A-";
			} else if (mark>=84.5) {
				return "B+"; 
			} else if (mark>=79.5) {
				return "B"; 
			} else if (mark>=74.5) {
				return "B-";
			} else if (mark>=69.5) {
				return "C+";
			} else if (mark>=64.5) {
				return "C"; 
			} else if (mark>=59.5) {
				return "C-"; 
			} else if (mark>=54.5) {
				return "D+"; 
			} else {
				return "D";
			}
		}
	}
	
	public double getGPA() {
		String grade = this.getGrade();
		if (grade.equals("-")) {
			return 0.0;
		} else if (grade.equals("A")) {
			return 4.0;
		} else if (grade.equals("A-")) {
			return 3.67;
		} else if (grade.equals("B+")) {
			return 3.33;
		} else if (grade.equals("B")) {
			return 3.0; 
		} else if (grade.equals("B-")) {
			return 2.67;
		} else if (grade.equals("C+")) {
			return 2.33;
		} else if (grade.equals("C")) {
			return 2.0;
		} else if (grade.equals("C-")) {
			return 1.67; 
		} else if (grade.equals("D+")) {
			return 1.33;
		} else if (grade.equals("D")) {
			return 1.0; 
		} else if (grade.equals("FX")) {
			return 0.5;
		} else {
			return 0;
		}
	}
	
	public double getFirstAttestation() {
		return firstAttestation;
	}
	public void setFirstAtt(double firstAttestation) {
		this.firstAttestation = firstAttestation;
	}
	public double getSecondAttestation() {
		return secondAttestation;
	}
	public void setSecondAtt(double secondAttestation) {
		this.secondAttestation = secondAttestation;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public void setFinalexam(double finalExam) {
		this.finalExam = finalExam;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(finalExam);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(firstAttestation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(secondAttestation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		if (Double.doubleToLongBits(finalExam) != Double.doubleToLongBits(other.finalExam))
			return false;
		if (Double.doubleToLongBits(firstAttestation) != Double.doubleToLongBits(other.firstAttestation))
			return false;
		if (Double.doubleToLongBits(secondAttestation) != Double.doubleToLongBits(other.secondAttestation))
			return false;
		return true;
	}
	
	public String toString() {
		return "Mark [firstAttestation=" + firstAttestation + ", secondAttestation=" + secondAttestation + ", finalExam=" + finalExam + "]";
	}
	
}