package com.javalec.dto;

import java.io.FileInputStream;

public class StudyStandByScreenDto {


	String StudyStandByScreenImageName;
	FileInputStream StudyStandByScreenImage;
	
	public StudyStandByScreenDto() {
		// TODO Auto-generated constructor stub
	}

	public StudyStandByScreenDto(String studyStandByScreenImageName, FileInputStream studyStandByScreenImage) {
		super();
		StudyStandByScreenImageName = studyStandByScreenImageName;
		StudyStandByScreenImage = studyStandByScreenImage;
	}

	public String getStudyStandByScreenImageName() {
		return StudyStandByScreenImageName;
	}

	public void setStudyStandByScreenImageName(String studyStandByScreenImageName) {
		StudyStandByScreenImageName = studyStandByScreenImageName;
	}

	public FileInputStream getStudyStandByScreenImage() {
		return StudyStandByScreenImage;
	}

	public void setStudyStandByScreenImage(FileInputStream studyStandByScreenImage) {
		StudyStandByScreenImage = studyStandByScreenImage;
	}
	
	
}
