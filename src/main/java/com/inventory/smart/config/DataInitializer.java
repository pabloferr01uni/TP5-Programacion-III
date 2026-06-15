package com.inventory.smart.config;

import com.inventory.smart.model.Categoria;
import com.inventory.smart.model.Producto;
import com.inventory.smart.repository.CategoriaRepository;
import com.inventory.smart.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Inicializador de datos de prueba (seed data).
 * <p>
 * Al arrancar la aplicación, este componente carga datos de demostración.
 * </p>
 *
 * @since 1.0
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public DataInitializer(ProductoRepository productoRepository,
                           CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {
        log.info("=== Iniciando carga de datos de prueba ===");

        Categoria catElectro = registrarCategoria("Electrónica", "Dispositivos electrónicos, gadgets y componentes");
        Categoria catAlimentos = registrarCategoria("Alimentos", "Productos alimenticios, bebidas y comestibles");
        Categoria catRopa = registrarCategoria("Ropa", "Prendas de vestir, calzado y accesorios de moda");
        Categoria catHogar = registrarCategoria("Hogar", "Artículos para el hogar, muebles y decoración");
        Categoria catDeportes = registrarCategoria("Deportes", "Equipamiento deportivo, ropa deportiva y accesorios");

        registrarProducto("Smartphone Galaxy X", "Smartphone de última generación con pantalla AMOLED de 6.7 pulgadas", 999.99, 50, catElectro.getId());
        registrarProducto("Laptop ProBook 15", "Laptop profesional con procesador i7, 16GB RAM y SSD 512GB", 1299.99, 25, catElectro.getId());
        registrarProducto("Auriculares Bluetooth", "Auriculares inalámbricos con cancelación de ruido activa", 149.99, 100, catElectro.getId());
        registrarProducto("Tablet DigitalPad", "Tablet de 10 pulgadas ideal para lectura y entretenimiento", 349.99, 30, catElectro.getId());
        registrarProducto("Cargador USB-C 65W", "Cargador rápido universal compatible con múltiples dispositivos", 39.99, 200, catElectro.getId());

        registrarProducto("Arroz Integral 1kg", "Arroz integral orgánico de grano largo, fuente natural de fibra", 4.99, 150, catAlimentos.getId());
        registrarProducto("Aceite de Oliva Extra Virgen", "Aceite de oliva prensado en frío, 500ml. Ideal para ensaladas", 12.99, 80, catAlimentos.getId());
        registrarProducto("Leche Descremada 1L", "Leche fresca descremada en envase tetra pack. Rica en calcio", 2.49, 8, catAlimentos.getId());
        registrarProducto("Galletas Integrales", "Galletas de avena integral con chips de chocolate. Paquete 200g", 3.79, 2, catAlimentos.getId());
        registrarProducto("Café Molido Premium", "Café arábica 100% molido. Bolsa de 500g. Tueste medio", 8.99, 45, catAlimentos.getId());

        registrarProducto("Camiseta Algodón Premium", "Camiseta de algodón 100% peinado. Disponible en varios colores", 29.99, 120, catRopa.getId());
        registrarProducto("Jeans Slim Fit", "Jeans de mezclilla elástica con corte moderno slim fit", 59.99, 60, catRopa.getId());
        registrarProducto("Zapatillas Running", "Zapatillas deportivas con suela de goma y amortiguación avanzada", 89.99, 5, catRopa.getId());
        registrarProducto("Chaqueta Impermeable", "Chaqueta cortavientos con membrana impermeable y transpirable", 129.99, 1, catRopa.getId());
        registrarProducto("Bufanda de Lana", "Bufanda tejida artesanalmente con lana merino. Suave y abrigada", 24.99, 35, catRopa.getId());

        registrarProducto("Set de Sartenes Antiadherentes", "Juego de 3 sartenes antiadherentes con mango de silicona", 79.99, 40, catHogar.getId());
        registrarProducto("Lámpara LED Inteligente", "Lámpara de escritorio con control por WiFi", 45.99, 55, catHogar.getId());
        registrarProducto("Organizador de Cocina", "Organizador modular apilable para cubiertos", 19.99, 3, catHogar.getId());
        registrarProducto("Juego de Toallas Premium", "Set de 4 toallas de algodón egipcio 600g/m²", 54.99, 25, catHogar.getId());
        registrarProducto("Difusor de Aromas", "Difusor ultrasónico con luces LED", 34.99, 70, catHogar.getId());

        registrarProducto("Bicicleta de Montaña MTB", "Bicicleta de montaña con cuadro de aluminio", 499.99, 12, catDeportes.getId());
        registrarProducto("Colchoneta de Yoga", "Colchoneta antideslizante de 6mm", 34.99, 80, catDeportes.getId());
        registrarProducto("Pesas Ajustables 20kg", "Set de pesas con mancuernas ajustables", 149.99, 7, catDeportes.getId());
        registrarProducto("Raqueta de Tenis Profesional", "Raqueta de grafito con tecnología antivibración", 179.99, 0, catDeportes.getId());
        registrarProducto("Balón de Fútbol Oficial", "Balón de fútbol profesional", 39.99, 90, catDeportes.getId());

        log.info("=== Datos de prueba cargados exitosamente ===");
    }

    private Categoria registrarCategoria(String titulo, String detalle) {
        Categoria nuevaCat = new Categoria(null, titulo, detalle);
        return categoriaRepository.save(nuevaCat);
    }

    private Producto registrarProducto(String titulo, String detalle, double valor, int cantInicial, Long idCat) {
        Producto nuevoProd = new Producto(null, titulo, detalle, valor, cantInicial, idCat);
        return productoRepository.save(nuevoProd);
    }
}

