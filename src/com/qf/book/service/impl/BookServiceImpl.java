package com.qf.book.service.impl;

import java.util.*;

import com.qf.book.dao.IBookDao;
import com.qf.book.dao.impl.BookDaoImpl;
import com.qf.book.entity.Book;
import com.qf.book.service.IBookService;
import com.qf.book.tools.PageTools;

/**
 * book业务逻辑层
 */
public class BookServiceImpl implements IBookService {
	//导入dao层接口
	private IBookDao bookDao = new BookDaoImpl();	

	/**
	 * 新增方法
	 * @param  book
	 * @return
	 * @throws Exception
	 */
	@Override
	public int add(Book book) throws Exception {
		return bookDao.insert(book);
	}

	/**
	 * 根据主键删除方法
	 * @param  id
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteById(Integer id) throws Exception {
		return bookDao.deleteById(id);
	}

	/**
	 * 修改方法
	 * @param  book
	 * @return
	 * @throws Exception
	 */
	@Override
	public int update(Book book) throws Exception {
		return bookDao.update(book);
	}


	/**
	 * 根据主键查询方法
	 * @param  id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Book findById(Integer id) throws Exception {
		return bookDao.queryById(id);
	}

	
	/**
	 * 分页数据
	 * @param curr 页码
	 * @param  num  每页展示条数
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageTools<Book> pageList(Integer curr, Integer num) throws Exception {
		//创建分页工具类对象
		PageTools<Book> pageTools = new PageTools<>();

		//将页码存工具类中
		pageTools.setCurrPage(curr);
		//将每页展示记录存工具类中
		pageTools.setNumPage(num);
		//计算起始记录数
		pageTools.setStartPage((curr-1)*num);

		//获得总记录数
		pageTools.setTotalCount(bookDao.count());

		//计算总页数
		if(pageTools.getTotalCount()%pageTools.getNumPage()==0){
			pageTools.setTotalPage(pageTools.getTotalCount()/pageTools.getNumPage());
		}else{
			pageTools.setTotalPage(pageTools.getTotalCount()/pageTools.getNumPage()+1);
		}
		//得到结果集合存在pageTools的List中
		pageTools.setList(bookDao.pageList(pageTools.getStartPage(),pageTools.getNumPage()));
		//分页后全部数据返回
		return pageTools;
	}


}
