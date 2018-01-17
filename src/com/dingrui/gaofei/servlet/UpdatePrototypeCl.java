package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingrui.gaofei.dao.UmailDAO;
import com.dingrui.gaofei.dao.UserDAO;
import com.dingrui.gaofei.tools.SendMail;
import com.dingrui.gaofei.tools.SendMail2;

public class UpdatePrototypeCl extends HttpServlet{
	
	SendMail sendmail= new SendMail();
	UmailDAO UmaDAO = new UmailDAO();
	SendMail2 sendmail2 = new SendMail2();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		req.setCharacterEncoding("GBk");
		PrintWriter out = resp.getWriter();

		int bor_id  =Integer.parseInt(req.getParameter("Bor_id"));
		String pro_board  = req.getParameter("Pro_board").trim();
		String pro_client   = req.getParameter("Pro_client").trim();
		String pro_model   = req.getParameter("Pro_model").trim();
		String pro_bom   = req.getParameter("Pro_bom").trim();
		String pro_flash   = req.getParameter("Pro_flash").trim();
		String pro_cam   = req.getParameter("Pro_cam").trim();
		String pro_lcm   = req.getParameter("Pro_lcm").trim();
		
		//����ֶ�
				String pro_tpinfo   = req.getParameter("Pro_tpinfo").trim();
				String pro_chipinfo   = req.getParameter("Pro_chipinfo").trim();
				int pro_efuse = Integer.parseInt(req.getParameter("Pro_efuse").trim());
				String pro_band   = req.getParameter("Pro_band").trim();
				String pro_regdate   = req.getParameter("Pro_regdate").trim();
		
		int pro_amou = Integer.parseInt(req.getParameter("Pro_amou").trim());
		String pro_rem   = req.getParameter("Pro_rem").trim();
		int bor_number=Integer.parseInt(req.getParameter("Bor_number").trim());
		String bor_user =req.getParameter("Bor_user").trim();
		
		//��ȡold_user��Ϣ
		String old_user = req.getParameter("Old_user").trim();
		
		System.out.println("new="+bor_user+"old="+old_user);
		//System.out.println("update="+bor_id +pro_board +pro_client+pro_model +pro_bom+pro_flash +pro_cam+pro_lcm+pro_amou+pro_rem);
		// ����UserDAO�е�ɾ���û��ķ���
		if (new UserDAO().updatePrototype(pro_board,pro_client,pro_model,pro_bom,pro_flash,pro_cam,pro_lcm,pro_tpinfo,pro_chipinfo,pro_efuse,pro_band,pro_regdate,pro_amou,pro_rem,bor_number,bor_user,bor_id))
		{
			// �޸ĳɹ�
			resp.sendRedirect("ok");
			//System.out.println("ok");
			//�����ʼ�
			try {			
				if(bor_user != "" && old_user.equals("size=60"))//���
				{
				String mail_address =UmaDAO.mailaddress(bor_user);
				sendmail.send("ID"+bor_id+"����"+pro_board+"�ͻ�"+pro_client+"�ͺ�"+pro_model+"BOM����"+pro_bom+"���"+bor_number+"#����",bor_user,mail_address); //�����ʼ�
				}else if(bor_user == "" && old_user != "") //�黹
				{
					String mail_address =UmaDAO.mailaddress(old_user);
					sendmail2.send2("ID"+bor_id+"����"+pro_board+"�ͻ�"+pro_client+"�ͺ�"+pro_model+"BOM����"+pro_bom+"���"+bor_number+"����",old_user,mail_address); //�����ʼ�
				
				}else{
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
		{
			// �޸�ʧ��
			resp.sendRedirect("error");
			//System.out.println("error");
		}

		out.flush();
		out.close();


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
