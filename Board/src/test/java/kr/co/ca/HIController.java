package kr.co.ca;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HIController {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(Model model) {
		model.addAttribute("msg", "hi world");
		return "kkk";
	}
}
