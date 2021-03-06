package com.gt.services.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.dao.AccountMapper;
import com.gt.dao.CategoryMapper;
import com.gt.model.Account;
import com.gt.model.Category;
import com.gt.services.base.AccountServiceI;
import com.gt.services.base.CategoryServiceI;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryServiceI {
	@Autowired
    private CategoryMapper categoryMapper;
	@Override
	public List<Category> queryCategoryAll(Map<String, Object> map) {
        List<Category> list = categoryMapper.findAllCategoryAccount(map);
		return list;
	}
	@Override
	public int countTypeAll(String type) {
		int count = categoryMapper.countTypeAll(type);
		return count;
	}
	@Override
	public void deleteCategory(Integer[] idkey) {
		 System.out.println(idkey); 
		 categoryMapper.delCategory(idkey);
		
	}
	@Override
	public void saveCategory(Category category) {
		categoryMapper.insertSelective(category);
	}
	@Override
	public void updateCategory(Category category) {
		categoryMapper.updateByPrimaryKeySelective(category);
	}
	@Override
	public List<Category> findProductType() {
		return categoryMapper.findProductType();
	}
	@Override
	public List<Category> getTypeByHot(int ishot) {
		return categoryMapper.getCategoryIsHot(ishot);
	}

}
