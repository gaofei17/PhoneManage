package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingrui.gaofei.dao.UserDAO;

public class AddBorrowCl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("text/html;charset=gbk");
		req.setCharacterEncoding("GBk");
		
		PrintWriter out = resp.getWriter();
		
		String man_board  = req.getParameter("Pro_board").trim();
		String man_client   = req.getParameter("Pro_client").trim();
		String man_model   = req.getParameter("Pro_model").trim();
		String man_bom   = req.getParameter("Pro_bom").trim();
		String man_flash   = req.getParameter("Pro_flash").trim();
		String man_cam   = req.getParameter("Pro_cam").trim();
		String man_lcm   = req.getParameter("Pro_lcm").trim();
		
		//添加字段
		String man_tpinfo   = req.getParameter("Pro_tpinfo").trim();
		String man_chipinfo   = req.getParameter("Pro_chipinfo").trim();
		int man_efuse = Integer.parseInt(req.getParameter("Pro_efuse").trim());
		String man_band   = req.getParameter("Pro_band").trim();
		String man_regdate   = req.getParameter("Pro_regdate").trim();
		
		int man_amou = Integer.parseInt(req.getParameter("Pro_amou").trim());
		String man_rem   = req.getParameter("Pro_rem").trim();
		int man_number =Integer.parseInt(req.getParameter("Bor_number").trim());
		String man_user  = req.getParameter("Bor_user").trim();
		
		//System.out.println(pro_id +pro_board +pro_client+pro_model +pro_bom+pro_flash +pro_cam+pro_lcm+pro_amou+pro_rem);
		
		//int  pro_amou =Integer.parseInt(Strpro_amou);

		// 调用UserDAO中的删除用户的方法
		if (new UserDAO().addBorrow(man_board,man_client,man_model, man_bom,man_flash,man_cam,man_lcm,man_tpinfo,man_chipinfo,man_efuse,man_band,man_regdate,man_amou,man_rem,man_number,man_user))
		{
			// 修改成功
			resp.sendRedirect("ok");
			//System.out.println("ok");
		} else
		{
			// 修改失败
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
