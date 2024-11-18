package com.elysiaptr.wisdomslipsserver.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 规模变更调整因子
 *
 * @author ElysiaPtr
 */
@Getter
@AllArgsConstructor
public enum ScaleChangeAdjustmentFactor {
    PROJECT_INITIATION(2.00),
    PROJECT_TENDERING(1.50),
    EARLY_PROJECT_STAGE(1.50),
    MID_PROJECT_STAGE(1.50),
    PROJECT_COMPLETION(1.50);

    private final double value;
}
