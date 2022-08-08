package com.week05.springtaem.service;

import com.week05.springtaem.model.Comment;
import com.week05.springtaem.model.Commit;
import com.week05.springtaem.model.Users;
import com.week05.springtaem.model.dto.CommitRequestDto;
import com.week05.springtaem.repository.CommentRepository;
import com.week05.springtaem.repository.CommitRepository;
import com.week05.springtaem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommitService {
	private final CommentRepository commentRepository;
	private final CommitRepository commitRepository;
	private final UserRepository userRepository;

	@Autowired
	public CommitService(CommentRepository commentRepository, CommitRepository commitRepository, UserRepository userRepository) {
		this.commentRepository = commentRepository;
		this.commitRepository = commitRepository;
		this.userRepository = userRepository;
	}

	public List<Commit> readAllCommit(Long commentId) {
		System.out.println(commentId);
		List<Commit> allByCommentId = commitRepository.findAllByComment_Id(commentId);
		System.out.println(allByCommentId.size());
		for(int i=0; i<allByCommentId.size(); i++){
			System.out.println(i+"번 시작");
			System.out.println(allByCommentId.get(i).getId());
			System.out.println(allByCommentId.get(i).getUserWriter());
			System.out.println(allByCommentId.get(i).getContent());
		}
		return allByCommentId;
	}

	public Commit readCommit(Long commitId) {
		return commitRepository.findById(commitId)
				.orElseThrow(()-> new NullPointerException("해당 대댓글이 존재하지 않습니다."));
	}

	public Commit creatCommit(Long commentId, CommitRequestDto commitRequestDto) {
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(()-> new NullPointerException("해당 댓글이 존재하지 않습니다."));

		Users user = userRepository.findById(commitRequestDto.getUsername())
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));

		Commit commit = new Commit(commitRequestDto, comment,user);

		comment.addCommit(commit);
		user.addCommit(commit);

		commitRepository.save(commit);
		return commit;
	}

	@Transactional
	public Commit updateCommit(Long commitId, CommitRequestDto commitRequestDto) {
		Commit commit = commitRepository.findById(commitId)
				.orElseThrow(() -> new NullPointerException("해당 대댓글이 존재하지 않습니다."));

		commit.updateCommit(commitRequestDto);

		return commit;
	}

	public String deleteCommit(Long commitId) {
		Commit commit = commitRepository.findById(commitId)
				.orElseThrow(() -> new NullPointerException("해당 대댓글이 존재하지 않습니다."));

		Comment comment = commentRepository.findById(commit.getComment().getId())
				.orElseThrow(()-> new NullPointerException("해당 댓글이 존재하지 않습니다."));

		Users user = userRepository.findById(commit.getUsers().getUsername())
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));

		comment.removeCommit(commit);
		user.removeCommit(commit);

		commitRepository.delete(commit);

		return commitId + "번 대댓글 삭제 완료";
	}
}
