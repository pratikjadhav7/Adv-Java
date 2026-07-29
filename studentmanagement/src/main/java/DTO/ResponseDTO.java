package DTO;

import java.util.List;

public class ResponseDTO<T> {

	int status;
	String msg;
	 List<T> data;
	 
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> students) {
		this.data = students;
	}
	
	
}
