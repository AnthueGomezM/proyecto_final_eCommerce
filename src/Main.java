
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.VarianteProducto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.factory.AbstractProductoFactory;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.factory.ProductoDeportivoFactory;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.factory.ProductoLujoFactory;
import co.edu.ucc.proyecto_final_eCommerce.categorias.composite.CategoriaJerarquica;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Categoria;
import co.edu.ucc.proyecto_final_eCommerce.categorias.composite.ItemProducto;
import co.edu.ucc.proyecto_final_eCommerce.cupones.chain.FechaValidaRegla;
import co.edu.ucc.proyecto_final_eCommerce.cupones.chain.MontoMinimoRegla;
import co.edu.ucc.proyecto_final_eCommerce.cupones.chain.ReglaValidacion;
import co.edu.ucc.proyecto_final_eCommerce.cupones.chain.TipoUsuarioRegla;
import co.edu.ucc.proyecto_final_eCommerce.cupones.command.AplicarCuponCommand;
import co.edu.ucc.proyecto_final_eCommerce.cupones.command.Carrito;
import co.edu.ucc.proyecto_final_eCommerce.cupones.command.CarritoCommand;
import co.edu.ucc.proyecto_final_eCommerce.cupones.model.Cupon;
import co.edu.ucc.proyecto_final_eCommerce.cupones.model.UsuarioTipo;
import co.edu.ucc.proyecto_final_eCommerce.pago.contexto.ProcesadorPago;
import co.edu.ucc.proyecto_final_eCommerce.pago.model.DetallePago;
import co.edu.ucc.proyecto_final_eCommerce.pago.strategy.EstrategiaPorMonto;
import co.edu.ucc.proyecto_final_eCommerce.pago.strategy.EstrategiaPorPais;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Estados.EnviadoState;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Logistica;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Mediator.PedidoMediator;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Mediator.PedidoMediatorImple;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Notificacion;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Pedido;
import co.edu.ucc.proyecto_final_eCommerce.pedidoMemento.PedidoHistorial;
import co.edu.ucc.proyecto_final_eCommerce.pedidoMemento.PedidoMemento;
import co.edu.ucc.proyecto_final_eCommerce.recomendacion.contexto.RecomendadorContexto;
import co.edu.ucc.proyecto_final_eCommerce.recomendacion.observer.EventoUsuario;
import co.edu.ucc.proyecto_final_eCommerce.recomendacion.observer.MotorRecomendacion;
import co.edu.ucc.proyecto_final_eCommerce.recomendacion.strategy.RecomendacionPorComportamiento;
import co.edu.ucc.proyecto_final_eCommerce.reportes.fecade.ReporteFacade;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Personalizacion.main(null);

        System.out.println("\nHistoria de usario 1");
        AbstractProductoFactory factoryDeporte = new ProductoDeportivoFactory();
        AbstractProductoFactory factoryLujo = new ProductoLujoFactory();

        Producto p1 = factoryDeporte.crearProducto();
        Producto p2 = factoryLujo.crearProducto();

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("\nHistoria de usario 2");
        DetallePago pago = new DetallePago("cliente123", 120.0, "USD", "USA");

        // Elegimos estrategia por país
        ProcesadorPago procesador = new ProcesadorPago(new EstrategiaPorPais());
        procesador.procesar(pago);

        // Cambiamos estrategia a monto
        procesador.setEstrategia(new EstrategiaPorMonto());
        procesador.procesar(pago);

        System.out.println("\nHistoria de usario 3");
        Usuario usuario = new Usuario("cliente123");
        MotorRecomendacion motor = new MotorRecomendacion();

        // Simular eventos
        Categoria ropaDeportiva = new Categoria("Ropa Deportiva");
        VarianteProducto variante1 = new VarianteProducto("M", "Rojo", "Sintético");
        VarianteProducto variante2 = new VarianteProducto("L", "Negro", "Cuero");
        Producto p3 = new Producto( "Zapatillas deportivas",
                "Zapatillas ideales para correr",
                199.99,
                ropaDeportiva,
                Arrays.asList(variante1, variante2));
        Producto p4 = new Producto("Chaqueta impermeable",
                "Perfecta para clima lluvioso",
                249.99,
                ropaDeportiva,
                Arrays.asList(variante1));

        motor.actualizar(EventoUsuario.BUSQUEDA, p3, usuario);
        motor.actualizar(EventoUsuario.BUSQUEDA, p4, usuario);

        // Obtener recomendaciones
        RecomendadorContexto recomendador = new RecomendadorContexto(new RecomendacionPorComportamiento());
        List<Producto> recomendados = recomendador.obtenerRecomendaciones(usuario);

        recomendados.forEach(p -> System.out.println("Recomendado: " + p));

        System.out.println("\nHistoria de usario 4");
        // Productos
        Producto p5 = new Producto("Zapatillas Running",
                "Zapatillas ligeras para correr largas distancias",
                149.99,
                ropaDeportiva,
                Arrays.asList(variante1));
        Producto p6 = new Producto("Camiseta Técnica",
                "Camiseta transpirable para entrenamiento",
                39.99,
                ropaDeportiva,
                Arrays.asList(variante1));
        Producto p7 = new Producto("Chaqueta Impermeable",
                "Protección total contra lluvia y viento",
                89.99,
                ropaDeportiva,
                Arrays.asList(variante2));

        // Items hoja
        ItemProducto item1 = new ItemProducto(p5);
        ItemProducto item2 = new ItemProducto(p6);
        ItemProducto item3 = new ItemProducto(p7);

        // Categorías
        CategoriaJerarquica ropaDeporti = new CategoriaJerarquica("Ropa Deportiva");
        CategoriaJerarquica calzado = new CategoriaJerarquica("Calzado");
        CategoriaJerarquica exterior = new CategoriaJerarquica("Exterior");

        ropaDeporti.agregarElemento(item2);
        calzado.agregarElemento(item1);
        exterior.agregarElemento(item3);

        CategoriaJerarquica deportes = new CategoriaJerarquica("Deportes");
        deportes.agregarElemento(ropaDeporti);
        deportes.agregarElemento(calzado);
        deportes.agregarElemento(exterior);

        // Mostrar estructura
        deportes.mostrar(0);

        System.out.println("\nHistoria de usario 5");
        ReglaValidacion reglas = new MontoMinimoRegla()
                .enlazarCon(new FechaValidaRegla())
                .enlazarCon(new TipoUsuarioRegla());

        Cupon cupon = new Cupon("DESCUENTO10", 10.0, 100.0, LocalDate.of(2025, 12, 7), UsuarioTipo.PREMIUM);
        Usuario usuario1 = new Usuario("Juan");
        usuario1.setTipo(UsuarioTipo.PREMIUM);
        Carrito carrito = new Carrito();
        carrito.agregarProducto(p1, 1);
        carrito.agregarProducto(p2, 2);

        CarritoCommand aplicarCupon = new AplicarCuponCommand(carrito, cupon, usuario1, reglas);
        aplicarCupon.ejecutar();

        // Si se desea revertir:
        aplicarCupon.deshacer();

        System.out.println("\nHistoria de usario 6");
        // Crear servicios externos
        Logistica logistica = new Logistica();
        Notificacion notificacion = new Notificacion();

        // Crear el Mediator con los servicios
        PedidoMediator mediator = new PedidoMediatorImple(logistica, notificacion);

        // Crear un pedido con estado inicial Pendiente
        Pedido pedido = new Pedido("PED-001", mediator);

        System.out.println("📝 Estado inicial del pedido: " + pedido.verEstado());

        // Avanzar al estado Confirmado
        System.out.println("\n➡️ Avanzando estado del pedido...");
        pedido.avanzarEstado();
        System.out.println("📦 Estado actual: " + pedido.verEstado());

        // Avanzar al estado Enviado
        System.out.println("\n➡️ Avanzando estado del pedido...");
        pedido.avanzarEstado();
        System.out.println("📦 Estado actual: " + pedido.verEstado());

        // Intentar cancelar (no debe ser posible)
        System.out.println("\n❌ Intentando cancelar el pedido...");
        pedido.cancelar();
        System.out.println("📦 Estado actual: " + pedido.verEstado());

        // Avanzar al estado Entregado
        System.out.println("\n➡️ Avanzando estado del pedido...");
        pedido.avanzarEstado();
        System.out.println("📦 Estado actual: " + pedido.verEstado());

        // Intentar avanzar más (no debe hacer nada)
        System.out.println("\n➡️ Avanzando estado del pedido (más allá de entregado)...");
        pedido.avanzarEstado();

        System.out.println("\nHistoria de usario 7");
        // Crear productos ficticios
        Producto p8 = new Producto("Zapatillas NIKE",
                "Zapatillas resitentes y frescas",
                200,
                ropaDeportiva,
                Arrays.asList(variante1));
        Producto p9 = new Producto("Zapatillas PUMA",
                "Zapatillas comodas y frescas",
                250,
                ropaDeportiva,
                Arrays.asList(variante1));
        Producto p10 = new Producto("Zapatillas GUCCI",
                "Zapatillas ligeras y frescas",
                300,
                ropaDeportiva,
                Arrays.asList(variante1));

        // Crear usuarios con datos de búsqueda, compras y productos recientes
        Usuario u1 = new Usuario("U001");
        u1.getHistorialBusqueda().addAll(List.of(p8, p9));
        u1.getCompras().add(p9);
        u1.getProductosRecientes().addAll(List.of(p9, p10));

        Usuario u2 = new Usuario("U002");
        u2.getHistorialBusqueda().add(p10);
        u2.getCompras().addAll(List.of(p8, p10));
        u2.getProductosRecientes().add(p8);

        // Crear la fachada de reportes
        ReporteFacade fachadaReportes = new ReporteFacade();

        // Generar informes
        fachadaReportes.generarReportesUsuarios(List.of(u1, u2));

        System.out.println("\nHistoria de usario 8");
        // Crear historial y pedido
        PedidoHistorial historial = new PedidoHistorial();
        Pedido pedido1 = new Pedido("PED-202", "Cra 123 #45-67");

        // Mostrar estado inicial
        pedido1.mostrarInfo();

        // Guardar estado inicial
        historial.guardar(pedido1.guardarEstado());

        // Confirmar envío
        System.out.println("\n📦 Confirmando envío del pedido...");
        pedido1.confirmarEnvio();
        pedido1.mostrarInfo();

        // Guardar estado después de envío
        historial.guardar(pedido1.guardarEstado());

        // Cancelar pedido
        System.out.println("\n❌ Cancelando el pedido...");
        pedido1.cancelar();
        pedido1.mostrarInfo();

        // Deshacer cancelación (simular devolución al estado anterior)
        System.out.println("\n↩️ Revirtiendo estado (simulando devolución)...");
        pedido1.restaurarEstado(historial.deshacer());
        pedido1.mostrarInfo();

        // Otra reversión (al estado inicial)
        System.out.println("\n↩️ Revirtiendo aún más (estado inicial)...");
        pedido1.restaurarEstado(historial.deshacer());
        pedido1.mostrarInfo();
    }
    }
}