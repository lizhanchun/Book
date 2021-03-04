package com.qf.book.dao.impl;

import com.qf.book.tools.C3P0Utils;

import java.util.*;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qf.book.entity.Book;
import com.qf.book.dao.IBookDao;

/**
 *book的dao层
 *@author MrLi
 */
 public class BookDaoImpl implements IBookDao {
	/**
	 * 使用c3p0连接池获取dbutils连接
	 */
	private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	/**
	 * 增加数据实现
	 * @param book
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insert(Book book) throws Exception {
		//准备sql语句
		String sql = "insert into book(bookName,price,author,flag) values (?,?,?,?)";
		return qr.update(sql ,book.getBookName(),book.getPrice(),book.getAuthor(),book.getFlag());
	}
	
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteById(Integer id) throws Exception {
		//准备sql语句
		String sql = "update book set flag=0 where id=?";
		return qr.update(sql, id);
	}

	/**
	 * 修改信息
	 * @param book
	 * @return
	 * @throws Exception
	 */
	@Override
	public int update(Book book) throws Exception {
		//准备sql语句
		String sql = "update book set bookName=?,price=?,author=?,flag=? where id=?";
		return qr.update(sql, book.getBookName(),book.getPrice(),book.getAuthor(),book.getFlag(),book.getId());
	}

	/**
	 * 根据主键查询数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Book queryById(Integer id) throws Exception {
		//准备sql语句
		String sql = "select id id,bookName bookName,price price,author author,flag flag from book where id=?";
		return qr.query(sql, new BeanHandler<Book>(Book.class),id);
	}

	
	/**
	 * 获得总记录数
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer count() throws Exception {
		String sql = "select count(id) from book where flag=1";
		return ((Long) qr.query(sql, new ScalarHandler<>())).intValue();
	}

	/**
	 * 获得分页后的数据
	 * @param startPage
	 * @param numPage
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Book> pageList(Integer startPage, Integer numPage) throws Exception {
		String sql = "select id id,bookName bookName,price price,author author,flag flag from book where flag=1 limit ? ,?";
		return qr.query(sql, new BeanListHandler<Book>(Book.class),startPage,numPage);
	}

 }
