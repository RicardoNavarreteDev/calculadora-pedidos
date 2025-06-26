package com.ejemplo;

public class PedidoService {

    private DescuentoRepository repository;

    public PedidoService(DescuentoRepository repository) {
        this.repository = repository;
    }

    public double calcularTotal(double subtotal, String aplicaDescuento, boolean envioExpress){
        double descuento = repository.obtenerPorcentaje(aplicaDescuento);
        double envio = envioExpress ? 20.0 : 10.0;
        return subtotal * (1 - descuento) + envio;
    }
}
