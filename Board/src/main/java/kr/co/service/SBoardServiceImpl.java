package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.SPageTO;
import kr.co.persistence.SBoardDAO;

@Service
@Transactional
public class SBoardServiceImpl implements SBoardService {

	@Inject
	private SBoardDAO sbDao;
	
	@Override
	public SPageTO list(SPageTO to) {
		int amount = sbDao.amount(to);
		to.setAmount(amount);
		List<BoardVO> list = sbDao.list(to);
		to.setList(list);
		return to;
	}

	@Override
	public int amount(SPageTO to) {
		return sbDao.amount(to);
	}

	@Override
	public BoardVO read(int bno) {
		sbDao.increaseviewcnt(bno);
		return sbDao.read(bno);
	}

	@Override
	public void del(int bno) {
		sbDao.del(bno);
	}

	@Override
	public BoardVO modifyUI(int bno) {
		return sbDao.modifyUI(bno);
	}

	@Override
	public void modify(BoardVO vo) {
		sbDao.modify(vo);
	}

}
