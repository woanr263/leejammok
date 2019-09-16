package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.SPageTO;

@Repository
public class SBoardDAOImpl implements SBoardDAO {

	@Inject
	private SqlSession session;
	
	private final String NS = "kr.co.mapper.sboard";
	
	@Override
	public List<BoardVO> list(SPageTO to) {
		return session.selectList(NS+".list", to);
	}

	@Override
	public int amount(SPageTO to) {
		return session.selectOne(NS+".amount", to);
	}

	@Override
	public void increaseviewcnt(int bno) {
		session.update(NS+".increaseviewcnt", bno);
	}

	@Override
	public BoardVO read(int bno) {
		return session.selectOne(NS+".read", bno);
	}

	@Override
	public void del(int bno) {
		session.delete(NS+".del", bno);
	}

	@Override
	public BoardVO modifyUI(int bno) {
		return session.selectOne(NS+".modifyUI", bno);
	}

	@Override
	public void modify(BoardVO vo) {
		session.selectOne(NS+".modify", vo);
	}

}
