package entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

public class ChuyenTau {
	private String maTau;
	private String gaDen;
	private ArrayList<Ga> tramDung;
	private LocalDate ngayDi;
	private LocalTime gioDi;
	private ArrayList<Toa> dsToa;

	public ChuyenTau(String maTau, String gaDen, ArrayList<Ga> tramDung, LocalDate ngayDi, LocalTime gioDi,
			ArrayList<Toa> dsToa) {
		super();
		this.setMaTau(maTau);
		this.setGaDen(gaDen);
		this.setTramDung(tramDung);
		this.setNgayDi(ngayDi);
		this.setGioDi(gioDi);
		this.setDsToa(dsToa);
	}

	public ChuyenTau(String maTau) {
		super();
		this.maTau = maTau;
	}

	public String getMaTau() {
		return maTau;
	}

	public void setMaTau(String maTau) {
		String ktMatau = "^TA\\d{3}$";
		if (maTau.matches(ktMatau))
			this.maTau = maTau;
		else
			throw new IllegalArgumentException("Mã tàu không hợp lệ. Mã tàu phải có định dạng 'TA' theo sau bởi 3 chữ số.");
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
		//Kiểm tra tồn tại
	}

	public ArrayList<Ga> getTramDung() {
		return tramDung;
	}

	public void setTramDung(ArrayList<Ga> tramDung) {
		this.tramDung = tramDung;
		//Kiểm tra tồn tại tất cả các ga
	}

	public LocalDate getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(LocalDate ngayDi) {
		if (ChronoUnit.DAYS.between(ngayDi, LocalDate.now()) > 3)
			this.ngayDi = ngayDi;
		else 
			throw new IllegalArgumentException("Ngày đi phải sau ngày hiện tại ít nhất 3 ngày");
	}

	public LocalTime getGioDi() {
		return gioDi;
	}

	public void setGioDi(LocalTime gioDi) {
		this.gioDi = gioDi;
	}

	public ArrayList<Toa> getDsToa() {
		return dsToa;
	}

	public void setDsToa(ArrayList<Toa> dsToa) {
		this.dsToa = dsToa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTau);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenTau other = (ChuyenTau) obj;
		return Objects.equals(maTau, other.maTau);
	}

	@Override
	public String toString() {
		return "ChuyenTau [maTau=" + maTau + ", gaDen=" + gaDen + ", tramDung=" + tramDung + ", ngayDi=" + ngayDi
				+ ", gioDi=" + gioDi + ", dsToa=" + dsToa + "]";
	}
	
}
