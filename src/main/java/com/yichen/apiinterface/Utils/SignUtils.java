package com.yichen.apiinterface.Utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.util.HashMap;
import java.util.Map;

public class SignUtils {
    public static String getSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String content = body + "." + secretKey;
        String digestHex = md5.digestHex(content);
        return digestHex;
    }

}
