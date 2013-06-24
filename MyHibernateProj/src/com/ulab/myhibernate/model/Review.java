package com.ulab.myhibernate.model;

import javax.persistence.Embeddable;

@Embeddable //entity to be embedded
public class Review {
String wesSite;
Double rating;
public String getWesSite() {
	return wesSite;
}
public void setWesSite(String wesSite) {
	this.wesSite = wesSite;
}
public Double getRating() {
	return rating;
}
public void setRating(Double rating) {
	this.rating = rating;
}

}
