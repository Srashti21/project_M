package com.cg.moviemgmt.util;

import com.cg.moviemgmt.exceptions.InvalidArgumentException;

public class MovieValidation {
	public static void validateId(int id) {
		String str=Integer.toString(id);
		if(str.length()<4)
			throw new InvalidArgumentException("Id must have 4 characters");

		else {
			if(str.charAt(0)!='3')
				throw new InvalidArgumentException("Id should start with 3");
		}
	}


}
