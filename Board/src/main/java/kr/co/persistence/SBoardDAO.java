package kr.co.persistence;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.SPageTO;

public interface SBoardDAO {

	List<BoardVO> list(SPageTO to);

	int amount(SPageTO to);

	void increaseviewcnt(int bno);

	BoardVO read(int bno);

	void del(int bno);

	BoardVO modifyUI(int bno);

	void modify(BoardVO vo);

}
