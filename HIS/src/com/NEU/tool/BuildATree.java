package com.NEU.tool;

import java.util.ArrayList;
import java.util.List;

import com.NEU.model.TreeNode;

public class BuildATree<T> {
	
	private final int DEFAULT_SIZE = 2;  
    private int size;                         //树的size
    private int count;                        //节点个数
    private Object[] nodes; 
    
    public BuildATree() {
    	this.size = this.DEFAULT_SIZE;  
        this.nodes = new Object[this.size];  
        this.count = 0;  
    }
    
    public BuildATree(TreeNode<T> root) {
    	this();  
        this.count = 1;  
        this.nodes[0] = root;  
    }
    
    public BuildATree(TreeNode<T> root, int size) {  
        this.size = size;  
        this.nodes = new Object[this.size];  
        this.count = 1;  
        this.nodes[0] = root;  
    }  
    
    public void add(TreeNode<T> node) {  
        for (int i = 0; i < this.size; i++) {  
            if (this.nodes[i] == null) {  
                nodes[i] = node;  
                break;  
            }  
        }  
        this.count ++;  
    } 
    
    public void add(TreeNode<T> node, TreeNode<T> parent) {    
        node.setParentLocation(this.position(parent));  
        this.add(node);  
    }  
    
    public int position(TreeNode<T> node) {               //获取节点位置
        for (int i = 0; i < this.size; i++) {  
            if (nodes[i] == node) {  
                return i;  
            }  
        }  
        return -1;  
    }  
    
    @SuppressWarnings("unchecked")
	public List<TreeNode<T>> getAllNodes(){  
        List<TreeNode<T>> list = new ArrayList<TreeNode<T>>();  
        for(int i=0;i<this.size;i++){  
            if(this.nodes[i] != null){  
                list.add((TreeNode<T>)nodes[i]);  
            }  
        }  
        return list;  
    }  

}
