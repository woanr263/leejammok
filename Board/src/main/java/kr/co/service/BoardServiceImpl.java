package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.SPageTO;
import kr.co.persistence.BoardDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Override
	public Integer create(BoardVO vo) throws Exception {
		return dao.create(vo);
	}

	@Override
	public List<BoardVO> listall() {
		return dao.listall();
	}

	@Override
	public BoardVO read(int bno) {
		dao.increaseviewcnt(bno);
		return dao.read(bno);
	}

	@Override
	public void del(int bno) {
		dao.del(bno);
	}

	@Override
	public void modify(BoardVO vo) {
		dao.modify(vo);
	}

	@Override
	public BoardVO modifyUI(int bno) {
		return dao.modifyUI(bno);
	}

	@Override
	public PageTO<BoardVO> list(PageTO<BoardVO> to) {
		int amount = dao.getAmount();
		to.setAmount(amount);
		List<BoardVO> list = dao.list(to);
		to.setList(list);
		return to;
	}

	@Override
	public int amount() {
		return dao.getAmount();
	}

	@Override
	public SPageTO searchlist(SPageTO to) {
		int amount = dao.searchAmount();
		to.setAmount(amount);
		List<BoardVO> list = dao.searchlist(to);
		to.setList(list);
		return to;
	}

	@Override
	public int searchAmount() {
		return dao.searchAmount();
	}
}
