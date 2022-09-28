package com.liquido.confirguation;

import com.liquido.entity.vo.BasicResultVO;
import com.liquido.exceptions.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 所有异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BasicResultVO exceptionHandler(Exception e) {
        LOG.error("系统异常：", e);
        return BasicResultVO.fail("系统出现异常，请联系管理员");
    }

    /**
     * 所有自定义异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BasicResultVO businessExceptionHandler(BaseException e) {
        LOG.error("业务异常：", e);
        return BasicResultVO.fail(e.getMessage());
    }

    /**
     * 校验异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public BasicResultVO validExceptionHandler(BindException e) {
        LOG.warn("参数校验失败：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return BasicResultVO.fail(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
