package com.liquido.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 全局响应状态枚举
 *
 * @author llfeng
 * @since 2022.8.29
 **/
@Getter
@ToString
@AllArgsConstructor
public enum RespStatusEnum {
  /**
   * OK：操作成功
   */
  SUCCESS("0", "操作成功"),
  FAIL("-1", "操作失败"),





  ;

  /**
   * 响应状态
   */
  private final String code;
  /**
   * 响应编码
   */
  private final String msg;
}
