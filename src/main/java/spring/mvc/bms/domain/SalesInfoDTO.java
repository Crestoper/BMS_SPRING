package spring.mvc.bms.domain;

import java.sql.Date;

public class SalesInfoDTO {

	String salesNum;
	Date salesDay;
	String guestId;
	String isbn;
	String price;
	String salesstock;
	String salesCancel;
	String state;
	int closing;
	String title;

	String year;
	String month;
	String day;
	
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public Date getSalesDay() {
		return salesDay;
	}
	public void setSalesDay(Date salesDay) {
		this.salesDay = salesDay;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getClosing() {
		return closing;
	}
	public void setClosing(int closing) {
		this.closing = closing;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSalesNum() {
		return salesNum;
	}
	public void setSalesNum(String salesNum) {
		this.salesNum = salesNum;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSalesstock() {
		return salesstock;
	}
	public void setSalesstock(String salesstock) {
		this.salesstock = salesstock;
	}
	public String getSalesCancel() {
		return salesCancel;
	}
	public void setSalesCancel(String salesCancel) {
		this.salesCancel = salesCancel;
	}
	
	
}
