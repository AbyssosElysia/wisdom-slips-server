package com.elysiaptr.wisdomslipsserver.factory;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.exception.WrongArgsException;
import com.elysiaptr.wisdomslipsserver.factory.entity.UfpEntity;

/**
 * ufp工厂
 *
 * @author ElysiaPtr
 */
public class UfpEntityFactory {
    public static UfpEntity createUfpEntity(int complexity) {
        if (complexity == 1) {
            return new UfpEntity(7, 5, 3, 4, 3);
        } else if (complexity == 2) {
            return new UfpEntity(10, 7, 4, 5, 4);
        } else if (complexity == 3) {
            return new UfpEntity(15, 10, 6, 7, 6);
        } else {
            throw new WrongArgsException(ErrorConstant.WRONG_UFP_COMPLEXITY_EXCEPTION);
        }
    }
}
