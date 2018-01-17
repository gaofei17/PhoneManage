package com.dingrui.gaofei.dao;

import java.sql.ResultSet;
import com.dingrui.gaofei.bean.User;
import com.dingrui.gaofei.db.DealDataBase;

public class UserDAO {
	
	//处理数据库对象
	DealDataBase dealDateBase = new DealDataBase();

/**
 * 验证用户
 * 需要用到结果集对象
 * @param user
 * @return boolean
 */
public boolean checkUser(User user)
{
	ResultSet rs = null;
System.out.println("username="+user.getUser_name());	
	boolean b = false;
	
	try
	{
		String sql = "select * from users where user_name=?";
		
		rs = dealDateBase.getRS(sql,user.getUser_name() );
					
		if(rs.next())
		{
			String dbPasswd = rs.getString(3);
System.out.println("dbPasswd="+dbPasswd);			
			
			if(dbPasswd.equals(user.getUser_passwd()))
			{
				b = true;
			}
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!=null){rs.close();rs=null;}
			
		} catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
	return b;
}

/**
 * 验证用户
 * 需要用到结果集对象
 * @param user
 * @return boolean
 */
public int checkGrade(User user)
{
	ResultSet rs = null;
	int b = 2;
	try
	{
		String sql = "select * from users where user_name=?";
		
		rs = dealDateBase.getRS(sql,user.getUser_name() );
		
		if(rs.next())
		{
			int grade = rs.getInt(4);
			System.out.println("rs="+grade);
			
				b = grade;
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!=null){rs.close();rs=null;}
			
		} catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
	return b;
}


/**
 * 增加用户信息
 * @param name
 * @param pwd
 * @param email
 * @param grade
 * @return boolean
 */
public boolean addBorrow(String man_board,String man_client,String man_model,String man_bom,String man_flash,String man_cam,String man_lcm,String man_tpinfo,String man_chipinfo,int man_efuse,String man_band,String man_regdate,int man_amou ,String man_rem,int man_number,String man_user)
{
	boolean b = false;
	
	String sql = "insert into manage(man_board,man_client,man_model, man_bom,man_flash,man_cam,man_lcm,man_tpinfo,man_chipinfo,man_efuse,man_band,man_regdate,man_amou,man_rem,man_number,man_user,submission) values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_DATE())";
	
	System.out.println(sql);
	
	int num =dealDateBase.upDate(sql,man_board,man_client,man_model, man_bom,man_flash,man_cam,man_lcm,man_tpinfo,man_chipinfo,man_efuse,man_band,man_regdate,man_amou,man_rem,man_number,man_user);

		//int num = mysql_affected_rows();
	if(num == 1)
	{
		//修改成功
		b = true;
	}
	
	return b;
}

/**
 * 修改用户信息
 * @param id
 * @param name
 * @param pwd
 * @param email
 * @param grade
 * @return boolean
 */
public boolean updatePrototype(String pro_board,String pro_client,String pro_model,String pro_bom,String pro_flash,String pro_cam,String pro_lcm,String pro_tpinfo,String pro_chipinfo,int pro_efuse,String pro_band,String pro_regdate,int pro_amou ,String pro_rem,int bor_number,String bor_user,int bor_id)
{
	boolean b = false;
	
	String sql = "update manage set man_board=?,man_client=?,man_model=?,man_bom=?,man_flash=?,man_cam=?,man_lcm=?,man_tpinfo=?,man_chipinfo=?,man_efuse=?,man_band=?,man_regdate=?,man_amou=?,man_rem=?,man_number=?,man_user=?,submission=CURRENT_DATE() where man_id=?";
	
	int num = dealDateBase.upDate(sql,pro_board,pro_client,pro_model,pro_bom,pro_flash,pro_cam,pro_lcm,pro_tpinfo,pro_chipinfo,pro_efuse,pro_band,pro_regdate,pro_amou,pro_rem,bor_number,bor_user,bor_id);
		
	if(num == 1)
	{
		//修改成功
		b = true;
	}
	
	return b;
}


/**
 * 删除用户
 * @param id
 * @return
 */
public boolean deletePhone(int id)
{
	boolean b = false;
	
	String sql = "delete from manage where man_id= ?";
		
	int num = dealDateBase.upDate(sql, id);
		
	if(num == 1)
	{
		//删除成功
		b = true;
	}
	return b;
}

}
