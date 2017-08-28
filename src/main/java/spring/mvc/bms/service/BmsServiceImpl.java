package spring.mvc.bms.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import spring.mvc.bms.domain.GuestDTO;
import spring.mvc.bms.domain.BoardDTO;
import spring.mvc.bms.domain.BookDTO;
import spring.mvc.bms.domain.SalesInfoDTO;
import spring.mvc.bms.persistence.BmsDAO;

@Service
public class BmsServiceImpl implements BmsService{

	@Inject
	BmsDAO dao;
	
	@Override
	public String homeService(Model model) throws Exception {

		model.addAttribute("start", "1");
		model.addAttribute("end", "10");
		
		ArrayList<BookDTO> dtolist = dao.getHomeBook(model);
		
		model.addAttribute("dtolist", dtolist);
		
		return "home";
	}

	@Override
	public String joinUsService(HttpServletRequest req, Model model) throws Exception {
		
		String move = null;
		String go = null;
		
		move = req.getParameter("move");
		
		if(move == null){
			go = "/guest/guest_joinus";
		
		}else{
			
			model.addAttribute("req", req);
			
			int cnt = dao.joinUs(model);
			
			model.addAttribute("cnt", cnt);
			req.getSession().setAttribute("msg", "500");
			
			go = "home";
		}
		
		return go;
		
	}

	@Override
	public String idCheckService(HttpServletRequest req, Model model) throws Exception {

		String id = req.getParameter("id");
		model.addAttribute("id", id);
		
		System.out.println("idCheck id : " + id);

		int cnt = dao.idCheck(model);
		
		if(cnt == 1){
			req.getSession().setAttribute("msg", "900");	
		
		}else{
			req.getSession().setAttribute("msg", "950");
		}
		
		model.addAttribute("cnt", cnt);
		
		return "/guest/guest_joinus";
	}

	@Override
	public String loginService(HttpServletRequest req, Model model) throws Exception {

		String go = null;
		String goNum = null;
		int cnt = 0;
		int checkCnt = 2;
		
		
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		goNum = req.getParameter("goNum");
		
		if(goNum == null){
			go = "/guest/guest_login";
		}
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("goNum", 1);
		
		System.out.println("goNum : " + goNum);
		
		if(goNum != null && goNum.equals("1")){	
			checkCnt = dao.login(model);
		}
		if(checkCnt == 1){
			model.addAttribute("goNum", 2);
			cnt = dao.login(model);
			
			if(cnt == 1){
				ArrayList<String> cartIsbn = new ArrayList<String>();
				ArrayList<String> cartCount = new ArrayList<String>();
				
				req.getSession().setAttribute("memId", id);
				req.getSession().setAttribute("msg", "300");
				req.getSession().setAttribute("cartIsbn", cartIsbn);
				req.getSession().setAttribute("cartCount", cartCount);
				
				/*if(req.getSession().getAttribute("memId").equals("host")){*/
				if(id.equals("host")){
					go = "/host/host";
				}else{
					go = "home";
				}
				System.out.println("go : " + go);
			}else if(cnt == 0){
				req.getSession().setAttribute("msg", "350");
				go = "/guest/guest_login";
			}
		}else if(checkCnt == 0){
			req.getSession().setAttribute("msg", "320");
			go = "/guest/guest_login";
		}
		return go;
	}

	@Override
	public String logoutService(HttpServletRequest req, Model model) {
		
		req.getSession().invalidate();
		req.getSession().setAttribute("msg", "700");
		
		return "home";
	}

	@Override
	public String mypageService(HttpServletRequest req, Model model) throws Exception {
		
		if(req.getSession().getAttribute("memId") != null){
			
			String cnt = null;
			cnt = req.getParameter("cnt");
			
			ArrayList<SalesInfoDTO> dtolist = new ArrayList<SalesInfoDTO>();

			ArrayList<SalesInfoDTO> searchList21 = new ArrayList<SalesInfoDTO>();
			ArrayList<SalesInfoDTO> searchList22 = new ArrayList<SalesInfoDTO>();
			
			model.addAttribute("id", req.getSession().getAttribute("memId"));
			System.out.println("model : " + model);
			if(cnt == null || cnt.equals("0")){
				dtolist = dao.getSalesInfo(model);
			}else{
				String name = req.getParameter("name");
					if(name.equals("title")){
						name = "b." + name;
					}else{
						name = "s."+name;
					}
				String value = req.getParameter("value");
				
				model.addAttribute("name", name);
				model.addAttribute("value", value);
				//select 23
				dtolist = dao.getSearch(model);
			}
			
			searchList21 = dao.getSearchTAI(model);
			System.out.println("searchList21 : " + searchList21);
			
			searchList22 = dao.getSearchState(model);
			System.out.println("searchList22 : " + searchList22);
			
			model.addAttribute("dtolist", dtolist);
			model.addAttribute("searchList21", searchList21);
			model.addAttribute("searchList22", searchList22);
			
		}
		
		
		return "/guest/guest_mypage";
	}

	@Override
	public String cartService(HttpServletRequest req, Model model) throws Exception {
		
		String go = "";
		//로그인 상태면 구매페이지 
		if(req.getSession().getAttribute("memId") != null){
			String cnt = req.getParameter("cnt");
			String pop = req.getParameter("pop");
			String isbn = req.getParameter("isbn");
			
			ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
			ArrayList<String> list1 = (ArrayList<String>)req.getSession().getAttribute("cartIsbn");
			ArrayList<String> list2 = (ArrayList<String>)req.getSession().getAttribute("cartCount");
		
			if(list1.isEmpty()){
				req.getSession().setAttribute("msg", "200");
				go = "home";
			}else{
				if(cnt != null && cnt.equals("1")){
					
					int delpop = Integer.parseInt(pop);
					list1.remove(delpop);
					list2.remove((delpop));
					
					cnt = "0";
				}
					
				if(list1.size() > 0){
					System.out.println("list.size1 : " + list1.size());
					System.out.println("list.size2 : " + list2.size());
					
					for(int i = 0; i < list1.size(); i++){
						System.out.println("i : " + i);
						model.addAttribute("isbn", list1.get(i));
					
						dtolist.addAll(dao.getCart(model));
						
						dtolist.get(i).setCartCount(list2.get(i));
						
					}
					
					model.addAttribute("dtolist", dtolist);
					
				}
				go = "/guest/guest_cart";
			}
		//비로그인 상태면 로그인페이지	
			}else{
				go = "/guest/guest_login";
			}
		return go;
	}

	@Override
	public String bookpageService(HttpServletRequest req, Model model) throws Exception {
		
		
		String isbn = req.getParameter("num");
		
		System.out.println("isbn : " + isbn);
		
		
		model.addAttribute("isbn",isbn);
		
		//4
		ArrayList<BookDTO> dtolist = dao.bookpage(model);
		
		model.addAttribute("dtolist", dtolist);
		
		return "/guest/guest_bookpage";
		
	}

	@Override
	public String buyService(HttpServletRequest req, Model model) throws Exception {

		String go = "";
		
		String count = null;
		String isbn = null;
		
		count = req.getParameter("count");
		isbn = req.getParameter("isbn");
		
		//로그인 상태면 구매페이지 
		if(req.getSession().getAttribute("memId") != null){
			
			model.addAttribute("id", req.getSession().getAttribute("memId"));
			model.addAttribute("isbn", isbn);
			model.addAttribute("count", count);
			
			int cnt = dao.buyBook(model);
			int bcnt = dao.setBuyBookCount(model);
			
			if(cnt == 1){
				System.out.println("판매 입력 성공");
			}
			if(bcnt == 1){
				System.out.println("book 테이블 수량 조절 성공");
			}
			req.getSession().setAttribute("msg", 100);
			go = "home";
		
		//비로그인 상태면 로그인페이지	
		}else{
		System.out.println("비로그인");
		go = "/guest/guest_login";
		
		}	
		return go;
	}

	@Override
	public String cartPutService(HttpServletRequest req, Model model) throws Exception {

		String go = "";
		//로그인 상태면 구매페이지 
		if(req.getSession().getAttribute("memId") != null){
			
			String isbn = req.getParameter("num");
			String count = req.getParameter("count");
			
			
			ArrayList<String> list1 = (ArrayList<String>)req.getSession().getAttribute("cartIsbn");
			ArrayList<String> list2 = (ArrayList<String>)req.getSession().getAttribute("cartCount");
			
			System.out.println("list1 : " + list1);
			System.out.println("list2 : " + list2);

			list1.add(isbn);
			list2.add(count);
			req.getSession().setAttribute("msg", "400");
			
			go = "home";
			
		//비로그인 상태면 로그인페이지	
		}else{
			go = "/guest/guest_login";
		}
		
		return go;
	}

	@Override
	public String cartBuyService(HttpServletRequest req, Model model) throws Exception {

		String go = "";
		
		if(req.getSession().getAttribute("memId") != null){
		
			int num = Integer.parseInt(req.getParameter("num"));
			
			int cnt = 0;
			int bcnt = 0;
			
			System.out.println("num : "+ num);
			
			for(int a = 0; a < num; a++){
				Map<String,String> map = new HashMap<String,String>();

				String id = (String)req.getSession().getAttribute("memId");
				
				model.addAttribute("id", id);
				model.addAttribute("isbn", req.getParameter("isbn"+a));
				model.addAttribute("count", req.getParameter("count"+a));

				cnt = dao.buyBook(model);
				bcnt = dao.setBuyBookCount(model);
			}
			
				if(cnt == 1){
					System.out.println("판매 입력 성공");
				}
				if(bcnt == 1){
					System.out.println("book 테이블 수량 조절 성공");
				}
				ArrayList<String> cartIsbn = new ArrayList<String>();
				ArrayList<String> cartCount = new ArrayList<String>();
				
				req.getSession().setAttribute("cartIsbn", cartIsbn);
				req.getSession().setAttribute("cartCount", cartCount);
				
				req.getSession().setAttribute("msg", "100");
				
				go = "home";
			
		
		//비로그인 상태면 로그인페이지	
		}else{
		
		go = "/guest/guest_login";
	}
	
		
		return go;
	}

	@Override
	public String infoModifyService(HttpServletRequest req, Model model) throws Exception {
		
		String go = "";
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		ArrayList<GuestDTO> dtos = new ArrayList<GuestDTO>();
		
		if(cnt == 0){
			model.addAttribute("cnt", 3);
			go = "/guest/guest_rePasswd";
		
		}else if(cnt == 1){
			String id = (String)req.getSession().getAttribute("memId");
			String pw = req.getParameter("pw");
			
			model.addAttribute("id", id);
			model.addAttribute("pw", pw);

			System.out.println("id : " + id );
			System.out.println("pw : " + pw );
			
			cnt = dao.checkIdPw(model);
			if(cnt == 1){
				System.out.println("스택오버플로어?");
				
				dtos = dao.getMember(model);

				model.addAttribute("dtos", dtos);
				
				go = "/guest/guest_infoModify";
			}else{
				req.getSession().setAttribute("msg", "350");
				model.addAttribute("cnt", 3);
				go = "/guest/guest_rePasswd";
			}
			
		}else if(cnt == 2){
			String addr1 = req.getParameter("addr1");
			String addr2 = req.getParameter("addr2");
			String gAddr = addr1+"@"+addr2;
			
			model.addAttribute("id", (String)req.getSession().getAttribute("memId"));
			model.addAttribute("pw", req.getParameter("pw"));
			model.addAttribute("addr", gAddr);
			model.addAttribute("email", req.getParameter("gEmail"));
			
			int dcnt = dao.setMember(model);

			req.getSession().setAttribute("msg", "600");

			go = "home";
				
		}
		return go;
		
	}

	@Override
	public String infoExitService(HttpServletRequest req, Model model) throws Exception {
		
		String go = "";
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		if(cnt == 0){
			model.addAttribute("cnt", 0);
			go = "/guest/guest_rePasswd";
		
		}else if(cnt == 1){
			
			cnt = 0;

			String id = (String)req.getSession().getAttribute("memId");
			String pw = req.getParameter("pw");

			model.addAttribute("id", id);
			model.addAttribute("pw", pw);
			
			cnt = dao.checkIdPw(model);
			
			if(cnt == 1){
				
				int dcnt = dao.infoExit(model);
				
				if(dcnt == 1){
					req.getSession().invalidate();
					req.getSession().setAttribute("msg", "800");
					go = "home";
				}
			}else{
					req.getSession().setAttribute("msg", "350");
					model.addAttribute("cnt", 0);
					go = "/guest/guest_rePasswd";
			}
		}
		
		return go;
	}

	@Override
	public String searchBookService(HttpServletRequest req, Model model) throws Exception {
		
		String go = "";
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();

		String title = req.getParameter("search");
		
		model.addAttribute("title", title);
		
		dtolist = dao.searchBook(model);
		
		model.addAttribute("dtolist", dtolist);
		
		if(cnt == 1){
			go = "/guest/searchBook";
		
		}else if(cnt == 2){
			go = "/host/host_stock";
		}
		return go;
	}

	@Override
	public String guestOrderService(HttpServletRequest req, Model model) throws Exception {
		String salesNum = req.getParameter("salesNum");
		
		ArrayList<String> list = new ArrayList<String>();
			
		model.addAttribute("salesNum",salesNum);
		model.addAttribute("state", "2");
		
		dao.changeState(model);
		
		return null;
	}

	@Override
	public String guestCancleService(HttpServletRequest req, Model model) throws Exception {

		String salesNum = req.getParameter("salesNum");
		String count = req.getParameter("count");
		String isbn = req.getParameter("isbn");
		
			
		model.addAttribute("salesNum",salesNum);
		model.addAttribute("state", "4");
		model.addAttribute("count", count);
		model.addAttribute("isbn", isbn);
		
		dao.changeState(model);
		dao.setCancleBookCount(model);
		
		return null;
	}

	@Override
	public String boardListService(HttpServletRequest req, Model model) throws Exception {
		int pageSize = 15;
		//출력할 페이지 개수
		int pageBlock = 3;
		
		//글 개수
		int cnt = 0;
		//현제 페이지 시작 번호 : rownum
		int start = 0;
		//현제 페이지 끝 번호 : rownum
		int end = 0;
		
		//출력할 글 번호
		int number = 0;
		//페이지 번호
		String pageNum = null; 	
		//현재 페이지
		int currentPage = 0; 	
		
		//페이지 개수
		int pageCount = 0; 		
		//시작 페이지
		int startPage = 0; 		
		//마지막 페이지
		int endPage = 0; 		
		
		//DAO 싱글톤, 다형성 적용해서 객체생성

		//글 개수 구하기
		
		cnt = dao.getBoardCount(); 
		
		pageNum = (req.getParameter("pageNum") == null) ? "1" : req.getParameter("pageNum"); 
		
		//현재 페이지
		currentPage = (Integer.parseInt(pageNum));
		//페이지 개수
		pageCount = (cnt/pageSize) + (cnt%pageSize > 0 ? 1 : 0);
		
		//현재페이지 시작 번호
		start = (currentPage - 1) * pageSize + 1;
		
		//현재페이지 끝 번호
		end = start + pageSize - 1;
		
		if(end > cnt){
			end = cnt;
		}
		
		//출력할 글 번호
		number = cnt - (currentPage - 1) * pageSize; 
		
		ArrayList<BoardDTO> dtolist = new ArrayList<BoardDTO>();

		model.addAttribute("start", start);
		model.addAttribute("end", end);
		
		if(cnt > 0){
			dtolist = dao.getBoard(model);
			model.addAttribute("dtolist", dtolist);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0){
			startPage -= pageBlock;
		}
		
		endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		model.addAttribute("cnt", cnt); 			//글 개수
		model.addAttribute("number", number); 	//글 번호
		model.addAttribute("pageNum", pageNum); 	//페이지 번호
		
		if(cnt > 0){
			model.addAttribute("cnt", cnt);
			model.addAttribute("startPage", startPage);	//시작 페이지
			model.addAttribute("endPage", endPage);		//마지막 페이지
			model.addAttribute("pageBlock", pageBlock);	//출력할 페이지 개수 : 3
			model.addAttribute("pageCount", pageCount);	//페이지 개수
			model.addAttribute("currentPage", currentPage);
		}

		return "/board/board_list";
	}

	@Override
	public String boardContentService(HttpServletRequest req, Model model) throws Exception {
		
		String num = req.getParameter("num");
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		
		ArrayList<BoardDTO> dtolist = new ArrayList<BoardDTO>();
		
		model.addAttribute("num", num);
		
		dtolist = dao.getBoardContent(model);
		dao.readCnt(model);
		
		model.addAttribute("dtolist", dtolist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		
		return "/board/board_content";
	}

	@Override
	public String boardModifyService(HttpServletRequest req, Model model) throws Exception {
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		String go = "";
		String pageNum = req.getParameter("pageNum");;
		String writer = req.getParameter("writer");;
		String num = req.getParameter("num");
		
		ArrayList<BoardDTO> dtolist = new ArrayList<BoardDTO>();
		
		//비번입력페이지
		if(cnt == 0){
			req.setAttribute("writer", writer);
			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("cnt", 3);
			
			go = "/board/board_pw";
			
		//비번확인
		}else if(cnt == 1){
			
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("num", num);
			
			model.addAttribute("writer",writer);
			model.addAttribute("pw",req.getParameter("pw"));

			cnt = dao.getBoardIdPw(model);
			
				if(cnt == 0){
					model.addAttribute("writer", writer);
					model.addAttribute("num", num);
					model.addAttribute("pageNum", pageNum);
					model.addAttribute("cnt", 3);
					
					go = "/board/board_pw";
				
				}else if(cnt == 1){

					model.addAttribute("num", num);
					
					dtolist = dao.getBoardContent(model);
					
					model.addAttribute("dtolist", dtolist);

					go = "/board/board_modify";	
				}
		
		}
		return go;
	}

	@Override
	public String boardModify2Service(HttpServletRequest req, Model model) throws Exception {
		model.addAttribute("subject", req.getParameter("subject"));
		model.addAttribute("content", req.getParameter("content"));
		model.addAttribute("pw", req.getParameter("passwd"));
		model.addAttribute("num", req.getParameter("num"));

		dao.setBoardContent(model);
		
		String pageNum = req.getParameter("pageNum");
		model.addAttribute("pageNum", pageNum);
		return "/board/board_list";
	}

	@Override
	public String boardDeleteService(HttpServletRequest req, Model model) throws Exception {
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		String go = "";
		String pageNum = req.getParameter("pageNum");;
		String writer = req.getParameter("writer");;
		String num = req.getParameter("num");
		
		//비번입력페이지
		if(cnt == 0){

			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("cnt", 4);
			req.setAttribute("writer", writer);
			
			go = "/board/board_pw";
			
		//비번확인
		}else if(cnt == 1){
			//host인 경우 관리자 삭제라고 뜸
			if(req.getSession().getAttribute("memId").equals("host") && !writer.equals("host")){
				
				model.addAttribute("num", num);

				dao.hostDelete(model);
				req.setAttribute("pageNum", pageNum);
				model.addAttribute("pageNum", pageNum);
				
				go = "board_list";
			}else{
			
				model.addAttribute("pageNum", pageNum);
				model.addAttribute("num", num);
				model.addAttribute("writer", writer);
				model.addAttribute("pw", req.getParameter("pw"));
				
				cnt = dao.getBoardIdPw(model);

				if(cnt == 0){
						
						model.addAttribute("num", num);
						model.addAttribute("pageNum", pageNum);
						model.addAttribute("cnt", 4);
						model.addAttribute("writer", writer);
						
						go = "/board/board_pw";
						System.out.println("cont = 0");
				}else if(cnt > 0){
						
						model.addAttribute(num);
						
						cnt = dao.deleteBoard(model);
						
						go = "/board/board_list";
						System.out.println("cont = 0");
					}
			}
		
		}
		return go;
	}

	@Override
	public String boardWriteService(HttpServletRequest req, Model model) throws Exception {

		int cnt = Integer.parseInt(req.getParameter("cnt"));
		String go = "";
		
		System.out.println("cnt : " + cnt);
		
		int num = (req.getParameter("num") == null) ? 0 : Integer.parseInt(req.getParameter("num"));
		int ref = (req.getParameter("ref") == null) ? 1 : Integer.parseInt(req.getParameter("ref"));
		int ref_step = (req.getParameter("ref_step") == null) ? 0 : Integer.parseInt(req.getParameter("ref_step"));
		int ref_level = (req.getParameter("ref_level") == null) ? 0 : Integer.parseInt(req.getParameter("ref_level"));
		
		if(cnt == 0){
			
			req.setAttribute("num", num);
			req.setAttribute("ref", ref);
			req.setAttribute("ref_step", ref_step);
			req.setAttribute("ref_level", ref_level);
			
			go = "/board/board_wirte";
		
		}else if(cnt == 3){
			System.out.println("cnt : " + cnt);
			int maxNum = 0;
			
			if(num == 0){
				maxNum = dao.boardMaxNum();
				
				if(maxNum > 0){
					ref = maxNum + 1;
					model.addAttribute("ref",ref);
				
				}else{
					ref = 1;
				}
				
				ref_level = 0;
				ref_step = 0;
				
			}else{
				model.addAttribute("ref",req.getParameter("ref"));
				model.addAttribute("ref_step",req.getParameter("ref_step"));
				
				dao.boardUpdateRef(model);
				ref_step++;
				ref_level++;
				
			}
			
			model.addAttribute("writer", req.getParameter("writer"));
			model.addAttribute("passwd", req.getParameter("passwd"));
			model.addAttribute("subject",req.getParameter("subject"));
			model.addAttribute("content",req.getParameter("content"));
			model.addAttribute("ref_level",ref_level);
			model.addAttribute("ref_step",ref_step);
			model.addAttribute("num",num);
			model.addAttribute("ref",ref);
			
			dao.boardNewWrite(model);
			
			go = "/board/board_list";
		}
		return go;
	}

	@Override
	public String searchBoardService(HttpServletRequest req, Model model) throws Exception {
		
		
		int pageSize = (req.getParameter("pageSize") == null) ? 15 : Integer.parseInt(req.getParameter("pageSize")); 
		
		//출력할 페이지 개수
		int pageBlock = 3;
		
		//글 개수
		int cnt = 0;
		//현제 페이지 시작 번호 : rownum
		int start = 0;
		//현제 페이지 끝 번호 : rownum
		int end = 0;
		
		//출력할 글 번호
		int number = 0;
		//페이지 번호
		String pageNum = pageNum = (req.getParameter("pageNum") == null) ? "1" : req.getParameter("pageNum"); 
		//현재 페이지
		int currentPage = 0; 	
		
		//페이지 개수
		int pageCount = 0; 		
		//시작 페이지
		int startPage = 0; 		
		//마지막 페이지
		int endPage = 0; 		
		
		//DAO 싱글톤, 다형성 적용해서 객체생성
		
		String search = req.getParameter("search"); 
		
		model.addAttribute("search", search);
		
		//글 개수 구하기
		cnt = dao.getSearchBoardCount(model);
		
		//현재 페이지
		currentPage = (Integer.parseInt(pageNum));
		//페이지 개수
		pageCount = (cnt/pageSize) + (cnt%pageSize > 0 ? 1 : 0);
		
		//현재페이지 시작 번호
		start = (currentPage - 1) * pageSize + 1;
		
		//현재페이지 끝 번호
		end = start + pageSize - 1;
		
		if(end > cnt){
			end = cnt;
		}
		
		//출력할 글 번호
		number = cnt - (currentPage - 1) * pageSize; 
		
		ArrayList<BoardDTO> dtolist = new ArrayList<BoardDTO>();
		
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		
		if(cnt > 0){
			dtolist = dao.getSearchBoard(model);
			model.addAttribute("dtolist", dtolist);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0){
			startPage -= pageBlock;
		}
		
		endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		req.setAttribute("cnt", cnt); 			//글 개수
		req.setAttribute("number", number); 	//글 번호
		req.setAttribute("pageNum", pageNum); 	//페이지 번호
		
		if(cnt > 0){
			req.setAttribute("cnt", cnt);
			req.setAttribute("startPage", startPage);	//시작 페이지
			req.setAttribute("endPage", endPage);		//마지막 페이지
			req.setAttribute("pageBlock", pageBlock);	//출력할 페이지 개수 : 3
			req.setAttribute("pageCount", pageCount);	//페이지 개수
			req.setAttribute("currentPage", currentPage);
		}
		

		return "/board/board_list";
	}

	@Override
	public String hostService(HttpServletRequest req, Model model) throws Exception {

		return "/host/host";
	}

	@Override
	public String hostStockService(HttpServletRequest req, Model model) throws Exception {

		//한 페이지 당 출력할 글 개수
				int pageSize = (req.getParameter("pageSize") == null) ? 5 : Integer.parseInt(req.getParameter("pageSize"));
				
				//출력할 페이지 개수
				int pageBlock = 3;
				
				//글 개수
				int cnt = 0;
				//현제 페이지 시작 번호 : rownum
				int start = 0;
				//현제 페이지 끝 번호 : rownum
				int end = 0;
				
				//출력할 글 번호
				int number = 0;
				//현재 페이지
				int currentPage = 0; 	
				
				//페이지 개수
				int pageCount = 0; 		
				//시작 페이지
				int startPage = 0; 		
				//마지막 페이지
				int endPage = 0; 		
				
				//글 개수 구하기
				cnt = dao.getbookCount();
				
				String pageNum = (req.getParameter("pageNum") == null) ? "1" : req.getParameter("pageNum");
				//현재 페이지
				currentPage = (Integer.parseInt(pageNum));
				//페이지 개수
				pageCount = (cnt/pageSize) + (cnt%pageSize > 0 ? 1 : 0);
				
				//현재페이지 시작 번호
				start = (currentPage - 1) * pageSize + 1;
				
				//현재페이지 끝 번호
				end = start + pageSize - 1;
				
				if(end > cnt){
					end = cnt;
				}
				
				//출력할 글 번호
				number = cnt - (currentPage - 1) * pageSize; 
				
				ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
				
				model.addAttribute("start", start);
				model.addAttribute("end", end);
				
				if(cnt > 0){
					model.addAttribute("id", null);
					dtolist = dao.getBookInfo(model);
					model.addAttribute("dtolist", dtolist);
					System.out.println(dtolist.get(0).getTitle());
				}
				
				startPage = (currentPage / pageBlock) * pageBlock + 1;
				if(currentPage % pageBlock == 0){
					startPage -= pageBlock;
				}
				
				endPage = startPage + pageBlock - 1;
				if(endPage > pageCount){
					endPage = pageCount;
				}
				
				req.setAttribute("cnt", cnt); 			//글 개수
				req.setAttribute("number", number); 	//글 번호
				req.setAttribute("pageNum", pageNum); 	//페이지 번호
				
				if(cnt > 0){
					req.setAttribute("cnt", cnt);
					req.setAttribute("startPage", startPage);	//시작 페이지
					req.setAttribute("endPage", endPage);		//마지막 페이지
					req.setAttribute("pageBlock", pageBlock);	//출력할 페이지 개수 : 3
					req.setAttribute("pageCount", pageCount);	//페이지 개수
					req.setAttribute("currentPage", currentPage);
				}
				
				return "/host/host_stock";
	}

	@Override
	public String hostStockModifyService(HttpServletRequest req, Model model) throws Exception {
		
		model.addAttribute("isbn", req.getParameter("isbn"));
		model.addAttribute("title",req.getParameter("title"));
		model.addAttribute("author",req.getParameter("author"));
		model.addAttribute("publisher",req.getParameter("publisher"));
		model.addAttribute("price",req.getParameter("price"));
		model.addAttribute("count",req.getParameter("count"));
		model.addAttribute("subTitle",req.getParameter("subTitle"));
		model.addAttribute("trans",req.getParameter("trans"));
		model.addAttribute("exIsbn",req.getParameter("exIsbn"));
		
		dao.setBookInfo(model);
		
		return null;
	}

	@Override
	public String hostStockDeleteService(HttpServletRequest req, Model model) throws Exception {
		
		model.addAttribute("isbn", req.getParameter("isbn"));
		
		dao.hostDeleteStock(model);
		
		return null;
	}

	@Override
	public String hostStockAddeService(HttpServletRequest req, Model model) throws Exception {
			
		model.addAttribute("isbn", req.getParameter("isbn"));
		model.addAttribute("title", req.getParameter("title"));
		model.addAttribute("author", req.getParameter("author"));
		model.addAttribute("publisher", req.getParameter("publisher"));
		model.addAttribute("price", req.getParameter("price"));
		model.addAttribute("count", req.getParameter("count"));
		model.addAttribute("subTitle", req.getParameter("subTitle"));
		model.addAttribute("trans", req.getParameter("trans"));
		
		dao.hostAddStock(model);
		
		return null;
	}

	@Override
	public String hostBookSearchService(HttpServletRequest req, Model model) throws Exception {
		
		//한 페이지 당 출력할 글 개수
				int pageSize = (req.getParameter("pageSize") == null) ? 5 : Integer.parseInt(req.getParameter("pageSize"));
						
				int pageBlock = 3;
				
				//글 개수
				int cnt = 0;
				//현제 페이지 시작 번호 : rownum
				int start = 0;
				//현제 페이지 끝 번호 : rownum
				int end = 0;
				
				//출력할 글 번호
				int number = 0;
				//페이지 번호
				String pageNum = (req.getParameter("pageNum") == null) ? "1" : req.getParameter("pageNum");
				System.out.println("pageNum : " + pageNum);
				//현재 페이지
				int currentPage = 0; 	
				
				//페이지 개수
				int pageCount = 0; 		
				//시작 페이지
				int startPage = 0; 		
				//마지막 페이지
				int endPage = 0; 		
				
				//DAO 싱글톤, 다형성 적용해서 객체생성
				
				String search = req.getParameter("search"); 
				model.addAttribute("title", search);

				//글 개수 구하기
				cnt = dao.searchBookCount(model);
				
				//현재 페이지
				currentPage = (Integer.parseInt(pageNum));
				//페이지 개수
				pageCount = (cnt/pageSize) + (cnt%pageSize > 0 ? 1 : 0);
				
				//현재페이지 시작 번호
				start = (currentPage - 1) * pageSize + 1;
				
				//현재페이지 끝 번호
				end = start + pageSize - 1;
				
				if(end > cnt){
					end = cnt;
				}
				
				//출력할 글 번호
				number = cnt - (currentPage - 1) * pageSize; 
				
				ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
				
				if(cnt > 0){
					model.addAttribute("start", start);
					model.addAttribute("end", end);
					System.out.println("start  : " + start);
					System.out.println("end  : " + end);
					dtolist = dao.getSearchBookInfo(model);
					
					req.setAttribute("dtolist", dtolist);
					System.out.println("dtolist : " + dtolist);
				}
				
				startPage = (currentPage / pageBlock) * pageBlock + 1;
				if(currentPage % pageBlock == 0){
					startPage -= pageBlock;
				}
				
				endPage = startPage + pageBlock - 1;
				if(endPage > pageCount){
					endPage = pageCount;
				}
				
				req.setAttribute("cnt", cnt); 			//글 개수
				req.setAttribute("number", number); 	//글 번호
				req.setAttribute("pageNum", pageNum); 	//페이지 번호
				
				if(cnt > 0){
					req.setAttribute("cnt", cnt);
					req.setAttribute("startPage", startPage);	//시작 페이지
					req.setAttribute("endPage", endPage);		//마지막 페이지
					req.setAttribute("pageBlock", pageBlock);	//출력할 페이지 개수 : 3
					req.setAttribute("pageCount", pageCount);	//페이지 개수
					req.setAttribute("currentPage", currentPage);
					req.setAttribute("search", "1");
					req.setAttribute("search", search);
				}
				
				return "/host/host_stock";
	}

	@Override
	public String hostOrderListService(HttpServletRequest req, Model model) throws Exception {
		//guest id
		ArrayList<SalesInfoDTO> guestIdList = new ArrayList<SalesInfoDTO>();
		//isbn title
		ArrayList<SalesInfoDTO> searchList = new ArrayList<SalesInfoDTO>();
		//state
		ArrayList<SalesInfoDTO> searchListState = new ArrayList<SalesInfoDTO>();

		guestIdList = dao.getSearchGuestId(model);
		searchList = dao.getSearchTAI(model);
		searchListState = dao.getSearchState(model);
		
		System.out.println("guestIdList : " + guestIdList);
		System.out.println("searchList : " + searchList);
		System.out.println("searchListState : " + searchListState);
		
		req.setAttribute("searchList", searchList);
		req.setAttribute("searchListState", searchListState);
		req.setAttribute("guestIdList", guestIdList);
		
		return "/host/host_order";
	}

	@Override
	public String hostOrderAgreeService(HttpServletRequest req, Model model) throws Exception {


		
		return null;
	}

	@Override
	public String imgUpLoadService(HttpServletRequest req, Model model) throws Exception {
		
		MultipartRequest mr = null;
		// 업로드할 파일의 최대 사이즈(10 * 1024 * 1024 = 10MB)
		int maxSize = 10 * 1024 * 1024;
		// 임시 파일이 저장되는 논리적인 경로
		String saveDir = req.getRealPath("bms/resources/Images/imagebyin/");
		// 업로드할 파일이 위치하게될 물리적인 경로
		String realDir = "C:\\DEV\\Project\\BMS_JSP_V4\\WebContent\\BMS\\Images\\imagebyin\\";
		// 인코딩 타입 : 한글 파일명이 열화되는 것을 방지함
		String encType = "UTF-8";
		try {
		
		
		mr = new MultipartRequest(req, saveDir, maxSize, encType, new DefaultFileRenamePolicy());
		FileInputStream fis = new FileInputStream(saveDir + mr.getFilesystemName("img"));
		FileOutputStream fos = new FileOutputStream(realDir + mr.getFilesystemName("img"));
		int data = 0;
		// 논리적인 경로에 저장된 임시 파일을 물리적인 경로로 복사함
		while((data = fis.read()) != -1) {
		fos.write(data);
		}
		fis.close();
		fos.close();
		

		} catch (Exception e) {
		e.printStackTrace();
		}

		
		return "/host/host_stock";
	}

	@Override
	public String hostOrderViewService(HttpServletRequest req, Model model) throws Exception {

		String name = req.getParameter("name") == null ? null : req.getParameter("name");
		String value = req.getParameter("value") == null ? null : req.getParameter("value");
		String pageNum = req.getParameter("pageNum") == null ? "1" : req.getParameter("pageNum");	
		int pageSize = req.getParameter("orderSize") == null ? 5 : Integer.parseInt(req.getParameter("orderSize"));
		String searchCnt = req.getParameter("searchCnt") == null ? "0" : req.getParameter("searchCnt");		

		//
		String agreeCnt = req.getParameter("agreeCnt") == null ? null : req.getParameter("agreeCnt");
		String salesNum = req.getParameter("salesNum") == null ? null : req.getParameter("salesNum");
		String count = req.getParameter("count") == null ? null : req.getParameter("count");
		String isbn = req.getParameter("isbn") == null ? null : req.getParameter("isbn");
		
		//출력할 페이지 개수
		int pageBlock = 3;
		
		//글 개수
		int cnt = 0;
		//현제 페이지 시작 번호 : rownum
		int start = 0;
		//현제 페이지 끝 번호 : rownum
		int end = 0;
		
		//출력할 글 번호
		int number = 0;
		//페이지 번호
		 	
		//현재 페이지
		int currentPage = 0; 	
		
		//페이지 개수
		int pageCount = 0; 		
		//시작 페이지
		int startPage = 0; 		
		//마지막 페이지
		int endPage = 0; 		
		
		model.addAttribute("salesNum", salesNum);
		
		if(agreeCnt != null){
			if(agreeCnt.equals("1")){
				model.addAttribute("state", "1");
				model.addAttribute("count" ,count);
				dao.changeState(model);
			}else if(agreeCnt.equals("2")){
				model.addAttribute("state", "3");
				model.addAttribute("count" ,count);
				model.addAttribute("isbn", isbn);
				dao.changeState(model);
				dao.setCancleBookCount(model);
			}
		}
		
		if(searchCnt.equals("0") || searchCnt == null){
			
			cnt = dao.getSalesInfoCount();
			
		}else{
			if(name.equals("title")){
				name = "b." + name;
				System.out.println("b.+name : " + name);
			}else{
				name = "s."+name;
				System.out.println("s.+name : " + name);
			}
			model.addAttribute("name", name);
			model.addAttribute("value", value);
			
			cnt = dao.getSalesSelectCount(model);
		}
		
		//현재 페이지
		currentPage = (Integer.parseInt(pageNum));
		//페이지 개수
		pageCount = (cnt/pageSize) + (cnt%pageSize > 0 ? 1 : 0);
		
		//현재페이지 시작 번호
		start = (currentPage - 1) * pageSize + 1;
		
		//현재페이지 끝 번호
		end = start + pageSize - 1;
		
		if(end > cnt){
			end = cnt;
		}
		
		//출력할 글 번호
		number = cnt - (currentPage - 1) * pageSize; 
		
		ArrayList<SalesInfoDTO> dtolist = new ArrayList<SalesInfoDTO>();
		
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		if(cnt > 0){
			
			if(searchCnt == null || searchCnt.equals("0")){
				dtolist = dao.getHostSalesInfo2(model);
			}else{
				
				model.addAttribute("name", name);
				model.addAttribute("value", value);
				System.out.println("name1 : " + name);
				System.out.println("value1 : " + value);
				
				dtolist = dao.getSalesSelectInfo2(model); 		
			}
		
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0){
			startPage -= pageBlock;
		}
		
		endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		req.setAttribute("cnt", cnt); 			//글 개수
		req.setAttribute("number", number); 	//글 번호
		req.setAttribute("pageNum", pageNum); 	//페이지 번호
		
		if(cnt > 0){
			req.setAttribute("cnt", cnt);
			req.setAttribute("startPage", startPage);	//시작 페이지
			req.setAttribute("endPage", endPage);		//마지막 페이지
			req.setAttribute("pageBlock", pageBlock);	//출력할 페이지 개수 : 3
			req.setAttribute("pageCount", pageCount);	//페이지 개수
			req.setAttribute("currentPage", currentPage);
			
			System.out.println("dtolist : " + dtolist);
			req.setAttribute("dtolist", dtolist);
			
		}
		
		return "/host/order_view";
	}

	@Override
	public String settlementService(HttpServletRequest req, Model model) throws Exception {
		
		ArrayList<SalesInfoDTO> searchList = new ArrayList<SalesInfoDTO>();
		ArrayList<SalesInfoDTO> guestIdList = new ArrayList<SalesInfoDTO>();

		guestIdList = dao.getSearchGuestId(model);
		searchList = dao.getSearchTAI(model);
		
		req.setAttribute("searchList", searchList);
		req.setAttribute("guestIdList", guestIdList);
		
		return "/host/host_settlement";
	}

	@Override
	public String settlementProService(HttpServletRequest req, Model model) throws Exception {

		String go = req.getParameter("go") == null ? "settlement" : req.getParameter("go");
		String destination = null;
		
		String name = req.getParameter("name") == null ? null : req.getParameter("name");
		String value = req.getParameter("value") == null ? null : req.getParameter("value");
		String pageNum = req.getParameter("pageNum") == null ? "1" : req.getParameter("pageNum");	
		String searchCnt = req.getParameter("searchCnt") == null ? "0" : req.getParameter("searchCnt");	
		String daySelect = req.getParameter("daySelect") == null ? "0" : req.getParameter("daySelect");
		String startDay = req.getParameter("startDate") == null ? null : req.getParameter("startDate");
		String endDay = req.getParameter("endDate") == null ? null : req.getParameter("endDate");
		int clickMonth = req.getParameter("clickMonth") == null ? 0 :Integer.parseInt(req.getParameter("clickMonth"));
		Date startDate = null;
		Date endDate = null;
		String stDate = "";
		String edDate = "";
		int closing = 0;
		
		if(startDay != "" && startDay != null) {
			DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			startDate = sdFormat.parse(startDay);
			endDate = sdFormat.parse(endDay);
		}

		System.out.println("name : " + name);
		System.out.println("value : " + value);
		System.out.println("searchCnt : " + searchCnt);
		System.out.println("daySelect : " + daySelect);
		
		
		//출력할 페이지 개수
		int pageBlock = 3;
		int pageSize = 30;
		
		//글 개수
		int cnt = 0;
		//현제 페이지 시작 번호 : rownum
		int start = 0;
		//현제 페이지 끝 번호 : rownum
		int end = 0;
		
		//출력할 글 번호
		int number = 0;
		//페이지 번호
		 	
		//현재 페이지
		int currentPage = 0; 	
		
		//페이지 개수
		int pageCount = 0; 		
		//시작 페이지
		int startPage = 0; 		
		//마지막 페이지
		int endPage = 0; 		
		
		if(daySelect.equals("0") || daySelect == null){
			if(searchCnt.equals("0") || searchCnt == null){
				
				cnt = dao.getSalesInfoCountState1(model);
				
			}else if(searchCnt.equals("99")){
				if(name.equals("title")){
					name = "b." + name;
					System.out.println("b.+name : " + name);
				}else{
					name = "s."+name;
					System.out.println("s.+name : " + name);
				}
				model.addAttribute("name", name);
				model.addAttribute("value", value);
	
				cnt = dao.getSalesSelectCountState1(model);
			
			}
		
		}else if(daySelect.equals("50")){
			
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
			
			if(searchCnt.equals("0") || searchCnt == null){
				cnt = dao.getSalesInfoCountState1(model);
				
			}else if(searchCnt.equals("99")){
				if(name.equals("title")){
					name = "b." + name;
					System.out.println("b.+name : " + name);
				}else{
					name = "s."+name;
					System.out.println("s.+name : " + name);
				}
				model.addAttribute("name", name);
				model.addAttribute("value", value);
	
				cnt = dao.getSalesSelectCountState1(model);
			
			}
		}else if(daySelect.equals("60")){
			stDate = "2017-" + clickMonth + "-01";
			if(clickMonth == 12) {
				edDate = "2018-01-01";
			}else {
				edDate = "2017-" + (clickMonth+1) + "-01";
			}
			model.addAttribute("stDate", stDate);
			model.addAttribute("edDate", edDate);
			
			System.out.println("stDate : " + stDate);
			System.out.println("edDate" + edDate);
			
			if(searchCnt.equals("0") || searchCnt == null){
				cnt = dao.getSalesInfoCountState1(model);
				
			}else if(searchCnt.equals("99")){
				if(name.equals("title")){
					name = "b." + name;
					System.out.println("b.+name : " + name);
				}else{
					name = "s."+name;
					System.out.println("s.+name : " + name);
				}
				model.addAttribute("name", name);
				model.addAttribute("value", value);
	
				cnt = dao.getSalesSelectCountState1(model);
			}
		}
		System.out.println("cnt : " + cnt);
		//현재 페이지
		currentPage = (Integer.parseInt(pageNum));
		//페이지 개수
		pageCount = (cnt/pageSize) + (cnt%pageSize > 0 ? 1 : 0);
		
		//현재페이지 시작 번호
		start = (currentPage - 1) * pageSize + 1;
		
		//현재페이지 끝 번호
		end = start + pageSize - 1;
		
		if(end > cnt){
			end = cnt;
		}
		
		//출력할 글 번호
		number = cnt - (currentPage - 1) * pageSize; 
		
		ArrayList<SalesInfoDTO> dtolist = new ArrayList<SalesInfoDTO>();
		ArrayList<SalesInfoDTO> dtol = new ArrayList<SalesInfoDTO>();
		ArrayList<SalesInfoDTO> sattlementStock = new ArrayList<SalesInfoDTO>();
		
		
		if(cnt > 0){
			model.addAttribute("start", start);
			model.addAttribute("end", end);
			
			if(daySelect.equals("0") || daySelect == null){
				if(searchCnt == null || searchCnt.equals("0")){
					dtolist = dao.getHostSalesInfo(model);
					
					
					model.addAttribute("start", 0);
					model.addAttribute("end", 9999);
					
					dtol = dao.getHostSalesInfo(model);
				}else{
					
					model.addAttribute("name", name);
					model.addAttribute("value", value);
					
					dtolist = dao.getSalesSelectInfo(model); 		

					dtol = dao.getSalesSelectInfo(model);
				}
				closing = 0;
				int sum = 0;
				
				if(dtol.get(0).getPrice() != null) {
					sum +=  (Integer.parseInt(dtol.get(0).getPrice()) * Integer.parseInt(dtol.get(0).getSalesstock()));
					if(dtol.size() == 1 || !dtol.get(0).getSalesDay().equals(dtol.get(1).getSalesDay())) {
						SalesInfoDTO dto = new SalesInfoDTO();
						
						DateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date date2 = dtol.get(0).getSalesDay();
						String amon = sFormat.format(date2);
						String amonth[] = amon.split("-");
						
						dto.setYear(amonth[0]);
						dto.setMonth(amonth[1]);
						dto.setDay(amonth[2]);
						dto.setClosing(sum);
						sattlementStock.add(dto);

						closing += sum;
						sum = 0;
					}
				}
				
				for(int i = 1; i < dtol.size(); i++){
					SalesInfoDTO dto = new SalesInfoDTO();
					DateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = dtol.get(i-1).getSalesDay();
					String bmon = sFormat.format(date);
					Date date2 = dtol.get(i).getSalesDay();
					String amon = sFormat.format(date2);
					Date date3 = null;
					String a2mon = null;
					String[] a2month = null;
					if(i < dtol.size()-1) {
						date3 = dtol.get(i+1).getSalesDay();
						a2mon = sFormat.format(date3);
						a2month = a2mon.split("-");
					}
					
					String bmonth[] = bmon.split("-");
					String amonth[] = amon.split("-");
					
					if(i < dtol.size()-1) {
						if(i > 0 && bmonth[1].equals(amonth[1])) {
							if(bmonth[2].equals(amonth[2])) {
								sum +=  (Integer.parseInt(dtol.get(i).getPrice()) * Integer.parseInt(dtol.get(i).getSalesstock()));
								continue;
							}else {
								dto.setYear(bmonth[0]);
								dto.setMonth(bmonth[1]);
								dto.setDay(bmonth[2]);
								dto.setClosing(sum);
								sattlementStock.add(dto);
								closing += sum;
								sum = 0;

								if(amonth[2].equals(a2month[2])) {
									sum +=  (Integer.parseInt(dtol.get(i).getPrice()) * Integer.parseInt(dtol.get(i).getSalesstock()));
								}
								
								if(!amonth[2].equals(a2month[2])) {
									sum +=  (Integer.parseInt(dtol.get(i+1).getPrice()) * Integer.parseInt(dtol.get(i+1).getSalesstock()));
								}
							}
						}else {
							dto.setYear(bmonth[0]);
							dto.setMonth(bmonth[1]);
							dto.setDay(bmonth[2]);
							dto.setClosing(sum);
							sattlementStock.add(dto);
							closing += sum;
							sum = 0;
							
							sum +=  (Integer.parseInt(dtol.get(i).getPrice()) * Integer.parseInt(dtol.get(i).getSalesstock()));

							if(!amonth[2].equals(a2month[2])) {
								SalesInfoDTO dtos = new SalesInfoDTO();
								dtos.setYear(amonth[0]);
								dtos.setMonth(amonth[1]);
								dtos.setDay(amonth[2]);
								dtos.setClosing(sum);
								sattlementStock.add(dtos);
								closing += sum;
								sum = 0;
							}
						}
						
					}else {
						if(i > 0 && bmonth[1].equals(amonth[1])) {
							if(bmonth[2].equals(amonth[2])) {
								sum +=  (Integer.parseInt(dtol.get(i).getPrice()) * Integer.parseInt(dtol.get(i).getSalesstock()));
								dto.setYear(bmonth[0]);
								dto.setMonth(bmonth[1]);
								dto.setDay(bmonth[2]);
								dto.setClosing(sum);
								sattlementStock.add(dto);
								closing += sum;
								sum = 0;
							}else {
								sum +=  (Integer.parseInt(dtol.get(i).getPrice()) * Integer.parseInt(dtol.get(i).getSalesstock()));
								dto.setYear(amonth[0]);
								dto.setMonth(amonth[1]);
								dto.setDay(amonth[2]);
								dto.setClosing(sum);
								sattlementStock.add(dto);
								closing += sum;
								sum = 0;
							}
						}else if(i > 0 && !bmonth[1].equals(amonth[1])){
							sum +=  (Integer.parseInt(dtol.get(i).getPrice()) * Integer.parseInt(dtolist.get(i).getSalesstock()));
							dto.setYear(amonth[0]);
							dto.setMonth(amonth[1]);
							dto.setDay(amonth[2]);
							dto.setClosing(sum);
							sattlementStock.add(dto);
							closing += sum;
							sum = 0;
						}
					}
				}
				
			}else if(daySelect.equals("50")){
				model.addAttribute("startDate", startDate);
				model.addAttribute("endDate", endDate);
				
				if(searchCnt == null || searchCnt.equals("0")){
					dtolist = dao.getHostSalesInfo(model);
				}else{
					
					model.addAttribute("name", name);
					model.addAttribute("value", value);
					
					dtolist = dao.getSalesSelectInfo(model); 		
				}
				closing = 0;
				int sum = 0;
				
				if(dtolist.get(0).getPrice() != null) {
					sum +=  (Integer.parseInt(dtolist.get(0).getPrice()) * Integer.parseInt(dtolist.get(0).getSalesstock()));
					if(!dtolist.get(0).getSalesDay().equals(dtolist.get(1).getSalesDay())) {
						closing += sum;
					}
				}
				for(int i = 1; i < dtolist.size(); i++){
					SalesInfoDTO dto = new SalesInfoDTO();
					
					DateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = dtolist.get(i-1).getSalesDay();
					String bmon = sFormat.format(date);
					Date date2 = dtolist.get(i).getSalesDay();
					String amon = sFormat.format(date2);
					Date date3 = null;
					String a2mon = null;
					String[] a2month = null;
					if(i < dtolist.size()-1) {
						date3 = dtolist.get(i+1).getSalesDay();
						a2mon = sFormat.format(date3);
						a2month = a2mon.split("-");
					}
					
					String bmonth[] = bmon.split("-");
					String amonth[] = amon.split("-");
					
					if(i < dtolist.size()-1) {
						if(i > 0 && bmonth[1].equals(amonth[1])) {
							sum +=  (Integer.parseInt(dtolist.get(i).getPrice()) * Integer.parseInt(dtolist.get(i).getSalesstock()));
							if(!amonth[1].equals(a2month[1])) {
								sum +=  (Integer.parseInt(dtolist.get(i+1).getPrice()) * Integer.parseInt(dtolist.get(i+1).getSalesstock()));
							}
							continue;
							
						}else {
							dto.setYear(bmonth[0]);
							dto.setMonth(bmonth[1]);
							dto.setClosing(sum);
							sattlementStock.add(dto);
							closing += sum;
							sum = 0;
							if(!amonth[1].equals(a2month[1])) {
								sum +=  (Integer.parseInt(dtolist.get(i+1).getPrice()) * Integer.parseInt(dtolist.get(i+1).getSalesstock()));
							}
						}
					}else {
						if(i > 0 && bmonth[1].equals(amonth[1])) {
							sum +=  (Integer.parseInt(dtolist.get(i).getPrice()) * Integer.parseInt(dtolist.get(i).getSalesstock()));
							dto.setYear(bmonth[0]);
							dto.setMonth(bmonth[1]);
							dto.setClosing(sum);
							sattlementStock.add(dto);
							closing += sum;
							sum = 0;
						}else {
							sum +=  (Integer.parseInt(dtolist.get(i).getPrice()) * Integer.parseInt(dtolist.get(i).getSalesstock()));
							dto.setYear(amonth[0]);
							dto.setMonth(amonth[1]);
							dto.setClosing(sum);
							sattlementStock.add(dto);
							closing += sum;
							sum = 0;
						}
					}
				}
			}else if(daySelect.equals("60")){
				stDate = "2017-" + clickMonth + "-01";
				if(clickMonth == 12) {
					edDate = "2018-01-01";
				}else {
					edDate = "2017-" + (clickMonth+1) + "-01";
				}

				model.addAttribute("stDate", stDate);
				model.addAttribute("edDate", edDate);	
				
				if(searchCnt == null || searchCnt.equals("0")){
					dtolist = dao.getHostSalesInfo(model);
				}else{
					dtolist = dao.getSalesSelectInfo(model); 		
				}
				closing = 0;
				int sum = 0;
				
				if(dtolist.get(0).getPrice() != null) {
					sum +=  (Integer.parseInt(dtolist.get(0).getPrice()) * Integer.parseInt(dtolist.get(0).getSalesstock()));
					if(dtolist.size() == 1 || !dtolist.get(0).getSalesDay().equals(dtolist.get(1).getSalesDay())) {
						SalesInfoDTO dto = new SalesInfoDTO();
						
						DateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date date = dtolist.get(0).getSalesDay();
						String bmon = sFormat.format(date);
						String bmonth[] = bmon.split("-");
						
						dto.setYear(bmonth[0]);
						dto.setMonth(bmonth[1]);
						dto.setDay(bmonth[2]);
						dto.setClosing(sum);
						sattlementStock.add(dto);
						closing += sum;
						sum = 0;
					}
				}
				for(int i = 1; i < dtolist.size(); i++){
					SalesInfoDTO dto = new SalesInfoDTO();
					DateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = dtolist.get(i-1).getSalesDay();
					String bmon = sFormat.format(date);
					Date date2 = dtolist.get(i).getSalesDay();
					String amon = sFormat.format(date2);
					Date date3 = null;
					String a2mon = null;
					String[] a2month = null;
					if(i < dtolist.size()-1) {
						date3 = dtolist.get(i+1).getSalesDay();
						a2mon = sFormat.format(date3);
						a2month = a2mon.split("-");
					}
					
					String bmonth[] = bmon.split("-");
					String amonth[] = amon.split("-");

					if(i < dtolist.size()-1) {
						if(i > 0 && bmonth[2].equals(amonth[2])) {
							sum +=  (Integer.parseInt(dtolist.get(i).getPrice()) * Integer.parseInt(dtolist.get(i).getSalesstock()));
							
							if(!amonth[2].equals(a2month[2])) {
								dto.setYear(amonth[0]);
								dto.setMonth(amonth[1]);
								dto.setDay(amonth[2]);
								dto.setClosing(sum);
								sattlementStock.add(dto);
								closing += sum;
								sum = 0;
								sum +=  (Integer.parseInt(dtolist.get(i+1).getPrice()) * Integer.parseInt(dtolist.get(i+1).getSalesstock()));
							}
							continue;
							
						}else {
							if(!amonth[2].equals(a2month[2])) {
								dto.setYear(bmonth[0]);
								dto.setMonth(bmonth[1]);
								dto.setDay(bmonth[2]);
								dto.setClosing(sum);
								sattlementStock.add(dto);
								closing += sum;
								sum = 0;
								sum +=  (Integer.parseInt(dtolist.get(i).getPrice()) * Integer.parseInt(dtolist.get(i).getSalesstock()));
							}
						}
					}else {
						if(i > 0 && bmonth[2].equals(amonth[2])) {
							sum +=  (Integer.parseInt(dtolist.get(i).getPrice()) * Integer.parseInt(dtolist.get(i).getSalesstock()));
							dto.setYear(bmonth[0]);
							dto.setMonth(bmonth[1]);
							dto.setDay(bmonth[2]);
							dto.setClosing(sum);
							sattlementStock.add(dto);
							closing += sum;
							sum = 0;
						}else {
							sum +=  (Integer.parseInt(dtolist.get(i).getPrice()) * Integer.parseInt(dtolist.get(i).getSalesstock()));
							dto.setYear(amonth[0]);
							dto.setMonth(amonth[1]);
							dto.setDay(amonth[2]);
							dto.setClosing(sum);
							sattlementStock.add(dto);
							closing += sum;
							sum = 0;
						}
					}
				}
			}
		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0){
			startPage -= pageBlock;
		}
		
		endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		req.setAttribute("cnt", cnt); 			//글 개수
		req.setAttribute("number", number); 	//글 번호
		req.setAttribute("pageNum", pageNum); 	//페이지 번호
		
		if(cnt > 0){
			req.setAttribute("cnt", cnt);
			req.setAttribute("startPage", startPage);	//시작 페이지
			req.setAttribute("endPage", endPage);		//마지막 페이지
			req.setAttribute("pageBlock", pageBlock);	//출력할 페이지 개수 : 3
			req.setAttribute("pageCount", pageCount);	//페이지 개수
			req.setAttribute("currentPage", currentPage);

			req.setAttribute("dtolist", dtolist);
			req.setAttribute("daySelect", daySelect);
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("sattlementStock", sattlementStock);
			req.setAttribute("closing", closing);
			
		}
		
		if(go.equals("settlement")) {
			destination = "/host/host_settlementPro";
		}else if(go.equals("settlementStock")) {
			destination = "/host/host_settlementStock";
		}else if(go.equals("container")) {
			destination = "/host/host_settlementGraph";
		}
		
		return destination;
	}
}

