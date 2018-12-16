package kr.ac.hansung.dao;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.model.Offer1;
import kr.ac.hansung.model.Offer2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
// 일반적인 @Component 대신에 service에 맞는 좀 더 구체적인 @Repository 사용
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	// 이 DataSource라는 타입을 가진 bean을 찾아서 자동으로 주입을 해줌
	// (실제로는 DataSource interface를 구현한 BasicDataSource의 주입이 이루어짐)

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Offer1> getCreditSum() {
		String sqlStatement = "select year, semester, sum(credit) from subject group by year, semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer1>() {
			@Override
			public Offer1 mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer1 offer = new Offer1();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCreditSum(rs.getInt("sum(credit)"));
				return offer;
			}
		});
	}

	public List<Offer2> getSemesterSubject(int year, int semester) {
		String sqlStatement = "select code, title, division, credit from subject where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Offer2>() {
			@Override
			public Offer2 mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer2 offer = new Offer2();
				offer.setCode(rs.getString("code"));
				offer.setTitle(rs.getString("title"));
				offer.setDivision(rs.getString("division"));
				offer.setCredit(rs.getInt("credit"));

				return offer;
			}
		});
	}

	public List<Offer> getApplicationSubject() {
		String sqlStatement = "select * from subject where year=2019 and semester=1";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setTitle(rs.getString("title"));
				offer.setDivision(rs.getString("division"));
				offer.setCredit(rs.getInt("credit"));

				return offer;
			}
		});
	}

	public boolean insert(Offer2 offer) {
		String code = offer.getCode();
		String title = offer.getTitle();
		String division = offer.getDivision();
		int credit = offer.getCredit();

		String sqlStatement = "insert into subject (year, semester, code, title, division, credit) values (2019, 1, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { code, title, division, credit }) == 1);
		// updete가 성공적으로 되면 update 된 개수가 integer로 넘어옴
	}

}
