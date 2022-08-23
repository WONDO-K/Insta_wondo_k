package com.green.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.green.user.service.UserService;
import com.green.user.vo.UserVo;
import com.insta.post.service.PostService;
import com.insta.post.vo.PostVo;
import com.insta.reply.service.ReplyService;
import com.insta.reply.vo.ReplyVo;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@Autowired
	private ReplyService replyService;
	
	// 동호 -------------------------------------------------------------
	
	@RequestMapping("/")
	public  ModelAndView postListSP(Model model) {
		int post_num = 0;

		HashMap<String, Object> map = new HashMap<String, Object>();
		
		ModelAndView mv = new ModelAndView();
		
		// List<UserVo> userList = userService.getUserListSP(map);
		// System.out.println("userListSP() : "+ userList );


		List<PostVo> postList = postService.getPostListSP(map);
		System.out.println("postListSP()  : " + postList);
		mv.addObject("postList", postList); // model
		
		List<UserVo> userRecommendList = userService.getUserRecommendListSP(map);
		System.out.println("userRecommendListSP() : " + userRecommendList);
		mv.addObject("userRecommendList", userRecommendList); // model
		
		List< List<ReplyVo> > rList = new ArrayList<>();
		for (int i = 0; i < postList.size(); i++) {
			post_num = postList.get(i).getPost_num();
			System.out.println("내가 필요한 바로 post_num: " + post_num);
			
			List<ReplyVo> replyList = replyService.getReplyList(post_num);
			System.out.println("넣은 후 post_num: " + post_num);
			
			rList.add(  replyList   );	
		}	 
		mv.addObject("rList", rList);
		System.out.println("mv에 집어넣은 "+rList);
		
		mv.setViewName("main"); // view
		return mv;
	}
	
	@RequestMapping("/Post")
	public ModelAndView post(int post_num) {
		System.out.println("넘어온 post_num : " + post_num);
		ModelAndView mv = new ModelAndView();
		
		List<PostVo> PostViewList = new ArrayList<>();
		PostViewList = postService.getViewPost(post_num);
		System.out.println("PostViewList : " + PostViewList);
		
		List< List<ReplyVo> > prList = new ArrayList<>();
		for(int i=0; i<PostViewList.size();i++) {
			String nickname = PostViewList.get(i).getNickname();
			System.out.println("nickname : " + nickname);
			
			List<ReplyVo> ReplyViewList = replyService.getReplyViewList(post_num);
			System.out.println("ReplyViewList"+ReplyViewList);
			
			List<PostVo> underList = postService.getUnderList(nickname);
			System.out.println("mv에 넣기 전 UnderList : " + underList);
			
		
			mv.addObject("underList", underList);
			System.out.println("mv에 넣은 underList : " + underList);
			prList.add(ReplyViewList);
		}
		System.out.println("prList : "+prList);
		
		mv.addObject("PostViewList",PostViewList);
		mv.addObject("prList",prList);
		mv.setViewName("post");
		return mv;
	}
	
	
	
	// 우곤 -------------------------------------------------------------
	
	// 로그인
	// 로그인 폼을 띄우는 부분
	@RequestMapping( value="/login", method = RequestMethod.GET )
	public   String     loginForm() {
		return   "login/loginForm";
	} 
	
	//  로그인 처리하는 부분 = 로그인처리 : session 처리, cookie
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST ) 
	public   String  loginProcess(
		HttpSession    session,	
		@RequestParam  HashMap<String, Object> map	) {
		
		String   returnURL = "";
		if( session.getAttribute("login") != null ) {
			// 기존의 login 세션값이 존재한다면
			session.removeAttribute( "login" );			
		}
		
		// 로그인체크
	    UserVo  vo  =  userService.login( map  );
	    if( vo != null  ) {
	    	session.setAttribute( "login", vo );  // 세션 "login" <- vo
	    	returnURL  =  "redirect:/";   // root 로 이동, home.jsp
	    } else {
	    	returnURL  =  "redirect:/login";   // 로그인실패시 로그인폼으로 	    	
	    }
		return   returnURL;
	}
	
	// 로그이웃처리
	@RequestMapping("/logout")
	public   String   logout( HttpSession session ) {
		session.invalidate();  // 세션 전체를 날려버림
		return "redirect:/";   
	}
	
	// 회원가입처리입력
	@RequestMapping("/WriteForm")
	public   ModelAndView   writeForm(
			@RequestParam HashMap<String, Object> map ) {
			
			System.out.println("Writeform");
			ModelAndView   mv  = new ModelAndView();
			mv.setViewName("login/write");   // write.jsp		
			return  mv;
	}
	
	// 회원가입처리
	@RequestMapping("/Write")
	public   ModelAndView   write(
			@RequestParam HashMap<String, Object> map ) {
		
		System.out.println("Write");
		
		userService.insertUser( map );
		
		ModelAndView   mv  = new ModelAndView();
		mv.setViewName("login/loginForm");   		
		return  mv;
	}
	
	// 아이디 중복 체크
	@ResponseBody   /// xml/json 처리
	@RequestMapping(value="/user/idChk", method = RequestMethod.GET)
	public int idChk(UserVo vo) throws Exception {
		System.out.println("controller " + vo);
		int result = userService.idChk(vo);
		return result;
	}
	
	// 닉네임 중복 체크
	@ResponseBody   /// xml/json 처리
	@RequestMapping(value="/user/nickChk", method = RequestMethod.GET)
	public int nickChk(UserVo vo) throws Exception {
		System.out.println("controller " + vo);
		int result = userService.nickChk(vo);
		return result;
		}
	
	// 남욱 -------------------------------------------------------------
	
	@RequestMapping("Mypage/Profile")
	public ModelAndView profile( String email, String nickname, String password, String tel, String p_introduce, String p_thumbnail, String uploadFile ) {
		
		HashMap<String, Object>  map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("nickname", nickname);
		map.put("password", password);
		map.put("tel", tel);
		map.put("p_introduce", p_introduce);		
		map.put("p_thumbnail", p_thumbnail);		
		map.put("uploadFile", uploadFile);		
		
		System.out.println(map);
		
		UserVo userVo = userService.getView( map );
		System.out.println("1 userVo: " + userVo);
		System.out.println(map);
		
		// 게시글 총 수
		int postCount = userService.getCount( map );
		System.out.println(postCount);
				
		// 팔로우 총 수
		int followCount = userService.getfollowCount( map );
		System.out.println(followCount);
		
		// 팔로잉 총 수
		int followingCount = userService.getfollowingCount( map );
		System.out.println(followingCount);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("email", email);
		mv.addObject("nickname", nickname);
		mv.addObject("password", password);
		mv.addObject("tel", tel);
		mv.addObject("p_introduce", p_introduce);
		mv.addObject("p_thumbnail", p_thumbnail);
		mv.addObject("uploadFile", uploadFile);
		mv.addObject("user", userVo);	
		
		mv.addObject("postCount", postCount);
		mv.addObject("followCount", followCount);
		mv.addObject("followingCount", followingCount);
		
		mv.setViewName("mypage/mypage");
		return mv;
	}
	
	// 보기
		@RequestMapping("Mypage/Updateform")
		public ModelAndView updateform(
				@RequestParam HashMap<String, Object> map ) {
			
			String email = (String) map.get("email");
			System.out.println("email: " + email);
			
			//List<UserVo> userList = userService.getUserList( map );
			
			
			System.out.println("map1: " + map);
			UserVo userVo = userService.getView( map );
			System.out.println("map2: " + map);
			 
			ModelAndView mv = new ModelAndView();
			mv.addObject("email", email);
			//mv.addObject("userList", userList);
			mv.addObject("user", userVo);
			System.out.println(userVo);
			mv.setViewName("mypage/update");
			return mv;
		}
		
		// 수정
		@RequestMapping("/Update")
		public ModelAndView update(
				@RequestParam HashMap<String, Object> map, UserVo userVo) throws IOException {
//			
			String email = (String) map.get("email");
//			String nickname = (String) map.get("nickname");
//			String password = (String) map.get("password");
//			String name = (String) map.get("name");
//			String tel = (String) map.get("tel");
//			String joindate = (String) map.get("joindate");
//			String p_introduce = (String) map.get("p_introduce");
//			String p_thumbnail = (String) map.get("p_thumbnail");
//			String p_thumbnail_filename = (String) map.get("p_thumbnail_filename");
//			
			String p_thumbnail          = "";
	        String p_thumbnail_filename = "";
			
			MultipartFile uploadFile = userVo.getUploadFile();
			if (!uploadFile.isEmpty()) {
				String originalFileName = uploadFile.getOriginalFilename(); // 업로드된 파일명

				String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
				UUID uuid = UUID.randomUUID();	//UUID : 중복 방지
				p_thumbnail          = originalFileName;
				p_thumbnail_filename = uuid+"."+ext;
				uploadFile.transferTo(new File("C:\\Users\\pc\\Desktop\\knu_ws\\spring\\Instamiligram\\webapp\\WEB-INF\\resources\\img\\" + p_thumbnail_filename));
			}
			//userVo.setP_thumbnail(p_thumbnail);
			//userVo.setP_thumbnail_filename(p_thumbnail_filename);

			
			System.out.println("1 userVo: " + userVo);
			System.out.println("1 update map: " + map);
			map.put("p_thumbnail", p_thumbnail);
			map.put("p_thumbnail_filename", p_thumbnail_filename);
			userService.updateUser( map );
			System.out.println("2 update map: " + map);
			
			System.out.println("p_thumbnail: " + p_thumbnail);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", userVo);
			mv.setViewName("redirect:Mypage/Profile?email=" + email);
			return mv;
		}
		
		// 게시글 쓰기 Form
		@RequestMapping("Mypage/PostWriteForm")
		public ModelAndView postwriteform(
				@RequestParam HashMap<String, Object> map) {
			
			String email = (String) map.get("email");
			System.out.println("W: " + email);
			
			UserVo userVo = userService.getView( map );
			System.out.println("W userVo: " + userVo);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", userVo);
			mv.addObject("email", email);
			mv.setViewName("/mypage/postwrite");
			return mv;
		}
		
		// 게시글 쓰기
		@RequestMapping("/PostWrite")
		public ModelAndView postwrite(
				@RequestParam HashMap<String, Object> map, PostVo postVo) throws IOException {
			
			String email = (String) map.get("email");
			
			String post_img          = "";
	        String post_img_filename = "";
	        
	        
	        MultipartFile uploadFile = postVo.getUploadFile();
			if (!uploadFile.isEmpty()) {
				String originalFileName = uploadFile.getOriginalFilename(); // 업로드된 파일명

				String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
				UUID uuid = UUID.randomUUID();	//UUID : 중복 방지
				post_img          = originalFileName;
				post_img_filename = uuid+"."+ext;
				uploadFile.transferTo(new File("C:\\Users\\pc\\Desktop\\knu_ws\\spring\\Instamiligram\\webapp\\WEB-INF\\resources\\img\\imgpost\\" + post_img_filename));
			}
			
			map.put("post_img", post_img);
			map.put("post_img_filename", post_img_filename);
			
	        
			System.out.println("PW postVo: " + postVo);
			System.out.println("PW1 map: " + map);
			userService.insertPost( map );
			System.out.println("PW2 map: " + map);
			
			System.out.println("PW post_img: " + post_img);
			System.out.println("PW post_img_filename: " + post_img_filename);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("map", map);
			System.out.println("PW map: " + map);
			mv.setViewName("redirect:Mypage/Profile?email=" + email);
			return mv;
			
		}
	
}











