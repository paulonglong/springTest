package com.ouc.lwl.service;

/**
 * @author Li Wenlong
 * @since 2021/3/25
 */
public interface AccountService {
    // 转账
    public void transfer(String outUser, String inUser, int money);
}
