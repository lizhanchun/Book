package com.qf.book.entity;

import java.io.Serializable;
/**
 * book实体类
 * @author MrLi
 *
 */

public class Book implements Serializable{

	/**
	*图书编号
	*/	
	private Integer id;


	
	/**
	*书名
	*/
	private String bookName;
	
	/**
	*图书单价
	*/
	private Double price;
	
	/**
	*作者
	*/
	private String author;
	
	/**
	*是否删除
	*/
	private Boolean flag;

	
	/**
	*获得图书编号的方法
	*/
	public Integer getId() {
		return id;
	}
	/**
	*设置图书编号的方法
	*/
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	*获得书名的方法
	*/
	public String getBookName() {
		return bookName;
	}
	/**
	*设置书名的方法
	*/
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	*获得图书单价的方法
	*/
	public Double getPrice() {
		return price;
	}
	/**
	*设置图书单价的方法
	*/
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	*获得作者的方法
	*/
	public String getAuthor() {
		return author;
	}
	/**
	*设置作者的方法
	*/
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	*获得是否删除的方法
	*/
	public Boolean getFlag() {
		return flag;
	}
	/**
	*设置是否删除的方法
	*/
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}


	
}
