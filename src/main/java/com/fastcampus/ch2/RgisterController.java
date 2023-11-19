package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ctrl+shift+o �ڵ� import
public class RgisterController {
//	@RequestMapping(value="register/add", method={RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("register/add") // �ű�ȸ�� ���� ȭ��
//	@GetMapping("register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}
	
//	@RequestMapping(value="register/save", method=RequestMethod.POST)
	@PostMapping("register/save") // 4.3����
	public String save(User user, Model m) throws Exception{
		// 1. ��ȿ�� �˻�
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			
			m.addAttribute("msg",msg);
			return "redirect:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL���ۼ�(rewriting)
		}
		
		return "registerInfo"; // WEB-INF/views/registerInfo.jsp
		
	}

	private boolean isValid(User user) {
		return true;
	}
}
