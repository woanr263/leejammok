package kr.co.service;

import kr.co.domain.BoardVO;
import kr.co.domain.SPageTO;

public interface SBoardService {

	SPageTO list(SPageTO to);

	int amount(SPageTO to);

	BoardVO read(int bno);

	void del(int bno);

	BoardVO modifyUI(int bno);

	void modify(BoardVO vo);
}
