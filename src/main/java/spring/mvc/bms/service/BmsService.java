package spring.mvc.bms.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BmsService {
	
	public String homeService(Model model) throws Exception;

	public String joinUsService(HttpServletRequest req, Model model) throws Exception;

	public String idCheckService(HttpServletRequest req, Model model) throws Exception;

	public String loginService(HttpServletRequest req, Model model) throws Exception;

	public String logoutService(HttpServletRequest req, Model model) throws Exception;

	public String mypageService(HttpServletRequest req, Model model) throws Exception;

	public String cartService(HttpServletRequest req, Model model) throws Exception;

	public String bookpageService(HttpServletRequest req, Model model) throws Exception;

	public String buyService(HttpServletRequest req, Model model) throws Exception;

	public String cartPutService(HttpServletRequest req, Model model) throws Exception;

	public String cartBuyService(HttpServletRequest req, Model model) throws Exception;

	public String infoModifyService(HttpServletRequest req, Model model) throws Exception;

	public String infoExitService(HttpServletRequest req, Model model) throws Exception;

	public String searchBookService(HttpServletRequest req, Model model) throws Exception;

	public String guestOrderService(HttpServletRequest req, Model model) throws Exception;

	public String guestCancleService(HttpServletRequest req, Model model) throws Exception;

	public String boardListService(HttpServletRequest req, Model model) throws Exception;

	public String boardContentService(HttpServletRequest req, Model model) throws Exception;

	public String boardModifyService(HttpServletRequest req, Model model) throws Exception;

	public String boardModify2Service(HttpServletRequest req, Model model) throws Exception;

	public String boardDeleteService(HttpServletRequest req, Model model) throws Exception;

	public String boardWriteService(HttpServletRequest req, Model model) throws Exception;

	public String searchBoardService(HttpServletRequest req, Model model) throws Exception;

	public String hostService(HttpServletRequest req, Model model) throws Exception;

	public String hostStockService(HttpServletRequest req, Model model) throws Exception;

	public String hostStockModifyService(HttpServletRequest req, Model model) throws Exception;

	public String hostStockDeleteService(HttpServletRequest req, Model model) throws Exception;

	public String hostStockAddeService(HttpServletRequest req, Model model) throws Exception;

	public String hostBookSearchService(HttpServletRequest req, Model model)  throws Exception;

	public String hostOrderListService(HttpServletRequest req, Model model) throws Exception;

	public String hostOrderAgreeService(HttpServletRequest req, Model model) throws Exception;

	public String imgUpLoadService(HttpServletRequest req, Model model) throws Exception;

	public String hostOrderViewService(HttpServletRequest req, Model model) throws Exception;

	public String settlementService(HttpServletRequest req, Model model) throws Exception;

	public String settlementProService(HttpServletRequest req, Model model) throws Exception;

}
