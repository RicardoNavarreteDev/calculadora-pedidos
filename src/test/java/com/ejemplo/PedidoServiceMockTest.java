package com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PedidoServiceMockTest {
    
    @Test
    void testConMockDeDescuento() {
        // Arrange
        DescuentoRepository mockRepo = mock(DescuentoRepository.class);
        when(mockRepo.obtenerPorcentaje("PROMO10")).thenReturn(0.10);

        PedidoService service = new PedidoService(mockRepo);

        // Act
        double total = service.calcularTotal(100, "PROMO10", true);

        // Assert
        assertEquals(90 + 20, total, 0.001); // más explícito y correcto
    }
}
