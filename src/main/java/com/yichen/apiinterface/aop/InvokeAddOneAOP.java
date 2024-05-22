package com.yichen.apiinterface.aop;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 调用次数切面
 */
@RestControllerAdvice
public class InvokeAddOneAOP {
    // todo 定义切面在什么时候执行

    // 定义切面触发的时机， 什么时候执行该方法（controller的方法执行成功后，执行下述方法）
    public void doInvokeAddOne() {
        // 调用方法成功后 次数+1
    }
}
