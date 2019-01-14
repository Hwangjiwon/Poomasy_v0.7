package com.bitproject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitproject.domain.MemberVO;
import com.bitproject.naver.NaverLoginBO;
import com.bitproject.service.MemberService;
import com.github.scribejava.core.model.OAuth2AccessToken;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@Inject
	private MemberService service;

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String RegisterPost(MemberVO member, Model model) throws Exception {

		logger.info("회원가입...");
		logger.info(member.toString());

		service.regist(member);

		return "home";
	}

	/*
	 * @RequestMapping(value = "/loginSucess", method = RequestMethod.GET) public
	 * String signUp(Locale locale, Model model, HttpServletRequest request) {
	 * 
	 * logger.info("Welcome home!!!!!!! The client locale is {}.", locale); String
	 * id = request.getParameter("email"); // 웹에서 전달받은 값 model.addAttribute("email",
	 * id);
	 * 
	 * return "loginSuccess"; }
	 */
	

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/n_login", method = { RequestMethod.GET, RequestMethod.POST })
	public String N_login(Model model, HttpSession session) {

		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);

		// 네이버
		model.addAttribute("naver_url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return "n_login";
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/n_callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		System.out.println("여기는 Naver callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);

		/* 네이버 로그인 성공 페이지 View 호출 */
		return "naverSuccess";
	}

	/* GoogleLogin */
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;

	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/g_login", method = { RequestMethod.GET, RequestMethod.POST })
	public String G_login(Model model, HttpSession session) {

		/* 구글code 발행 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);

		System.out.println("구글:" + url);

		model.addAttribute("google_url", url);

		/* 생성한 인증 URL을 View로 전달 */
		return "g_login";
	}

	// 구글 Callback호출 메소드
	@RequestMapping(value = "/g_callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String googleCallback(Model model, @RequestParam String code) throws IOException {
		System.out.println("여기는 googleCallback");

		return "googleSuccess";
	}

	/*
	 * @RequestMapping(value = "/loginform", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String loginform() {
	 * System.out.println("loginform 메소드 호출입니다."); return "loginform";//
	 * "/WEB-INF/views/loginform.jsp" }
	 */
	// 로그인실패 페이지 요청
	@RequestMapping(value = "/loginfail", method = RequestMethod.GET)
	public String loginfail() {

		/* View 정보를 반환하는 부분 */
		return "loginfail"; // "/WEB-INF/views/loginfail.jsp"
	}

	// 로그아웃폼 페이지 요청
	@RequestMapping(value = "/logoutform", method = RequestMethod.GET)
	public String logoutform() {

		/* View 정보를 반환하는 부분 */
		return "logoutform"; // "/WEB-INF/views/logoutform.jsp"
	}

	// 계정별 로그인
	@RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
	public String loginresult() {

		return "loginsuccess";// "/WEB-INF/views/loginsuccess.jsp"
	}

}