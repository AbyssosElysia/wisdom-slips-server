package com.elysiaptr.wisdomslipsserver.factory;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.enumeration.ScaleChangeAdjustmentFactor;
import com.elysiaptr.wisdomslipsserver.exception.WrongArgsException;

/**
 * 项目阶段工厂
 *
 * @author ElysiaPtr
 */
public class StageFactory {
    public static double getStageFactory(int stage) {
        if (stage == 1) {
            return ScaleChangeAdjustmentFactor.PROJECT_INITIATION.getValue();
        } else if (stage == 2) {
            return ScaleChangeAdjustmentFactor.PROJECT_TENDERING.getValue();
        } else if (stage == 3) {
            return ScaleChangeAdjustmentFactor.EARLY_PROJECT_STAGE.getValue();
        } else if (stage == 4) {
            return ScaleChangeAdjustmentFactor.MID_PROJECT_STAGE.getValue();
        } else if (stage == 5) {
            return ScaleChangeAdjustmentFactor.PROJECT_COMPLETION.getValue();
        } else {
            throw new WrongArgsException(ErrorConstant.WRONG_STAGE_INDEX);
        }
    }
}
