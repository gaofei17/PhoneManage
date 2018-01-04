package com.dingrui.gaofei.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DealDataBase {

PreparedStatement psta = null;//����PreparedStatement�������������ݿⷢ��SQL��䡣

/*��.PreparedStatement��Java�г������ݿ���� 
1 �����ض��İ�  
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 

2 һ��ʵ����һ��PreparedStatement�ͽ���� 
PreparedStatement prepstmt = null; 
ResultSet rs = null; 

3 �õ�SQL��� 
conn ΪConnection���� 
prepstmt = conn.prepareStatement(String StrSQl); 

4 ִ��SQL���õ������ 
rs ΪResultSet���͡� 
rs = prepstmt.executeQuery();
 * 
 * */

	ResultSet rs = null;//�������������
	
	Connection con = null;

	/**
	 * �����ݿ�����
	 * @return Connection
	 */
	public Connection getConn()
	{	
		//��һ�����ݿ�����,ʹ��JDBC���ӷ�ʽ
		try
		{
			//��������
			Class.forName(DBConfig.DRIVER);
			
			//�������ݿ�����,������
		    return con = DriverManager.getConnection(DBConfig.URL);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//�ڶ������ݿ�����,ʹ�����ݳ����ӷ�ʽ
	/*	try
		{
			//����һ�������Ļ���
			Context context = new javax.naming.InitialContext();
			
			//ͨ��con�õ�����Դ
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
	 * �ر�����,�ͷ���Դ 
	 */
	public void close()
	{
		try
		{
			//��һ���ر�����,���ͷ���Դ
			if(con != null) {con.close();con =null;}
			
			//�ڶ����ر� �����ݿⷢ��SQL�������,���ͷ���Դ
			if(psta != null){psta.close();psta=null;}
			
			//�������رս����,���ͷ���Դ
			if(rs != null){rs.close();rs=null;}
		} 
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
	
	
	/**
	 * ����һ��ResultSet�û���֤�û��Ϸ���
	 * Object... values����Ҳ������Ϊ��Object[]values,�������
	 */
	public ResultSet getRS(String sql,Object... values)
	{
		try
		{
			con = this.getConn();
			
			psta = con.prepareStatement(sql);
			
			for(int i = 0;i<values.length;i++)
			{
				
				//ΪPreparedStatement�����͵�sql����е�ռλ����ֵ
				psta.setObject(i+1, values[i]);
				
			}
			
			//ִ�в�ѯ��䷵�ؽ��������
			return rs = psta.executeQuery();	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ���ݵ����ӡ�����ɾ�����߼�ɾ�����޸ġ�
	 * ���� SQL ��  values һ����sql��䣬һ����Object����.
	 */
	public int upDate(String sql,Object... values)
	{
		
		int row = 0;
		
		try
		{
			con = this.getConn();
			
			//���������ݿⷢ��Ҫִ�е�sql������
			psta = con.prepareStatement(sql);
			
			for(int i = 0;i<values.length;i++)
			{
				
				//Ϊ�ö����ÿһ��ռλ���� ����values��ֵ��
				psta.setObject(i+1, values[i]);
				
			}
			
			//ִ�����ݿ���ӡ�ɾ�����޸ĵ���䣬����int
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
		
		return row;//����ִ�н��
	}
 
	/**
	 * ������ռλ����ĳ���ݱ��еļ�¼����
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
				
				//ΪPreparedStatement�����͵�sql����е�ռλ����ֵ
				psta.setObject(i+1, values[i]);
				
			}
			
			rs = psta.executeQuery();

			if(rs.next())//��ȷ����
			{
				rowCount = rs.getInt(1);//���صڼ���
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
