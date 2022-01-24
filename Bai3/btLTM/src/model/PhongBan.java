package model;

public class PhongBan {
	int IDPB;
	String TenPB;
	String MoTa;
	
	public PhongBan(int id, String ten , String mota) {
		this.IDPB = id;
		this.TenPB = ten;
		this.MoTa = mota;
	}

	public int getIDPB() {
		return IDPB;
	}

	public void setIDPB(int iDPB) {
		IDPB = iDPB;
	}

	public String getTenPB() {
		return TenPB;
	}

	public void setTenPB(String tenPB) {
		TenPB = tenPB;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
}
