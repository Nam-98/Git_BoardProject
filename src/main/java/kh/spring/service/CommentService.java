package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.CommentDAO;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO cdao;

}
