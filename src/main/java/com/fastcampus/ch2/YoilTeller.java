package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;



// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller {
	//public static void main(String[] args) {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest reqeust, HttpServletResponse response) throws IOException{
		//                                       ������ ����� ���� response��ü ���
		// 1. �Է�
		String year = reqeust.getParameter("year");
		String month = reqeust.getParameter("month");
		String day = reqeust.getParameter("day");
		
		// 2. �۾�
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);;
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		// 3. ���
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); // response��ü���� ���������� ��� ��Ʈ���� ��´�.
		out.println(year + "�� " + month + "��" + day + "���� ");
		out.println(yoil + "�����Դϴ�.");
	}
}

/*
 * browser ��û�� ���� ��Ĺ�� HttpServletRequest ��ü�� ���� ��ü�� �Ѱ���
 * @ReqeustMapping("/requestInfo")
 * public void main(HttpServletReqeust request){ ... } 
 * */
 