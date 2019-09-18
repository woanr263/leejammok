package kr.co.ca;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;
import kr.co.service.ReplyService;

@Controller
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService rService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody ReplyVO vo) {
		ResponseEntity<String> entity = null;
		try {
			rService.insert(vo);
			entity = new ResponseEntity<String>("INSERT_SUCCESS", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable int rno, @RequestBody ReplyVO vo){
		ResponseEntity<String> entity = null;
		vo.setRno(rno);
		
		try {
			rService.update(vo);
			entity = new ResponseEntity<String>("UPDATE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{bno}/{replyPage}", method = RequestMethod.GET)
	public ResponseEntity<PageTO<ReplyVO>> list(@PathVariable("bno") int bno, @PathVariable("replyPage") int replyPage){
		ResponseEntity<PageTO<ReplyVO>> entity = null;
		try {
			PageTO<ReplyVO> to = rService.list(bno, replyPage);
			entity = new ResponseEntity<PageTO<ReplyVO>>(to, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<PageTO<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable int rno){
		ResponseEntity<String> entity = null;
		try {
			rService.delete(rno);
			entity = new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
