package com.ryzhkova;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ExampleServerLocal {
	public List<String> getMsg();
}
