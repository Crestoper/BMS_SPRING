package spring.mvc.bms.persistence;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import spring.mvc.bms.domain.BoardDTO;
import spring.mvc.bms.domain.BookDTO;
import spring.mvc.bms.domain.GuestDTO;
import spring.mvc.bms.domain.SalesInfoDTO;


@Repository
public class BmsDAOImpl implements BmsDAO{
	
	@Inject
	SqlSession sqlSession;
	
	
	
	@Override
	public ArrayList<BookDTO> getHomeBook(Model model){
		
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		ArrayList<BookDTO> dtolist = dao.getHomeBook(model);
		
		return dtolist;
		
	}
	
	@Override
	public int joinUs(Model model) {

		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest req = (HttpServletRequest) map.get("req");
		
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String gAddr = addr1+"@"+addr2;
		
		model.addAttribute("id", req.getParameter("id"));
		model.addAttribute("pw", req.getParameter("pw"));
		model.addAttribute("gName", req.getParameter("gName"));
		model.addAttribute("gBirth", req.getParameter("gBirth"));
		model.addAttribute("gAddr", gAddr);
		model.addAttribute("gEmail", req.getParameter("gEmail"));
		
		return dao.joinUs(model);
	}

	@Override
	public int idCheck(Model model) {

		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.idCheck(model);
	}

	@Override
	public int login(Model model) {
		
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		Map<String, Object> map = model.asMap();
		System.out.println("map : " + map);
		int cnt = 0;
		
		int go = (Integer)map.get("goNum");
		
		if(go == 1){
			cnt = dao.idCheck(model);
		}else if(go == 2){
			cnt = dao.pwCheck(model);
		}
		
		return cnt;
	}

	@Override
	public int pwCheck(Model model) {

		return pwCheck(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getSalesInfo(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getSalesInfo(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getSearch(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getSearch(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getSearchTAI(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getSearchTAI(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getSearchState(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getSearchState(model);
	}

	@Override
	public ArrayList<BookDTO> getCart(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getCart(model);
	}

	@Override
	public ArrayList<BookDTO> bookpage(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.bookpage(model);
	}

	@Override
	public int buyBook(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.buyBook(model);
	}

	@Override
	public int setBuyBookCount(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.setBuyBookCount(model);
	}

	@Override
	public int checkIdPw(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.checkIdPw(model);
	}

	@Override
	public ArrayList<GuestDTO> getMember(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getMember(model);
	}

	@Override
	public int setMember(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.setMember(model);
	}

	@Override
	public int infoExit(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.infoExit(model);
	}

	@Override
	public ArrayList<BookDTO> searchBook(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.searchBook(model);
	}

	@Override
	public void changeState(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		dao.changeState(model);
	}

	@Override
	public void setCancleBookCount(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		dao.setCancleBookCount(model);
	}

	@Override
	public int getBoardCount() {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getBoardCount();
	}

	@Override
	public ArrayList<BoardDTO> getBoard(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getBoard(model);
	}

	@Override
	public ArrayList<BoardDTO> getBoardContent(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getBoardContent(model);
	}

	@Override
	public void readCnt(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		dao.readCnt(model);
	}

	@Override
	public int getBoardIdPw(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getBoardIdPw(model);
	}

	@Override
	public void setBoardContent(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		dao.setBoardContent(model);
		
	}

	@Override
	public void hostDelete(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		dao.hostDelete(model);
	}

	@Override
	public int deleteBoard(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.deleteBoard(model);
	}

	@Override
	public void boardNewWrite(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		dao.boardNewWrite(model);
	}

	@Override
	public int boardMaxNum() {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.boardMaxNum();
	}

	@Override
	public void boardUpdateRef(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
				dao.boardUpdateRef(model);
	}

	@Override
	public int getSearchBoardCount(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSearchBoardCount(model);
	}

	@Override
	public ArrayList<BoardDTO> getSearchBoard(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getSearchBoard(model);
	}

	@Override
	public int getSalesInfoCount() {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		
		return dao.getSalesInfoCount();
	}

	@Override
	public ArrayList<BookDTO> getBookInfo(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getBookInfo(model);
	}

	@Override
	public int getbookCount() {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getbookCount();
	}

	@Override
	public void setBookInfo(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		dao.setBookInfo(model);
	}

	@Override
	public void hostDeleteStock(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		dao.hostDeleteStock(model);
	}

	@Override
	public void hostAddStock(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		dao.hostAddStock(model);
	}

	@Override
	public int searchBookCount(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.searchBookCount(model);
	}

	@Override
	public ArrayList<BookDTO> getSearchBookInfo(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSearchBookInfo(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getClosing() {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
				
		return dao.getClosing();
	}

	@Override
	public int getSearchCount(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSearchCount(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getSearchGuestId(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSearchGuestId(model);
	}

	@Override
	public int getSalesSelectCount(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSalesSelectCount(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getHostSalesInfo(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getHostSalesInfo(model);
		
	}

	@Override
	public ArrayList<SalesInfoDTO> getSalesSelectInfo(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSalesSelectInfo(model);
	}

	@Override
	public int getSalesInfoCountState1(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSalesInfoCountState1(model);
	}

	@Override
	public int getSalesSelectCountState1(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSalesSelectCountState1(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getHostSalesInfo2(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getHostSalesInfo2(model);
	}

	@Override
	public ArrayList<SalesInfoDTO> getSalesSelectInfo2(Model model) {
		BmsDAO dao = sqlSession.getMapper(BmsDAO.class);
		return dao.getSalesSelectInfo2(model);
	}



}
