package kr.ac.hansung.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.model.Offer1;
import kr.ac.hansung.model.Offer2;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	@RequestMapping("/semesterCreditSearch")
	public String semesterCreditSearch(Model model, Offer1 offer) {
		List<Offer1> offers = offerService.search1();
		model.addAttribute("offers", offers);

		return "successSearch1";
	}

	@RequestMapping("/searchSubject")
	public String semesterSubjectSearch(HttpServletRequest rq, HttpServletResponse rs, Model model, Offer1 offer) {
		int year = Integer.parseInt(rq.getParameter("year"));
		int semester = Integer.parseInt(rq.getParameter("semester"));
		System.out.println(year + semester);

		List<Offer2> offers = offerService.search2(year, semester);
		model.addAttribute("offers", offers);

		return "searchSubject";
	}

	@RequestMapping("/applicationForClasses")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer2());
		return "/applicationForClasses";
	}

	@RequestMapping("/docreate")
	public String doCreate(HttpServletRequest rq, Model model, Offer2 offer) {
		offerService.insert(offer);
		System.out.println(offer.getTitle());
		return "subjectcreated";
	}

	@RequestMapping("/menu")
	public String goMenu() {
		return "menu";
	}

	@RequestMapping("/appClsSearch")
	public String applicationSubjectSearch(Model model, Offer offer) {

		List<Offer> offers = offerService.search3();
		model.addAttribute("offers", offers);
		return "appClsSearch";
	}

}
