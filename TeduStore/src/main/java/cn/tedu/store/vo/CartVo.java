package cn.tedu.store.vo;

import java.io.Serializable;

public class CartVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3523014382529517404L;
	private Integer id;
	private Integer uid;
	private String GoodsId;
	private String image;
	private String title;
	private Double price;
	private Integer count;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getGoodsId() {
		return GoodsId;
	}
	public void setGoodsId(String goodsId) {
		GoodsId = goodsId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((GoodsId == null) ? 0 : GoodsId.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		CartVo other = (CartVo) obj;
		if (GoodsId == null) {
			if (other.GoodsId != null)
				return false;
		} else if (!GoodsId.equals(other.GoodsId))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "CartVo [id=" + id + ", uid=" + uid + ", GoodsId=" + GoodsId + ", image=" + image + ", title=" + title
				+ ", price=" + price + ", count=" + count + "]";
	}
	public CartVo(Integer id, Integer uid, String goodsId, String image, String title, Double price, Integer count) {
		super();
		this.id = id;
		this.uid = uid;
		GoodsId = goodsId;
		this.image = image;
		this.title = title;
		this.price = price;
		this.count = count;
	}
	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
