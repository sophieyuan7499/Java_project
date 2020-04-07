package singapore.model;

import java.math.BigDecimal;

public class hotels {
	private  int id;
	private String name;
	private int host_id;
	private String host_name;
	private String nei_group;//新加坡地区
	private String neigh; //具体地点
	private BigDecimal  latitude; //纬度
	private BigDecimal  longitude; //经度
	private String room_type;
	private double price;
	private int min_nights; //最晚住宿
	private int comments; //评论数
	private String last_view;  //最后评论时间
	private float reviews_per_month;  //回头率
	private int nums; //寄宿目录中的总房间或房子
	private int ava_365;
	
	
	
	
	public hotels() {
		super();
	}

	public hotels(int id, String name, int host_id, String host_name, String nei_group, String neigh,
			BigDecimal latitude, BigDecimal longitude, String room_type, double price, int min_nights, int comments,
			String last_view, float reviews_per_month, int nums, int ava_365) {
		super();
		this.id = id;
		this.name = name;
		this.host_id = host_id;
		this.host_name = host_name;
		this.nei_group = nei_group;
		this.neigh = neigh;
		this.latitude = latitude;
		this.longitude = longitude;
		this.room_type = room_type;
		this.price = price;
		this.min_nights = min_nights;
		this.comments = comments;
		this.last_view = last_view;
		this.reviews_per_month = reviews_per_month;
		this.nums = nums;
		this.ava_365 = ava_365;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHost_id() {
		return host_id;
	}
	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getNei_group() {
		return nei_group;
	}
	public void setNei_group(String nei_group) {
		this.nei_group = nei_group;
	}
	public String getNeigh() {
		return neigh;
	}
	public void setNeigh(String neigh) {
		this.neigh = neigh;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMin_nights() {
		return min_nights;
	}
	public void setMin_nights(int min_nights) {
		this.min_nights = min_nights;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public String getLast_view() {
		return last_view;
	}
	public void setLast_view(String last_view) {
		this.last_view = last_view;
	}
	public float getReviews_per_month() {
		return reviews_per_month;
	}
	public void setReviews_per_month(float reviews_per_month) {
		this.reviews_per_month = reviews_per_month;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public int getAva_365() {
		return ava_365;
	}
	public void setAva_365(int ava_365) {
		this.ava_365 = ava_365;
	}

	@Override
	public String toString() {
		return "hotels [id=" + id + ", name=" + name + ", host_id=" + host_id + ", host_name=" + host_name
				+ ", nei_group=" + nei_group + ", neigh=" + neigh + ", latitude=" + latitude + ", longitude="
				+ longitude + ", room_type=" + room_type + ", price=" + price + ", min_nights=" + min_nights
				+ ", comments=" + comments + ", last_view=" + last_view + ", reviews_per_month=" + reviews_per_month
				+ ", nums=" + nums + ", ava_365=" + ava_365 + "]";
	}
	
	
	
	
}
