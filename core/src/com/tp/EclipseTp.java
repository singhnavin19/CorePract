package com.tp;

public class EclipseTp {

	int i;
	int j;
	String K;

	public EclipseTp(int i, int j, String k) {
		super();
		this.i = i;
		this.j = j;
		K = k;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public String getK() {
		return K;
	}

	public void setK(String k) {
		K = k;
	}

	@Override
	public String toString() {
		return "EclipseTp [i=" + i + ", j=" + j + ", " + (K != null ? "K=" + K : "") + "]";
	}

}
