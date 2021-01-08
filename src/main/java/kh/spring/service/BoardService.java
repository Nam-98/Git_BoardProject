package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
@Service
public class BoardService {
	
	@Autowired
	private BoardDAO bdao;

}
