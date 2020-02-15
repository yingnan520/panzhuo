package com.NEU.model;

public class TreeNode<T> {
	
	private T data;
	private T parentData;
	private int parentLocation;
	
	public TreeNode() {};
	
	public TreeNode(T data) {
		this.data = data;
	}
	
	public TreeNode(T data, T parentData, int parentLocation) {
		this.data = data;
		this.parentData = parentData;
		this.parentLocation = parentLocation;
	}
	
	public void setData(T data) {
		this.data = data;
    }
	
	public T getData() {
		return this.data;
	}
	
	public void setParentData(T parentData) {
		this.parentData = parentData;
	}
	
	public T getParentData() {
		return this.parentData;
	}
	
	public void setParentLocation(int parentLocation) {
		this.parentLocation = parentLocation;
	}
	
	public int getParentLocation() {
		return this.parentLocation;
	}

}
