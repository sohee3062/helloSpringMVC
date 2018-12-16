package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.model.Offer1;
import kr.ac.hansung.model.Offer2;

@Service
public class OfferService {

	@Autowired
	private OfferDAO offerDao;

	public List<Offer1> search1() {
		return offerDao.getCreditSum();
	}

	public List<Offer2> search2(int year, int semester) {
		return offerDao.getSemesterSubject(year, semester);
	}

	public void insert(Offer2 offer) {
		offerDao.insert(offer);
	}

	public List<Offer> search3() {
		return offerDao.getApplicationSubject();
	}

}
