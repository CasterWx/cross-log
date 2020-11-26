package com.antzuhl.cross.handler.parser;

import com.antzuhl.cross.model.ServiceLog;

/**
 * @author AntzUhl
 * @Date 2020/11/26 11:26
 * @Description 基类日志解析器
 */
public abstract class BaseParser {

    abstract ServiceLog parser(String logStr);
}
