package com.dingrui.gaofei.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dingrui.gaofei.bean.Manage;
import com.dingrui.gaofei.bean.User;
import com.dingrui.gaofei.db.DealDataBase;

public class ManageDAO {
	
	//处理数据库对象
		DealDataBase dealDateBase = new DealDataBase();
		
		
		/**
		 * 分页显示
		 * @param pageNow
		 * @param pageSize
		 * @return List
		 */	
		
		public List<Manage> getAllData(int pageNow ,int pageSize){
			List<Manage> list = new ArrayList<Manage>();
			
			int str1=(pageNow-1)*pageSize;
			int str2=pageSize;
			String sql="select * from manage limit ?,?";
			
		   ResultSet res=dealDateBase.getRS(sql,str1,str2);
				try {
					if(res !=null){
						while(res.next()){
							Manage man = new Manage();
							int man_id = res.getInt(1);
							String man_board = res.getString(2);
							String man_client = res.getString(3);
							String man_model = res.getString(4);
							String man_bom = res.getString(5);
							String man_flash = res.getString(6);
							String man_cam = res.getString(7);
							String man_lcm = res.getString(8);
							
			        	//添加新字段man_tpinfo，man_chipinfo，man_efuse，man_band，man_regdate
							String man_tpinfo = res.getString(9);
							String man_chipinfo = res.getString(10);
							int man_efuse = res.getInt(11);
							String man_band = res.getString(12);
							String man_regdate = res.getString(13);

							int man_amou = res.getInt(14);
							String man_rem = res.getString(15);
							int man_number = res.getInt(16);
							String man_user = res.getString(17);
							String submission =res.getString(18);
							
							man.setMan_id(man_id);
							man.setMan_board(man_board);
							man.setMan_client(man_client);
							man.setMan_model(man_model);
							man.setMan_bom(man_bom);
							man.setMan_flash(man_flash);
							man.setMan_cam(man_cam);
							man.setMan_lcm(man_lcm);
							
							//添加新字段man_tpinfo，man_chipinfo，man_efuse，man_band，man_regdate
							man.setMan_tpinfo(man_tpinfo);
							man.setMan_chipinfo(man_chipinfo);
							man.setMan_efuse(man_efuse);
							man.setMan_band(man_band);
							man.setMan_regdate(man_regdate);
							
							
							man.setMan_amou(man_amou);
							man.setMan_rem(man_rem);
							man.setMan_number(man_number);
							man.setMan_user(man_user);
							man.setSubmission(submission);
							
							list.add(man);
							
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return list;
		}
		
		/**
		 * 查找所有主板
		 * @param pageNow
		 * @param pageSize
		 * @return List
		 */	
		
		public List<Manage> getSearchDatab(){
			List<Manage> list = new ArrayList<Manage>();
			
			String sql="select distinct man_board from manage";
		   ResultSet res=dealDateBase.getRS(sql);
				try {
					if(res !=null){
						while(res.next()){
							Manage man = new Manage();
							String board = res.getString(1);
							man.setMan_board(board);						
							list.add(man);
							
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return list;
		}
		
		/**
		 * 查找所有主板
		 * @param pageNow
		 * @param pageSize
		 * @return List
		 */	
		
		public List<Manage> getSearchDatac(){
			List<Manage> list = new ArrayList<Manage>();
			
			String sql="select distinct man_client from manage";
		   ResultSet res=dealDateBase.getRS(sql);
				try {
					if(res !=null){
						while(res.next()){
							Manage man = new Manage();
							String client = res.getString(1);					
							man.setMan_client(client);			
							list.add(man);
							
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return list;
		}
		
		/**
		 * 查找所有主板
		 * @param pageNow
		 * @param pageSize
		 * @return List
		 */	
		
		public List<Manage> getSearchDatam(){
			List<Manage> list = new ArrayList<Manage>();
			
			String sql="select distinct man_model from manage";
		   ResultSet res=dealDateBase.getRS(sql);
				try {
					if(res !=null){
						while(res.next()){
							Manage man = new Manage();
							String model = res.getString(1);		
							man.setMan_model(model);
           			        list.add(man);	
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return list;
		}
		
		/**
		 * 查找所有主板
		 * @param pageNow
		 * @param pageSize
		 * @return List
		 */	
		
		public List<Manage> getSearchDatau(){
			List<Manage> list = new ArrayList<Manage>();
			
			String sql="select distinct user_name from users";
		   ResultSet res=dealDateBase.getRS(sql);
				try {
					if(res !=null){
						while(res.next()){
							Manage man = new Manage();
							String user = res.getString(1);
							man.setMan_user(user);
							list.add(man);
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return list;
		}
		
		
		/**
		 * 查找所有flash
		 * @param pageNow
		 * @param pageSize
		 * @return List
		 */	
		
		public List<Manage> getSearchDataf(){
			List<Manage> list = new ArrayList<Manage>();
			
			String sql="select distinct man_flash from manage";
		   ResultSet res=dealDateBase.getRS(sql);
				try {
					if(res !=null){
						while(res.next()){
							Manage man = new Manage();
							String flash = res.getString(1);
							man.setMan_flash(flash);
							list.add(man);
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return list;
		}
		
		/**
		 * 查询SearchWel2结果
		 * @param pageNow
		 * @param pageSize
		 * @return List
		 */	
		
		public List<Manage> getSearchWel2Data(String a,String b,String c,String d,int pageNow ,int pageSize){
			List<Manage> list = new ArrayList<Manage>();
			
			int str1=(pageNow-1)*pageSize;
			int str2=pageSize;
			String sql="select * from manage where man_board=? or man_client=? or man_model=? or man_user=? limit ?,?";
			
		   ResultSet res=dealDateBase.getRS(sql,a,b,c,d,str1,str2);
				try {
					if(res !=null){
						while(res.next()){
							Manage man = new Manage();
							int man_id = res.getInt(1);
							String man_board = res.getString(2);
							String man_client = res.getString(3);
							String man_model = res.getString(4);
							String man_bom = res.getString(5);
							String man_flash = res.getString(6);
							String man_cam = res.getString(7);
							String man_lcm = res.getString(8);
							
							//添加新字段man_tpinfo，man_chipinfo，man_efuse，man_band，man_regdate
							String man_tpinfo = res.getString(9);
							String man_chipinfo = res.getString(10);
							int man_efuse = res.getInt(11);
							String man_band = res.getString(12);
							String man_regdate = res.getString(13);
							
							int man_amou = res.getInt(14);
							String man_rem = res.getString(15);
							int man_number = res.getInt(16);
							String man_user = res.getString(17);
							String submission =res.getString(18);
							
							man.setMan_id(man_id);
							man.setMan_board(man_board);
							man.setMan_client(man_client);
							man.setMan_model(man_model);
							man.setMan_bom(man_bom);
							man.setMan_flash(man_flash);
							man.setMan_cam(man_cam);
							man.setMan_lcm(man_lcm);
							
							//添加新字段man_tpinfo，man_chipinfo，man_efuse，man_band，man_regdate
							man.setMan_tpinfo(man_tpinfo);
							man.setMan_chipinfo(man_chipinfo);
							man.setMan_efuse(man_efuse);
							man.setMan_band(man_band);
							man.setMan_regdate(man_regdate);
							
							man.setMan_amou(man_amou);
							man.setMan_rem(man_rem);
							man.setMan_number(man_number);
							man.setMan_user(man_user);
							man.setSubmission(submission);
							
							list.add(man);
							
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return list;
		}
		
		/**
		 * 查询SearchWel结果
		 * @param pageNow
		 * @param pageSize
		 * @return List
		 */	
		
		public List<Manage> getSearchWelData(String a,String b,String c,String d,int pageNow ,int pageSize){
			List<Manage> list = new ArrayList<Manage>();
			
			int str1=(pageNow-1)*pageSize;
			int str2=pageSize;
			String sql="select * from manage where man_board=? and man_client=? and man_model=? and man_flash=? limit ?,?";
			
		   ResultSet res=dealDateBase.getRS(sql,a,b,c,d,str1,str2);
				try {
					if(res !=null){
						while(res.next()){
							Manage man = new Manage();
							int man_id = res.getInt(1);
							String man_board = res.getString(2);
							String man_client = res.getString(3);
							String man_model = res.getString(4);
							String man_bom = res.getString(5);
							String man_flash = res.getString(6);
							String man_cam = res.getString(7);
							String man_lcm = res.getString(8);
							int man_amou = res.getInt(9);
							String man_rem = res.getString(10);
							int man_number = res.getInt(11);
							String man_user = res.getString(12);
							String submission =res.getString(13);
							
							man.setMan_id(man_id);
							man.setMan_board(man_board);
							man.setMan_client(man_client);
							man.setMan_model(man_model);
							man.setMan_bom(man_bom);
							man.setMan_flash(man_flash);
							man.setMan_cam(man_cam);
							man.setMan_lcm(man_lcm);
							man.setMan_amou(man_amou);
							man.setMan_rem(man_rem);
							man.setMan_number(man_number);
							man.setMan_user(man_user);
							man.setSubmission(submission);
							
							list.add(man);
							
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return list;
		}
		
		/*
		 * 查询表所有记录数目
		 * */
		public int phoneCount(){
            String sql = "select count(*) from manage";
            
			int rowCount = dealDateBase.getRowCount(sql);
				
			return rowCount;
			
		}
		
		/*
		 * 查询searchwel记录数目
		 * */
		public int searchCount(String a,String b,String c,String d){
            String sql = "select count(*) from manage where man_board=? and man_client=? and man_model=? and man_flash=?";
            
			int rowCount = dealDateBase.getRowCount(sql,a,b,c,d);
				
			return rowCount;
			
		}
		
		/*
		 * 查询searchwel2记录数目
		 * */
		public int search2Count(String a,String b,String c,String d){
            String sql = "select count(*) from manage where man_board=? or man_client=? or man_model=? or man_user=?";
            
			int rowCount = dealDateBase.getRowCount(sql,a,b,c,d);
				
			return rowCount;
			
		}
}
