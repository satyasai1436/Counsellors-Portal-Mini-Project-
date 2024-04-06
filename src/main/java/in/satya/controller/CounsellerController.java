package in.satya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.satya.dashBoard.DashBoard;
import in.satya.entity.Counseller;
import in.satya.service.CounServiceImpl;
import in.satya.service.EnqServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellerController {

	@Autowired
	private CounServiceImpl counsellerImpl;
	@Autowired
	private EnqServiceImpl EnqServiceImpl;
//	@Autowired
//	private HttpSession session;

	@GetMapping("/")
	public String register(Model model) {

		model.addAttribute("counObj", new Counseller());
		return "register";
	}

	@PostMapping("/register")
	public String registerHandel(Model model, Counseller counseller) {
		boolean savedCounsellor = counsellerImpl.saveCounsellor(counseller);
		if (savedCounsellor) {
			model.addAttribute("smsg", "Registration success");
		} else {
			model.addAttribute("fmsg", "Regiatration failed");
		}
		model.addAttribute("counObj", new Counseller());
		return "register";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginObj", new Counseller());
		return "login";
	}

	@PostMapping("/login")
	public String loginHandel(Model model, Counseller counseller, HttpServletRequest request) {
		Counseller login = counsellerImpl.getCounseller(counseller.getEmail(), counseller.getPassword());
		if (login != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("cid", login.getCid());
			DashBoard dashBoard = EnqServiceImpl.getDashBoard(login.getCid());
			model.addAttribute("dashObj", dashBoard);
			return "dashBoard";
		} else {
			model.addAttribute("msg1", "Invalid Credentials");
			model.addAttribute("loginObj", new Counseller());
			return "login";
		}
	}

}
