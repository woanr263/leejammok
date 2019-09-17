package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.ReplyVO;
import kr.co.persistence.ReplyDAO;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;
	
	@Override
	public void insert(ReplyVO vo) {
		dao.insert(vo);		
	}

	@Override
	public List<ReplyVO> list(int bno) {
		return dao.list(bno);
	}

}
