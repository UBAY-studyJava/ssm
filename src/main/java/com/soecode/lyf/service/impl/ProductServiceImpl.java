package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soecode.lyf.dao.ProductDao;
import com.soecode.lyf.dto.Product;
import com.soecode.lyf.service.ProductService;

@Service
public abstract class ProductServiceImpl implements ProductService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductDao ProductDao;


	@Override
	public Product getById(int productId) {
		return ProductDao.queryById(productId);
	}

	@Override
	public List<Product> getList() {
		return ProductDao.queryAll(0, 1000);
	}
	
	@Override
	public int modify(int productId, String productName, String productDetail, int cash, int balance, int account_number) {
		return ProductDao.modifyDetail(productId, productName, productDetail, cash, balance, account_number);
	}
	
	@Override
	public int delete(int productId) {
		return ProductDao.delete(productId);
	}

	public int insert(int productId, String productName, String productDetail, int cash, int balance, int account_number) {
		return ProductDao.insert(productId, productName, productDetail, cash, balance, account_number );
	}

	
	
	

	
	}


