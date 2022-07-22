package com.example.SocialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SocialNetworkApplication {


	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkApplication.class, args);
	}
}
//	void testUpdate() {
//		//update
//		String sql = "UPDATE books SET price=? WHERE title=?";
//		Object[] params = {9.99f, "Effective Java"};
//		int result = jdbcTemplate.update(sql, params);
//
//		if (result > 0) {
//			System.out.println("Update successfully.");
//		}
//		//detele
//		String sql = "DELETE FROM books WHERE title=?";
//		Object[] params = {"Effective Java"};
//		int result = jdbcTemplate.update(sql, params);
//
//		if (result > 0) {
//			System.out.println("Delete successfully.");
//		}
//
//	}
//
//	void testListAll() {
//		String sql = "SELECT * FROM books";
//
//		List<Book> listBooks = jdbcTemplate.query(sql,
//				BeanPropertyRowMapper.newInstance(Book.class));
//
//		for (Book book : listBooks) {
//			System.out.println(book);
//		}
//	}
//
//	void testFind() {
//		String sql = "SELECT * FROM books WHERE id = 1";
//		Book book = jdbcTemplate.queryForObject(sql,
//				BeanPropertyRowMapper.newInstance(Book.class));
//
//		System.out.println(book);
//	}


