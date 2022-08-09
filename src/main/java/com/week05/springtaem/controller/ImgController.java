package com.week05.springtaem.controller;

import com.week05.springtaem.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class ImgController {

	private final S3Uploader s3Uploader;

	@PostMapping("/images")
	public String upload( MultipartFile multipartFile) throws IOException {
		s3Uploader.upload(multipartFile);
		return "업로드 완료";
	}
}
