package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.MemberVO;
import kr.co.persistence.MemberDAO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO dao;
	
	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);
	}

	@Override
	public MemberVO idcheck(String id) {
		return dao.idcheck(id);
	}

	@Override
	public List<MemberVO> list() {
		return dao.list();
	}

	@Override
	public MemberVO read(String id) {
		return dao.read(id);
	}

	@Override
	public void update(MemberVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}
}
