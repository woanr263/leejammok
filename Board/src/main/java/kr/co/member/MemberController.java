package kr.co.member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.MemberVO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	private MemberService mService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insertUI() {
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemberVO vo) {
		mService.insert(vo);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST, produces = "application/text;charset=utf-8;")
	@ResponseBody
	public String idcheck(String id) {
		MemberVO idc = mService.idcheck(id);
		if(idc == null) {
			return "가입 가능";
		}else {
			return "가입 불가능";
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<MemberVO> list = mService.list();
		model.addAttribute("list", list);
	}
	
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(Model model, String id) {
		MemberVO vo = mService.read(id);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateui(Model model, String id) {
		MemberVO vo = mService.read(id);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberVO vo) {
		mService.update(vo);
		return "redirect:/member/read?id="+vo.getId();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		mService.delete(id);
		return "redirect:/member/list";
	}
}
