package kr.co.ca;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService bService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createUI() {
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(BoardVO vo) throws Exception {
		bService.create(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/listall")
	public String listall(Model model) throws Exception{
		List<BoardVO> list = bService.listall();
		model.addAttribute("list", list);
		return "/board/listall";
	}
	
	@RequestMapping(value = "/read")
	public String read(int bno, Model model,PageTO<BoardVO> to) {
		BoardVO vo = bService.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
		return "/board/read";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String del(int bno, PageTO<BoardVO> to, Model model) {
		bService.del(bno);
		return "redirect:/board/list?curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	
	@RequestMapping(value = "/modify")
	public void modifyUI(int bno, PageTO<BoardVO> to, Model model) {
		BoardVO vo = bService.modifyUI(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVO vo, PageTO<BoardVO> to) {
		bService.modify(vo);
		return "redirect:/board/read?bno="+vo.getBno()+"&curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	 
	@RequestMapping("/list")
	public void list(PageTO<BoardVO> to, Model model) {
		PageTO<BoardVO> DBto = bService.list(to);
		model.addAttribute("to", DBto);
	}
	
	@RequestMapping("/amount/{perPage}")
	@ResponseBody
	public int list(@PathVariable("perPage") int perPage) {
		int amount = bService.amount();
		return (amount-1)/perPage+1;
	}
}
