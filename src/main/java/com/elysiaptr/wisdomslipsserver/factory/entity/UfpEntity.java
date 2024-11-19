package com.elysiaptr.wisdomslipsserver.factory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Ufp实例，由Ufp工厂生产，只可读
 *
 * @author ElysiaPtr
 */
@Getter
@AllArgsConstructor
public class UfpEntity {
    /**
     * ILF_UFP
     */
    private int ILF;

    /**
     * EIF_UFP
     */
    private int EIF;

    /**
     * EI_UFP
     */
    private int EI;

    /**
     * EO_UFP
     */
    private int EO;

    /**
     * EQ_UFP
     */
    private int EQ;
}
