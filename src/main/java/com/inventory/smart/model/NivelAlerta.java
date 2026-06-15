package com.inventory.smart.model;

/**
 * Niveles de alerta para el monitoreo de stock de productos.
 * <ul>
 *   <li><b>NORMAL</b>: stock por encima del umbral mínimo</li>
 *   <li><b>BAJO</b>: stock por debajo del mínimo pero por encima del crítico</li>
 *   <li><b>CRITICO</b>: stock igual o por debajo del umbral crítico</li>
 * </ul>
 *
 * @author Nexus team
 * @since 1.0
 */
public enum NivelAlerta {

    
    NORMAL,

    
    BAJO,

    
    CRITICO
}
