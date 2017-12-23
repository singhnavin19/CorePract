package Collection;

public class Empl implements Comparable {
	String Ename, Esal;

	@Override
	public String toString() {
		return "Empl [" + (Ename != null ? "Ename=" + Ename + ", " : "") + (Esal != null ? "Esal=" + Esal : "") + "]";
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public String getEsal() {
		return Esal;
	}

	public void setEsal(String esal) {
		Esal = esal;
	}

	public Empl(String ename, String esal) {
		super();
		Ename = ename;
		Esal = esal;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Empl e = (Empl) o;

		return this.getEsal().compareTo(e.getEsal());
	}

}
