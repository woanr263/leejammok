package a.b.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.domain.MemberVO;

@Controller
public class Test2Controller {

	@RequestMapping("/json1")
//	public @ResponseBody MemberVO json1() {
//	
//	}
	@ResponseBody //json 형태로 반환
	public MemberVO json1() {
		MemberVO vo = new MemberVO("m001", "lee", 11);
		
		return vo;
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1() {
		
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	@ResponseBody
	public String test1(String str) {
		System.out.println(str);
		return str;
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public void test2() {
		
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	@ResponseBody
	public String[] test2(String[] arr) {
		for(String x : arr) {
			System.out.println(x);
		}
		
		return arr;
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public void test3() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public MemberVO test3(MemberVO vo) {
		System.out.println(vo);
		
		return vo;
	}
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public void test4(Model model) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list.add(new MemberVO("m001", "a", 11));
		list.add(new MemberVO("m002", "b", 13));
		list.add(new MemberVO("m003", "c", 15));
		list.add(new MemberVO("m004", "d", 16));
		list.add(new MemberVO("m005", "e", 18));
		
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> test4(@RequestParam Map<String, Object> map) throws Exception{
		String jsonStr = map.get("list").toString();
		
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String , Object>> list = mapper.readValue(jsonStr, new TypeReference<ArrayList<Map<String, Object>>>() {});

		return list;
	}
}
