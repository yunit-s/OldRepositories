package comment.service;

import java.util.List;

import comment.dao.CommentDAO;
import comment.vo.Comment;

public class CommentService {

	public List<Comment> getCommentAll(int boardNum) {
		System.out.println("!! CommentService.getCommentAll() 실행");
		CommentDAO cDao = new CommentDAO();
		List<Comment> cList = cDao.selectAll(boardNum);
		return cList;
	}

	public Comment getCommentOne(int commentNum) {
		System.out.println("!! CommentService.getCommentOne() 실행");
		CommentDAO cDao = new CommentDAO();
		Comment rsComment = cDao.selectOne(commentNum);
		return rsComment;
	}

	public int addComment(Comment newComment) {
		System.out.println("!! CommentService.addComment() 실행");
		CommentDAO cDao = new CommentDAO();
		int result = cDao.insert(newComment);
		return result;
	}

	public int editComment(Comment tgComment) {
		System.out.println("!! CommentService.editComment() 실행");
		CommentDAO cDao = new CommentDAO();
		int result = cDao.update(tgComment);
		return result;
	}

	public int delCommentOne(Comment tgComment) {
		System.out.println("!! CommentService.delCommentOne() 실행");
		CommentDAO cDao = new CommentDAO();
		int result = cDao.delete(tgComment);
		return result;
	}

}
