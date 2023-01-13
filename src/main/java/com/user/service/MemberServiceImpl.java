package com.user.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.user.mapper.MemberMapper;
import com.user.model.MemberVO;
import com.user.model.NotUserException;
import com.user.model.PagingVO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberMapper MemberMapper;

	@Override
	public int createMember(MemberVO Member) {

		return MemberMapper.createMember(Member);
	}

	@Override
	public int getMemberCount(PagingVO pvo) {
		return MemberMapper.getMemberCount(pvo);
	}

	@Override
	public List<MemberVO> listUser(PagingVO pvo) {
		return MemberMapper.listUser(pvo);
	}

	

	@Override
	public int deleteMember(Integer midx) {
		return MemberMapper.deleteUser(midx);
	}

	@Override
	public int updateMember(MemberVO member) {
		return MemberMapper.updateUser(member);
	}
	
	@Override
	public int updateMemberInfo(MemberVO member) {
		return MemberMapper.updateMemberInfo(member);
	}

	@Override
	public MemberVO getMember(Integer midx) {
		return MemberMapper.getMember(midx);
	}

	@Override
	public MemberVO findUser(MemberVO findUser) throws NotUserException {
		MemberVO user = MemberMapper.findUser(findUser);
		if (user == null) {
			throw new NotUserException("존재하지 않는 이메일입니다1");
		}
		return user;
	}

	@Override
	public MemberVO loginCheck(String email, String pwd) throws NotUserException {
		MemberVO tmpVo = new MemberVO();
		tmpVo.setEmail(email);

		MemberVO member = this.findUser(tmpVo);
		if (member == null) {
			throw new NotUserException("존재하지 않는 이메일입니다.");
		}
		if (!member.getPwd().equals(pwd)) {
			throw new NotUserException("비밀번호가 일치하지 않습니다.");
		}

		return member;

	}

	@Override
	public void logout(HttpSession session) throws Exception {
		session.invalidate();

	}
	// 게시목록 가져오기
	@Override
	public List<MemberVO> selectMemberAll(Map<String,Integer> map){
		return this.MemberMapper.selectMemberAll(map);
	}
	@Override
	public List<MemberVO> selectMemberAllPaging(PagingVO pvo){
		return this.MemberMapper.selectMemberAllPaging(pvo);
	}
	   
	// 검색목록 가져오기
	@Override
	public List<MemberVO> findMember(PagingVO pvo){
		return this.MemberMapper.findMember(pvo);
	}

	@Override
	public boolean emailCheck(String email) {
		Integer n= MemberMapper.emailCheck(email);
		if(n==null) {
			return true;
		}
		return false;
	}

	@Override
	public MemberVO findemail(MemberVO vo) {
		
		return MemberMapper.findemail(vo);
	}

	@Override
	public MemberVO findPassword(MemberVO vo) {
		return MemberMapper.findPassword(vo);
	}

	@Override
	public int updatePassword(MemberVO vo) {
		
		return MemberMapper.updatePassword(vo);
	}

	@Override
	public int updateGrade(MemberVO vo) {
		String grade="";
		int mil=vo.getMileage();
		if(mil < 5000) {
			grade="씨앗회원";
		}else if(mil >= 5000 && mil < 15000) {
			grade="새싹회원";
		}else if(mil >= 15000 && mil < 25000) {
			grade="꽃잎회원";
		}else if(mil >= 25000 && mil < 40000) {
			grade="나무회원";
		}else {
			grade="열매회원";
		}
		vo.setGrade(grade);
		return this.MemberMapper.updateGrade(vo);
	}


}
