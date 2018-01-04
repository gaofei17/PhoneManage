package com.dingrui.gaofei.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DealDataBase {

PreparedStatement psta = null;//创建PreparedStatement对象用于向数据库发送SQL语句。

/*二.PreparedStatement在Java中常用数据库操作 
1 引用特定的包  
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 

2 一般实例化一个PreparedStatement和结果集 
PreparedStatement prepstmt = null; 
ResultSet rs = null; 

3 得到SQL语句 
conn 为Connection类型 
prepstmt = conn.prepareStatement(String StrSQl); 

4 执行SQL，得到结果集 
rs 为ResultSet类型。 
rs = prepstmt.executeQuery();
 * 
 * */

	ResultSet rs = null;//创建结果集对象
	
	Connection con = null;

	/**
	 * 与数据库连接
	 * @return Connection
	 */
	public Connection getConn()
	{	
		//第一种数据库连接,使用JDBC连接方式
		try
		{
			//加载驱动
			Class.forName(DBConfig.DRIVER);
			
			//创建数据库连接,并返回
		    return con = DriverManager.getConnection(DBConfig.URL);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//第二种数据库连接,使用数据池连接方式
	/*	try
		{
			//创建一个上下文环境
			Context context = new javax.naming.InitialContext();
			
			//通过con得到数据源
			DataSource ds = (DataSource) context.lookup("java:comp/env/muserSource");
			
			return	con = ds.getConnection();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	*/	
		return null;
	}
	
	/**
	 * 关闭连接,释放资源 
	 */
	public void close()
	{
		try
		{
			//第一步关闭连接,并释放资源
			if(con != null) {con.close();con =null;}
			
			//第二步关闭 向数据库发送SQL请求对象,并释放资源
			if(psta != null){psta.close();psta=null;}
			
			//第三步关闭结果集,并释放资源
			if(rs != null){rs.close();rs=null;}
		} 
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
	
	
	/**
	 * 返回一个ResultSet用户验证用户合法性
	 * Object... values，你也可以认为是Object[]values,数组而已
	 */
	public ResultSet getRS(String sql,Object... values)
	{
		try
		{
			con = this.getConn();
			
			psta = con.prepareStatement(sql);
			
			for(int i = 0;i<values.length;i++)
			{
				
				//为PreparedStatement对象发送的sql语句中的占位符赋值
				psta.setObject(i+1, values[i]);
				
			}
			
			//执行查询语句返回结果集对象
			return rs = psta.executeQuery();	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 数据的增加、物理删除、逻辑删除、修改、
	 * 参数 SQL 和  values 一个是sql语句，一个是Object数组.
	 */
	public int upDate(String sql,Object... values)
	{
		
		int row = 0;
		
		try
		{
			con = this.getConn();
			
			//创建向数据库发送要执行的sql语句对象
			psta = con.prepareStatement(sql);
			
			for(int i = 0;i<values.length;i++)
			{
				
				//为该对象的每一个占位符赋 数组values的值。
				psta.setObject(i+1, values[i]);
				
			}
			
			//执行数据库添加、删除、修改等语句，返回int
			row = psta.executeUpdate();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.close();
		}
		
		return row;//返回执行结果
	}
 
	/**
	 * 返回有占位符的某数据表中的记录条数
	 */
	public int getRowCount(String sql,Object... values)
	{
		int rowCount = 0;
		
		try
		{
			con = this.getConn();
			
			psta = con.prepareStatement(sql);
			
			for(int i = 0;i<values.length;i++)
			{
				
				//为PreparedStatement对象发送的sql语句中的占位符赋值
				psta.setObject(i+1, values[i]);
				
			}
			
			rs = psta.executeQuery();

			if(rs.next())//精确到行
			{
				rowCount = rs.getInt(1);//返回第几列
			}
				
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.close();
		}
		return rowCount;
	}
}
