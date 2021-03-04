package com.qf.book.service;

import com.qf.book.entity.Book;
import com.qf.book.tools.PageTools;

import java.util.*;

/**
 * book业务逻辑层
 */
public interface IBookService {

	/**
	 * 新增方法
	 */
	public int add(Book book) throws Exception;

	/**
	 * 根据主键删除方法
	 */
	public int deleteById(Integer id) throws Exception;

	/**
	 * 修改方法
	 */
	public int update(Book book) throws Exception;

	/**
	 * 根据主键查询方法
	 */
    public Book findById(Integer id) throws Exception;

	/**
	 *分页查询数据
	 */
	public PageTools<Book> pageList(Integer curr, Integer num) throws Exception;
}
