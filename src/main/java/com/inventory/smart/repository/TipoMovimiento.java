package com.inventory.smart.repository;

/**
 * Tipos de movimiento de inventario que pueden registrarse en el sistema.
 * <ul>
 *   <li><b>ENTRADA</b>: incrementa el stock cuando ingresa mercadería</li>
 *   <li><b>SALIDA</b>: decrementa el stock cuando egresa mercadería</li>
 * </ul>
 *
 * @author Nexus team
 * @since 1.0
 */
public enum TipoMovimiento {

    
    ENTRADA,

    
    SALIDA
}
