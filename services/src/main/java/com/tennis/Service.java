package com.tennis;

import java.util.List;

public interface Service<T> {

	List<T> getAll();

	void add(T user);
}
