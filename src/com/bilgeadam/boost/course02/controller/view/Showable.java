package com.bilgeadam.boost.course02.controller.view;

import com.bilgeadam.boost.course02.model.BilgeAdamAble;

public interface Showable<T extends BilgeAdamAble> {
	void show(T entity);
}
