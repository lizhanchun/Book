package com.qf.book.dao;

import java.util.*;
import com.qf.book.entity.Book;

/**
 *book的dao层
 *@author MrLi
 */
public interface IBookDao {

	/*增加数据*/
	public int insert(Book book) throws Exception;

	/*根据id删除数据*/
	public int deleteById(Integer id) throws Exception;

	/*修改信息*/
	public int update(Book book) throws Exception;

	/*根据主键查询数据*/
	public Book queryById(Integer id) throws Exception;

	/*查询总记录数*/
	public Integer count() throws Exception;

	/*分页后的数据*/
    public List<Book> pageList(Integer startPage, Integer numPage) throws Exception;

}
