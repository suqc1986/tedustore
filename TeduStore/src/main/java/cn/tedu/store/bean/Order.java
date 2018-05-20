package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;

public class Order  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2685269118053114609L;
	private Integer id;
	private Date  tradetime;
	private Integer uid ;
	private String  createdUser;
	private Date createTime;
	private String  modifiedUser;
	private Date modifiedTime ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTradetime() {
		return tradetime;
	}
	public void setTradetime(Date tradetime) {
		this.tradetime = tradetime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
		result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
		result = prime * result + ((tradetime == null) ? 0 : tradetime.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
		Order other = (Order) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createdUser == null) {
			if (other.createdUser != null)
				return false;
		} else if (!createdUser.equals(other.createdUser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		if (modifiedUser == null) {
			if (other.modifiedUser != null)
				return false;
		} else if (!modifiedUser.equals(other.modifiedUser))
			return false;
		if (tradetime == null) {
			if (other.tradetime != null)
				return false;
		} else if (!tradetime.equals(other.tradetime))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", tradetime=" + tradetime + ", uid=" + uid + ", createdUser=" + createdUser
				+ ", createTime=" + createTime + ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime
				+ "]";
	}
	public Order(Integer id, Date tradetime, Integer uid, String createdUser, Date createTime, String modifiedUser,
			Date modifiedTime) {
		super();
		this.id = id;
		this.tradetime = tradetime;
		this.uid = uid;
		this.createdUser = createdUser;
		this.createTime = createTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
