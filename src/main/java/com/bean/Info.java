package com.bean;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Info{
	private Integer bookId;
	private String bookCode;
	private String bookName;
	private Integer bookType;
	private String bookAuthor;
	private String publishPress;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date ublishDate;
	private Integer borrowed;
	private String createdBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date creationTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdatetime;
	private String typeName;


	public Info(){
		super();
	}
	public Info(Integer bookId,String bookCode,String bookName,Integer bookType,String bookAuthor,String publishPress,Date ublishDate,Integer borrowed,String createdBy,Date creationTime,Date lastUpdatetime) {
		super();
		this.bookId = bookId;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookAuthor = bookAuthor;
		this.publishPress = publishPress;
		this.ublishDate = ublishDate;
		this.borrowed = borrowed;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.lastUpdatetime = lastUpdatetime;

	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getBookId(){
		return bookId;
	}

	public void setBookId(Integer bookId){
		this.bookId = bookId;
	}
	public String getBookCode(){
		return bookCode;
	}

	public void setBookCode(String bookCode){
		this.bookCode = bookCode;
	}
	public String getBookName(){
		return bookName;
	}

	public void setBookName(String bookName){
		this.bookName = bookName;
	}
	public Integer getBookType(){
		return bookType;
	}

	public void setBookType(Integer bookType){
		this.bookType = bookType;
	}
	public String getBookAuthor(){
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor){
		this.bookAuthor = bookAuthor;
	}
	public String getPublishPress(){
		return publishPress;
	}

	public void setPublishPress(String publishPress){
		this.publishPress = publishPress;
	}
	public Date getUblishDate(){
		return ublishDate;
	}

	public void setUblishDate(Date ublishDate){
		this.ublishDate = ublishDate;
	}
	public Integer getBorrowed(){
		return borrowed;
	}

	public void setBorrowed(Integer borrowed){
		this.borrowed = borrowed;
	}
	public String getCreatedBy(){
		return createdBy;
	}

	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;
	}
	public Date getCreationTime(){
		return creationTime;
	}

	public void setCreationTime(Date creationTime){
		this.creationTime = creationTime;
	}
	public Date getLastUpdatetime(){
		return lastUpdatetime;
	}

	public void setLastUpdatetime(Date lastUpdatetime){
		this.lastUpdatetime = lastUpdatetime;
	}

}