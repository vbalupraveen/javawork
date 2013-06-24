package net.ulab.strutsadv.action;


import java.io.File;

import net.ulab.strutsadv.interceptor.LoginRequired;

import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements LoginRequired {
	private File resume;
	private String resumeContentType;
	private String resumeFileName;// default resume+"FileName" created by Struts
									// Framework
	private String destResumePath;
	private String userName;

	public String execute() {
		/* Copy file to a safe location */
		destResumePath = "E:/eclipse_workspace_win8/StrutsAdvanced/files/";
		setUserName("Balu praveen");
		try {
			System.out.println("Src File name: " + resume);
			System.out.println("Src File name: " + resumeFileName);
			System.out.println("Src File type: " + resumeContentType);
			/* destResumePath/resumeName */
			File destFile = new File(destResumePath, resumeFileName);
			FileUtils.copyFile(resume, destFile);

		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}

		return SUCCESS;
	}

	public File getResume() {
		return resume;
	}

	public void setResume(File resume) {
		this.resume = resume;
	}

	public String getResumeContentType() {
		return resumeContentType;
	}

	public void setResumeContentType(String resumeContentType) {
		this.resumeContentType = resumeContentType;
	}

	public String getResumeFileName() {
		return resumeFileName;
	}

	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}