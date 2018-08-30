package com.ryzhkova;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ExampleServerRemote {
	 public List<String> getMsg();
}
