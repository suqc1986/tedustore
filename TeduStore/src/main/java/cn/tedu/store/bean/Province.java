package cn.tedu.store.bean;

import java.io.Serializable;

public class Province implements Serializable {
	private Integer id;
	private String provinceCode;
	private String ProvinceName;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6143111154993923377L;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return ProvinceName;
	}
	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceCode=" + provinceCode + ", ProvinceName=" + ProvinceName + "]";
	}
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Province(Integer id, String provinceCode, String provinceName) {
		super();
		this.id = id;
		this.provinceCode = provinceCode;
		ProvinceName = provinceName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ProvinceName == null) ? 0 : ProvinceName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((provinceCode == null) ? 0 : provinceCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Province other = (Province) obj;
		if (ProvinceName == null) {
			if (other.ProvinceName != null)
				return false;
		} else if (!ProvinceName.equals(other.ProvinceName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (provinceCode == null) {
			if (other.provinceCode != null)
				return false;
		} else if (!provinceCode.equals(other.provinceCode))
			return false;
		return true;
	}
	
	
	
}
