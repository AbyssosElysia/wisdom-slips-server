package com.elysiaptr.wisdomslipsserver.factory;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.exception.WrongArgsException;
import com.elysiaptr.wisdomslipsserver.strategy.FunctionPointAnalyzeStrategy;
import com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl.DemandChangeAdjustmentFactorMethod;
import com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl.GeneralSystemAdjustmentFactorMethod;

/**
 * 功能点分析策略工厂
 *
 * @author ElysiaPtr
 */
public class FunctionPointAnalyzeStrategyFactory {
    public static FunctionPointAnalyzeStrategy getFunctionPointAnalyzeStrategy(int method) {
        if (method == 1) {
            return new GeneralSystemAdjustmentFactorMethod();
        } else if (method == 2) {
            return new DemandChangeAdjustmentFactorMethod();
        } else {
            throw new WrongArgsException(ErrorConstant.WRONG_METHOD_EXCEPTION);
        }
    }
}
