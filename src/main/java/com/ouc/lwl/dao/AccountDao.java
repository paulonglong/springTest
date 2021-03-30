package com.ouc.lwl.dao;

/**
 * @author Li Wenlong
 * @since 2021/3/25
 */
public interface AccountDao {
    // 汇款
    public void out(String outUser, int money);
    // 收款
    public void in(String inUser, int money);
}
