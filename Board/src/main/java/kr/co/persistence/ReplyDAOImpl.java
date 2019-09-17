package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;
	
	private final String NS = "kr.co.mapper.reply";
	
	@Override
	public void insert(ReplyVO vo) {
		session.insert(NS+".insert", vo);
	}

	@Override
	public List<ReplyVO> list(int bno) {
		return session.selectList(NS+".list", bno);
	}

	@Override
	public void update(ReplyVO vo) {
		session.update(NS+".update", vo);
	}

	@Override
	public void delete(int rno) {
		session.delete(NS+".delete", rno);
	}

}
