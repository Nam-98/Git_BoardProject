package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BMemberDAO;

@Service
public class BMemberService {
	
	@Autowired
	private BMemberDAO mdao;

}
