package com.lening.test;

import com.lening.utils.MD5key;
import org.junit.Test;

/**
 * 创建时间: 2021-04-13 上午 11:15
 * 撩妹贼溜: 肖彬
 */

public class TestM {

    public static void main(String[] args) {
        MD5key key = new MD5key();
        String s = key.getkeyBeanofStr("1128");
        System.out.println(s);
    }
}
