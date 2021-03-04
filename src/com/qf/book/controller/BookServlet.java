package com.qf.book.controller;

import com.qf.book.tools.ConstantTool;

import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.book.entity.Book;
import com.qf.book.service.IBookService;
import com.qf.book.service.impl.BookServiceImpl;
import com.qf.book.tools.PageTools;

@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet{
	//创建服务接口
	private IBookService bookService = new BookServiceImpl();

	/**
	 * 新增
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void add(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//创建Book对象,获得前端参数并存入对象中
		Book book = getObjectRequest(req, Book.class);
		//用对象调用新增业务
		int flag = bookService.add(book);
		if(flag>0){
			//执行新增成功跳转
			req.setAttribute(ConstantTool.MESS,"新增成功!");
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}else{
			//执行新增失败跳转
			req.setAttribute(ConstantTool.MESS,"新增失败!");
			req.getRequestDispatcher("addbook.jsp").forward(req,resp);
		}
		
	}

	/**
	 * 根据主键id删除
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//获得删除的id
		String keyId = req.getParameter("id");
		//用对象调用删除业务
		int flag = bookService.deleteById(Integer.valueOf(keyId));
		if(flag>0){
			//执行删除成功跳转
			req.setAttribute(ConstantTool.MESS,"删除成功!");
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}else{
			//执行删除失败跳转
			req.setAttribute(ConstantTool.MESS,"删除失败!");
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}
	}

	/**
	 * 修改数据
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//创建Book对象,获得前端参数并存入对象中
		Book book = getObjectRequest(req, Book.class);
		//用对象调用修改业务
		int flag = bookService.update(book);
		if(flag>0){
			//执行修改成功跳转
			req.setAttribute(ConstantTool.MESS,"修改成功!");
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}else{
			//执行修改失败跳转
			req.setAttribute(ConstantTool.MESS,"修改失败!");
			req.getRequestDispatcher("updatebook.jsp").forward(req,resp);
		}
	}

	/**
	 * 查询单个数据
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void findById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//根据id查询记录
		String keyId = req.getParameter("id");

		//调用业务逻辑
		Book book = bookService.findById(Integer.valueOf(keyId));

		//用setArribute()存值
		req.setAttribute("book", book);
		//响应用户页面
		req.getRequestDispatcher("updatebook.jsp").forward(req,resp);
	}

	/**
	 * 查询用户所有信息
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void pageList(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		//获得当前页码
		String curr = req.getParameter("curr");
		//获得每页显示记录数
		String num =  req.getParameter("num");
        //声明一个分页内容存值容器
        PageTools<Book> pageList =null;

        //如果页码为空或者每页记录数为空
        if(curr==null || num==null){
            pageList = bookService.pageList(1,10);
        }else{
            //根据分页条件结果调用业务逻辑层
            pageList = bookService.pageList(Integer.valueOf(curr),Integer.valueOf(num));
        }
		//将查询出的所有信息存入request
		req.setAttribute("list",pageList);
        
		//响应用户页面
		req.getRequestDispatcher("showbook.jsp").forward(req,resp);
	}
}
