package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/*
 * MVC �������� ����
 * -. reqeustmapping url ����
 * -. �Լ��� ���� �����ϱ�!! httpservlet -> �� ������
 * 1. ��ȿ�� �˻�(�����Ͻ�����)
 * 2. ���� ���(�����Ͻ�����) 
 * 3. model�� �� ���
 * 4. view ���� -> �Լ� return Ÿ�� string���� ��ȯ
 * */

@Controller
public class YoilTellerMVC {
	@RequestMapping("/getYoilMVC")
	// 1. ��ȯ Ÿ�� String�� ��� return "ȭ���"
	// 2. ��ȯ Ÿ�� X void�� ��� requestMapping url�� ���� ȭ���
	// 3. ModelAndView
	public ModelAndView main(int year, int month, int day, Model model) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		// 1. ��ȿ�� �˻�
//		if(!isValid(year, month, day)) {
//			return "yoilError";
//		}
		
		// 2. ���� ���
		char yoil = getYoil(year, month, day);
		
		// 3. ����� ����� �𵨿� ����
//		model.addAttribute("year", year);
//		model.addAttribute("month", month);
//		model.addAttribute("day", day);
//		model.addAttribute("yoil", yoil);
		
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
		// 4. ����� ������ view�� ���� (ModelAndView ���)
		mv.setViewName("yoil");
		
//		return "yoil";
		return mv;
		
		// 4. ����� ������ view�� ����
		// �丮���� ������ /WEB-INF/spring/appServlet/servlet-context.xml -> <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"> ...����
		// �����Լ� ��ȯŸ���� void�� �ϸ� ���θ��̶� ������ jsp�� ���� ex) getYoilMVC
		// return "yoil"; // /WEB-INF/views/yoil.jsp
	}

	// �ش� Ŭ������������ ����ϱ� ������ private
	private boolean isValid(int year, int month, int day) {
		return true;
	}
	
	// �ش� Ŭ������������ ����ϱ� ������ private
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}
}

/*
 * browser ��û�� ���� ��Ĺ�� HttpServletRequest ��ü�� ���� ��ü�� �Ѱ���
 * @ReqeustMapping("/requestInfo")
 * public void main(HttpServletReqeust request){ ... } 
 * */