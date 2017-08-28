package spring.mvc.bms.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.bms.service.BmsService;

@Controller
public class FrontColtroller {
	
	@Inject
	BmsService service;
	
	@RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
	public String shop(){
		
		System.out.println("/shop");
		
		return "shop";
	}
	
	@RequestMapping(value = "/home", method = {RequestMethod.GET,RequestMethod.POST})
	public String home(Model model) throws Exception{
		
		System.out.println("/home");
		
		return service.homeService(model);
	}
	
	@RequestMapping(value = "/joinUs", method = {RequestMethod.GET,RequestMethod.POST})
	public String joinUs(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/joinUs");
		
		return service.joinUsService(req, model);
	}
	
	@RequestMapping(value = "/idCheck", method = {RequestMethod.GET,RequestMethod.POST})
	public String idCheck(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/idCheck");
		
		return service.idCheckService(req, model);
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public String login(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/login");
		
		return service.loginService(req, model);
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/logout");

		return service.logoutService(req, model);
	}
	
	@RequestMapping(value = "/mypage", method = {RequestMethod.GET,RequestMethod.POST})
	public String mypage(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/mypage");

		return service.mypageService(req, model);
	}
	
	@RequestMapping(value = "/cart", method = {RequestMethod.GET,RequestMethod.POST})
	public String cart(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/cart");

		return service.cartService(req, model);
	}
	
	@RequestMapping(value = "/bookpage", method = {RequestMethod.GET,RequestMethod.POST})
	public String bookpage(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/bookpage");

		return service.bookpageService(req, model);
	}
	
	@RequestMapping(value = "/buy", method = {RequestMethod.GET,RequestMethod.POST})
	public String buy(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/buy");
		
		return service.buyService(req,model);
	}
	
	@RequestMapping(value = "/cartPut", method = {RequestMethod.GET,RequestMethod.POST})
	public String cartPut(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/cartPut");
		
		return service.cartPutService(req,model);
	}
	
	@RequestMapping(value = "/cartBuy", method = {RequestMethod.GET,RequestMethod.POST})
	public String cartBuy(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/cartBuy");
		
		return service.cartBuyService(req,model);
	}
	
	@RequestMapping(value = "/infoModify", method = {RequestMethod.GET,RequestMethod.POST})
	public String infoModify(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/infoModify");
		
		return service.infoModifyService(req,model);
	}
	
	@RequestMapping(value = "/infoExit", method = {RequestMethod.GET,RequestMethod.POST})
	public String infoExit(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/infoExit");
		
		return service.infoExitService(req,model);
	}
	
	@RequestMapping(value = "/searchBook", method = {RequestMethod.GET,RequestMethod.POST})
	public String searchBook(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/searchBook");
		
		return service.searchBookService(req,model);
	}
	
	@RequestMapping(value = "/guestOrder", method = {RequestMethod.GET,RequestMethod.POST})
	public String guestOrder(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/guestOrder");
		
		return service.guestOrderService(req,model);
	}
	
	@RequestMapping(value = "/guestCancle", method = {RequestMethod.GET,RequestMethod.POST})
	public String guestCancle(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/guestCancle");
		
		return service.guestCancleService(req,model);
	}
	
	@RequestMapping(value = "/boardList", method = {RequestMethod.GET,RequestMethod.POST})
	public String boardList(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/boardList");
		
		return service.boardListService(req,model);
	}
	
	@RequestMapping(value = "/boardContent", method = {RequestMethod.GET,RequestMethod.POST})
	public String boardContent(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/boardContent");
		
		return service.boardContentService(req,model);
	}
	
	@RequestMapping(value = "/boardModify", method = {RequestMethod.GET,RequestMethod.POST})
	public String boardModify(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/boardModify");
		
		return service.boardModifyService(req,model);
	}
	
	@RequestMapping(value = "/boardModify2", method = {RequestMethod.GET,RequestMethod.POST})
	public String boardModify2(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/boardModify2");
		
		return service.boardModify2Service(req,model);
	}
	
	@RequestMapping(value = "/boardDelete", method = {RequestMethod.GET,RequestMethod.POST})
	public String boardDelete(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/boardDelete");
		
		return service.boardDeleteService(req,model);
	}
	
	@RequestMapping(value = "/boardWrite", method = {RequestMethod.GET,RequestMethod.POST})
	public String boardWrite(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/boardWrite");
		
		return service.boardWriteService(req,model);
	}
	
	@RequestMapping(value = "/searchBoard", method = {RequestMethod.GET,RequestMethod.POST})
	public String searchBoard(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/searchBoard");
		
		return service.searchBoardService(req,model);
	}
	
	@RequestMapping(value = "/host", method = {RequestMethod.GET,RequestMethod.POST})
	public String host(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/host");
		
		return service.hostService(req,model);
	}
	
	@RequestMapping(value = "/hostStock", method = {RequestMethod.GET,RequestMethod.POST})
	public String hostStock(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/hostStock");
		
		return service.hostStockService(req,model);
	}
	
	@RequestMapping(value = "/hostStockModify", method = {RequestMethod.GET,RequestMethod.POST})
	public String hostStockModify(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/hostStockModify");
		
		return service.hostStockModifyService(req,model);
	}
	
	@RequestMapping(value = "/hostStockDelete", method = {RequestMethod.GET,RequestMethod.POST})
	public String hostStockDelete(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/hostStockDelete");
		
		return service.hostStockDeleteService(req,model);
	}
	
	@RequestMapping(value = "/hostStockAdd", method = {RequestMethod.GET,RequestMethod.POST})
	public String hostStockAdd(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/hostStockAdd");
		
		return service.hostStockAddeService(req,model);
	}
	
	@RequestMapping(value = "/hostBookSearch", method = {RequestMethod.GET,RequestMethod.POST})
	public String hostBookSearch(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/hostBookSearch");
		
		return service.hostBookSearchService(req,model);
	}
	
	@RequestMapping(value = "/hostOrderList", method = {RequestMethod.GET,RequestMethod.POST})
	public String hostOrderList(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/hostOrderList");
		
		return service.hostOrderListService(req,model);
	}
	
	@RequestMapping(value = "/hostOrderAgree", method = {RequestMethod.GET,RequestMethod.POST})
	public String hostOrderAgree(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/hostOrderAgree");
		
		return service.hostOrderAgreeService(req,model);
	}
	
	@RequestMapping(value = "/imgUpLoad", method = {RequestMethod.GET,RequestMethod.POST})
	public String imgUpLoad(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/imgUpLoad");
		
		return service.imgUpLoadService(req,model);
	}
	
	@RequestMapping(value = "/hostOrderView", method = {RequestMethod.GET,RequestMethod.POST})
	public String hostOrderView(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/hostOrderView");
		
		return service.hostOrderViewService(req,model);
	}
	
	@RequestMapping(value = "/settlement", method = {RequestMethod.GET,RequestMethod.POST})
	public String settlement(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/settlement");
		
		return service.settlementService(req,model);
	}
	
	@RequestMapping(value = "/settlementPro", method = {RequestMethod.GET,RequestMethod.POST})
	public String settlementPro(HttpServletRequest req, Model model) throws Exception{
		
		System.out.println("/settlementPro");
		
		return service.settlementProService(req,model);
	}
	
}

