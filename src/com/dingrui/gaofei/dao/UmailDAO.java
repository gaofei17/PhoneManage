package com.dingrui.gaofei.dao;

import java.sql.ResultSet;

import com.dingrui.gaofei.db.DealDataBase;

public class UmailDAO {
	//�������ݿ����
		DealDataBase dealDateBase = new DealDataBase();
		
		/**
		 * �����û������ַ
		 * ��Ҫ�õ����������
		 * @param user
		 * @return boolean
		 */
		public String mailaddress(String user)
		{
			ResultSet rs = null;
			
			try
			{
				String sql = "select * from umail where umail_name=?";
				
				rs = dealDateBase.getRS(sql,user);
							
				if(rs.next())
				{
					String address = rs.getString(3);		
					return address;
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
			return "";
		}

}
