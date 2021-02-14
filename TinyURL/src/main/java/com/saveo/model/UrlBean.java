package com.saveo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UrlBean {
	
	@Id
	@Column(name="Serial_No")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long serialNo;
	private String id;
	private String url;
	
	public Long getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	@Override
	public String toString() {
		return "UrlBean [id=" + id + ", url=" + url + "]";
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
