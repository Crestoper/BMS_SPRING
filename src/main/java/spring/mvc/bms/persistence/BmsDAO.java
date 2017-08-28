package spring.mvc.bms.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import spring.mvc.bms.domain.BoardDTO;
import spring.mvc.bms.domain.BookDTO;
import spring.mvc.bms.domain.GuestDTO;
import spring.mvc.bms.domain.SalesInfoDTO;


public interface BmsDAO {
	
	public ArrayList<BookDTO> getHomeBook(Model model);
	
	public int joinUs(Model model);

	public int idCheck(Model model);

	public int login(Model model);

	public int pwCheck(Model model);

	public ArrayList<SalesInfoDTO> getSalesInfo(Model model);

	public ArrayList<SalesInfoDTO> getSearch(Model model);

	public ArrayList<SalesInfoDTO> getSearchTAI(Model model);

	public ArrayList<SalesInfoDTO> getSearchState(Model model);

	public ArrayList<BookDTO> getCart(Model model);

	public ArrayList<BookDTO> bookpage(Model model);

	public int buyBook(Model model);

	public int setBuyBookCount(Model model);

	public int checkIdPw(Model model);

	public ArrayList<GuestDTO> getMember(Model model);

	public int setMember(Model model);

	public int infoExit(Model model);

	public ArrayList<BookDTO> searchBook(Model model);

	public void changeState(Model model);

	public void setCancleBookCount(Model model);

	public int getBoardCount();

	public ArrayList<BoardDTO> getBoard(Model model);

	public ArrayList<BoardDTO> getBoardContent(Model model);

	public void readCnt(Model model);

	public int getBoardIdPw(Model model);

	public void setBoardContent(Model model);

	public void hostDelete(Model model);

	public int deleteBoard(Model model);

	public void boardNewWrite(Model model);

	public int boardMaxNum();

	public void boardUpdateRef(Model model);

	public int getSearchBoardCount(Model model);

	public ArrayList<BoardDTO> getSearchBoard(Model model);

	public int getSalesInfoCount();

	public ArrayList<BookDTO> getBookInfo(Model model);

	public int getbookCount();

	public void setBookInfo(Model model);

	public void hostDeleteStock(Model model);

	public void hostAddStock(Model model);

	public int searchBookCount(Model model);

	public ArrayList<BookDTO> getSearchBookInfo(Model model);

	public ArrayList<SalesInfoDTO> getClosing();

	public int getSearchCount(Model model);

	public ArrayList<SalesInfoDTO> getSearchGuestId(Model model);

	public int getSalesSelectCount(Model model);

	public ArrayList<SalesInfoDTO> getHostSalesInfo(Model model);

	public ArrayList<SalesInfoDTO> getSalesSelectInfo(Model model);

	public int getSalesInfoCountState1(Model model);

	public int getSalesSelectCountState1(Model model);

	public ArrayList<SalesInfoDTO> getHostSalesInfo2(Model model);

	public ArrayList<SalesInfoDTO> getSalesSelectInfo2(Model model);



}
