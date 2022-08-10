package com.week05.springtaem.s3;

import com.week05.springtaem.model.ImgUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface S3Repository extends JpaRepository<ImgUrl, String> {
}
