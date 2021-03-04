package com.qf.book.controller;

import com.qf.book.tools.ConstantTool;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 父servlet
 */

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获得用户访问的Servlet方法名
		String methodName = req.getParameter(ConstantTool.METHOD);
		//判断用户传的method是否存在
		if(methodName==null || methodName.trim().isEmpty()) {
			System.out.println("您没有传递method参数! 无法确定要调用的方法!");
			return;
		}
		//用反射对象,获得当前类的class对象
		Class<? extends BaseServlet> c = this.getClass();

		//声明一个方法
		Method method = null;
		try {
			//用反射对象获得指定方法
			method = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//跳过访问修饰符的检查机制
			method.setAccessible(true);
		} catch (Exception e) {
			System.out.println("您要调用的方法: " +methodName+ ",不存在!");
			return;
		} 
		
		//获得方法后调用方法
		try {
			method.invoke(this, req,resp);
		} catch (Exception e) {
			System.out.println("您调用的方法: " + methodName + ", 它抛出了异常!");
			e.printStackTrace();
		} 
		
	}


	/**
	 * 将请求数据封装
	 * @param request
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public <T> T getObjectRequest(HttpServletRequest request,Class<T> clazz){
		//获得请求数据
		T t = null;
		//获得接收对象的实例对象
		try {
			t = clazz.newInstance();
			//获得该对象中的所有属性(包括private)
            Field[] fields = clazz.getDeclaredFields();
			for(int i=0;i<fields.length;i++){
				//访问修饰符不被检查
				fields[i].setAccessible(true);
				//获得属性数据类型
				Class<?> fieldType = fields[i].getType();
				//获得请求参数
				String value = request.getParameter(fields[i].getName());
				if(value==null){//参数不存在
					continue;//跳过本次循环
				}
				//根据不同数据类型设置值
				if(fieldType==String.class){ //String类型
					fields[i].set(t,value);
				}else if(fieldType==Date.class){ //Date类型
					fields[i].set(t,format(value));
				}else{
					//获得field的转成字符串
					String s = fieldType.toString();//获得class java.lang.数据类型
					//获得类型反射对象
					Class typeClazz = Class.forName(s.substring(s.indexOf(" ")+1));
					try{
						//根据方法名字获得方法,传入参数类型
						Method valueOf = typeClazz.getDeclaredMethod("valueOf", String.class);
						//访问修饰符不被检查
						valueOf.setAccessible(true);
						//静态方法不用传入实例对象,value将String类型值给方法
                        Object invokeValue = valueOf.invoke(null, value);
                        //将数据存入
                        fields[i].set(t,invokeValue);
                    }catch (Exception e){
						throw new RuntimeException("属性请使用java包装类型!"+e);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	//自定义一个方法,用来将一个字符串String转换为一个java.util.Date类型对象
	private Date format(String in) {
		String pattern = "yyyy-MM-dd";
		String patternTime = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = null;
		try {
			if(in.contains(":")){
				sdf = new SimpleDateFormat(patternTime);
			}else{
				sdf = new SimpleDateFormat(pattern);
			}
			Date date =sdf.parse(in);
			return date;
		} catch (ParseException e) {
			System.out.println("时间转型失败!转型字段: "+in);
			e.printStackTrace();
		}
		return null;
	}
}
