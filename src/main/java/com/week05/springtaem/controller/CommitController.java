package com.week05.springtaem.controller;

import com.week05.springtaem.model.Commit;
import com.week05.springtaem.model.dto.CommitRequestDto;
import com.week05.springtaem.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommitController {
	private final CommitService commitService;
	@Autowired
	public CommitController(CommitService commitService) {
		this.commitService = commitService;
	}

	@GetMapping("/commits/{commentId}")
	public List<Commit> readAllCommit(@PathVariable Long commentId){
		return commitService.readAllCommit(commentId);
	}

	@GetMapping("/commit/{commitId}")
	public Commit readCommit(@PathVariable Long commitId){
		return commitService.readCommit(commitId);
	}

	@PostMapping("/auth/commit/{commentId}")
	public Commit creatCommit(@PathVariable Long commentId, @RequestBody CommitRequestDto commitRequestDto){
		return commitService.creatCommit(commentId, commitRequestDto);
	}

	@PatchMapping("/auth/commit/{commitId}")
	public Commit updateCommit(@PathVariable Long commitId, @RequestBody CommitRequestDto commitRequestDto){
		return commitService.updateCommit(commitId, commitRequestDto);
	}

	@DeleteMapping("/auth/commit/{commitId}")
	public String deleteCommit(@PathVariable Long commitId){
		return commitService.deleteCommit(commitId);
	}
}
