package com.oamanagersys.model.kaoqin.dao;

import java.util.List;

import com.oamanagersys.model.kaoqin.entity.Kaoqin;
import com.oamanagersys.model.kaoqin.entity.SearchKaoqin;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午3:37:42
 */
public interface KaoqinDao {
	/**
	 * 签到
	 * @param kaoqin
	 * @return
	 */
	public int signIn(Kaoqin kaoqin);
	
	/**
	 * 签退
	 * @param kaoqin
	 * @return
	 */
	public int signOut(Kaoqin kaoqin);
	
	/**
	 * 查询考勤
	 * @param searchKaoqin
	 * @return
	 */
	public List<Kaoqin> list(SearchKaoqin searchKaoqin);
}
