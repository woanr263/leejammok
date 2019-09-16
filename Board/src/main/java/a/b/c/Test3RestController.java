package a.b.c;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.MemberVO;

@RestController
public class Test3RestController {

	@RequestMapping(value = "/resttest1", method = RequestMethod.POST)
	public String resttest1(@RequestBody String test1) {
		System.out.println(test1);
		
		return test1;
	}
	
	@RequestMapping(value = "/resttest2", method = RequestMethod.POST)
	public String resttest2(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		String msg = (String) map.get("Test2");
		return msg;
	}
	
	@RequestMapping(value = "/resttest3", method = RequestMethod.POST)
	public List<HashMap<String, Object>> resttest3(@RequestBody Map<String, Object> map) {
		@SuppressWarnings("unchecked")
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>)map.get("Test4");
		for(HashMap<String, Object> x : list) {
			System.out.println(x.get("name"));
			System.out.println(x.get("age"));
			System.out.println(x.get("id"));
		}
		return list;
	}
	
	@RequestMapping(value = "/resttest4", method = RequestMethod.POST)
	public List<HashMap<String, Object>> resttext4(@RequestBody Map<String, Object> map){
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>)map.get("Test5");
		
		for(HashMap<String, Object> x : list) {
			System.out.println(x.get("name"));
			System.out.println(x.get("age"));
			System.out.println(x.get("id"));
		}
		return list;
	}
}
