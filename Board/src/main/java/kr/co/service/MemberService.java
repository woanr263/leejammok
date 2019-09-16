package kr.co.service;

import java.util.List;

import kr.co.domain.MemberVO;

public interface MemberService {
	public void insert(MemberVO vo);

	public MemberVO idcheck(String id);

	public List<MemberVO> list();

	public MemberVO read(String id);

	public void update(MemberVO vo);

	public void delete(String id);
}
