package kr.co.ca;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
