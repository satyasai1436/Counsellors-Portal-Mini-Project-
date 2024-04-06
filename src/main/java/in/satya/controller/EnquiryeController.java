package in.satya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.satya.entity.Enquirye;
import in.satya.service.EnqServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryeController {

	@Autowired
	private EnqServiceImpl EnqServiceImpl;

	@GetMapping("/addEnq")
	public String addEnq(Model model) {

		model.addAttribute("enqObj", new Enquirye());
		return "addEnq";

	}

	@PostMapping("/addEnq")
	public String enqHandel(@ModelAttribute("enqObj") Enquirye enquirye, Model model, HttpServletRequest request) {
		Integer cId = (Integer) request.getSession(false).getAttribute("cid");

		if (cId != null) {
			EnqServiceImpl.saveEnq(enquirye, cId);
			model.addAttribute("smsg", "Added Enq");
		} else {
			model.addAttribute("fmsg", "Enq Not Added");
		}

		return "addEnq";
	}

	@GetMapping("/view")
	public String view(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Integer cId = (Integer) session.getAttribute("cid");
		List<Enquirye> list = EnqServiceImpl.viewEnq(new Enquirye(), cId);
		model.addAttribute("listObj", list);
		model.addAttribute("eqObj", new Enquirye());

		return "viewEnq";
	}

	@PostMapping("/filter")
	public String filter(@ModelAttribute("eqObj") Enquirye enquire, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Integer cId = (Integer) session.getAttribute("cid");

		List<Enquirye> list = EnqServiceImpl.viewEnq(enquire, cId);
		model.addAttribute("listObj", list);

		return "viewEnq";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam("eid") Integer eid) {

		Enquirye enq = EnqServiceImpl.enqById(eid);
		model.addAttribute("enqObj", enq);
		return "addEnq";

	}
}
