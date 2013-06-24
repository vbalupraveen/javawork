package com.ulab.mytag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CopyrightTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Invokes when the start tag of the custom tag is encountered */
	 public int doStartTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<BR><B>&copy; This page is developed by ULAB<B>");
		} catch (IOException e) {
			System.out.println("Error in Copyright custom Tag");
		}
		/* Returning the SKIP_BODY, as the body content is not be evaluated */
		return SKIP_BODY;
	}

	public int doEndTag() {
		/* Skip the processing of the rest of the page */
		return SKIP_PAGE;
	}
}
