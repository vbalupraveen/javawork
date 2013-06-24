package org.ulab.mvc;

import java.util.Comparator;

import org.springframework.stereotype.Service;
@Service
public class CaseInsensitiveComparision implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		assert o1!=null && o2!=null;
		int Compresult=o1.compareTo(o2);
		return Compresult;
	}

}
