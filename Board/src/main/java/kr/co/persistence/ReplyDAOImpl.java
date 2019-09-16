package kr.co.persistence;

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

}
