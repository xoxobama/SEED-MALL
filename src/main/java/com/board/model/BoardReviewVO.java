package com.board.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardReviewVO {
	private int ridx;// 글번호
	private int midx;// 회원번호
	private int oidx;// 주문번호
	private String rtitle;//제목	
    private String rcontent;//내용
    private String rname;//작성자
    private int rreadnum;//조회수
    private int rlikenum;//좋아요수
    private int score;//평점
	private java.sql.Date rdate; // 작성일
	
	private String email;
	private List<BoardReviewVO> boardReviewVO;
	
	
}
