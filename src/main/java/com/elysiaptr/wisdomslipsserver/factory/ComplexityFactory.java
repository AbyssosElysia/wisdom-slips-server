package com.elysiaptr.wisdomslipsserver.factory;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.exception.WrongArgsException;

/**
 * 复杂度工厂
 *
 * @author ElysiaPtr
 */
public class ComplexityFactory {
    public static int getComplexity(String complexityType) {
        if ("高".equals(complexityType)) {
            return 3;
        } else if ("中".equals(complexityType)) {
            return 2;
        } else if ("低".equals(complexityType)) {
            return 1;
        } else {
            throw new WrongArgsException(ErrorConstant.WRONG_COMPLEXITY_INPUT);
        }
    }
}
