package kr.co.ca;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.SPageTO;
import kr.co.service.SBoardService;

@Controller
@RequestMapping("/sboard")
public class SearchBoardController {
	
	@Inject
	private SBoardService sbService;

	@RequestMapping(value = "/list")
	public void search(SPageTO<BoardVO> to, Model model) {
		SPageTO<BoardVO> dbto = sbService.list(to);
		model.addAttribute("to", dbto);
	}
	
	@RequestMapping("/amount/{perPage}")
	@ResponseBody
	public int list(@PathVariable("perPage") int perPage, SPageTO<BoardVO> to) {
		int amount = sbService.amount(to);
		return (amount-1)/perPage+1;
	}
	
	@RequestMapping(value = "/read")
	public void read(int bno, Model model,SPageTO<BoardVO> to) {
		BoardVO vo = sbService.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String del(int bno, SPageTO<BoardVO> to, Model model) {
		sbService.del(bno);
		return "redirect:/sboard/list?curPage="+to.getCurPage()+"&perPage="+to.getPerPage()+"&select="+to.getSelect()+"&keyword="+to.getKeyword();
	}
	
	@RequestMapping(value = "/modify")
	public void modifyUI(int bno, SPageTO<BoardVO> to, Model model) {
		BoardVO vo = sbService.modifyUI(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVO vo, SPageTO<BoardVO> to) {
		sbService.modify(vo);
		return "redirect:/sboard/read?bno="+vo.getBno()+"&curPage="+to.getCurPage()+"&perPage="+to.getPerPage()+"&select="+to.getSelect()+"&keyword="+to.getKeyword();
	}
}
