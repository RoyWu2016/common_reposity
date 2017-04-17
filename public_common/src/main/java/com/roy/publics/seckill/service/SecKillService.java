package com.roy.publics.seckill.service;

import java.util.List;

import com.roy.publics.seckill.bean.SecKill;
import com.roy.publics.seckill.dto.Exposer;
import com.roy.publics.seckill.dto.SecKillExecution;
import com.roy.publics.seckill.exception.RepeatKillException;
import com.roy.publics.seckill.exception.SecKillCloseException;
import com.roy.publics.seckill.exception.SecKillException;

public interface SecKillService {

	/**
	 * 查询所有的秒杀记录
	 * 
	 * @return
	 */
	List<SecKill> getSecKillList();

	/**
	 * 查询单个秒杀记录
	 * 
	 * @param secKillId
	 * @return
	 */
	SecKill getById(long secKillId);

	/**
	 * 秒杀开启时输出秒杀接口地址 否则输出系统时间和秒杀时间 防止用户猜测出秒杀地址的规律
	 * 
	 * @param secKillId
	 */
	Exposer exportSecKillUrl(long secKillId);

	/**
	 * 执行秒杀操作
	 * 
	 * @param secKillId
	 * @param userPhone
	 * @param md5
	 */
	SecKillExecution executeSecKill(long secKillId, long userPhone, String md5)
			throws SecKillException, RepeatKillException, SecKillCloseException;

}
