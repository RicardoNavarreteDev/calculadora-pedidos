package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoServiceTest {

    DescuentoRepository repo = new DescuentoRepository();
    PedidoService service = new PedidoService(repo);

    @Test
    void testSinDescuentoYEnvioNormal() {
        double total = service.calcularTotal(100, "NINGUNO", false);
        assertEquals(110.0, total, 0.001);
    }

    @Test
    void testConDescuentoYEnvioExpress() {
        double total = service.calcularTotal(100, "PROMO10", true);
        assertEquals(110.0, total, 0.001);
    }

    @Test
    void testConDescuentoYEnvioNormal() {
        double total = service.calcularTotal(200, "PROMO10", false);
        assertEquals(190.0, total, 0.001);
    }

    @Test
    void testSinDescuentoYEnvioExpress() {
        double total = service.calcularTotal(150, "NINGUNO", true);
        assertEquals(170.0, total, 0.001);
    }
}
