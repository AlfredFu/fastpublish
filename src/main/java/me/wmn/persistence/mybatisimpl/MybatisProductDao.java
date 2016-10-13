package me.wmn.persistence.mybatisimpl;

import me.wmn.domain.Product;

public interface MybatisProductDao {
	public Product getProductById(Integer id);
}
