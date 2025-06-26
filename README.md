# calculadora-pedidos

Proyecto Java con Maven para calcular el total de un pedido, incluyendo descuentos y costos de envío.  
Incluye pruebas unitarias con JUnit 5 y Mockito, y configuración de integración continua con GitHub Actions.

---

## 📋 Contenido del proyecto

- **PedidoService**: Clase principal que calcula el total de un pedido.
- **DescuentoRepository**: Repositorio que gestiona códigos de descuento.
- **Pruebas unitarias**: Verifican el comportamiento correcto de la lógica.
- **Configuración CI**: Workflow de GitHub Actions para ejecutar tests automáticamente.

---

## 🔧 Tecnologías usadas

- Java 17
- Maven (gestor de dependencias y compilación)
- JUnit 5 (pruebas unitarias)
- Mockito (simulación de dependencias para pruebas unitarias)
- GitHub Actions (integración continua)

---

## 📖 Explicación paso a paso del desarrollo

### 1. Creación del servicio `PedidoService`

- Se creó una clase con un método `calcularTotal` que recibe:
  - subtotal del pedido (double)
  - código de descuento (String)
  - tipo de envío (boolean: express o normal)

- El método consulta un repositorio para obtener el porcentaje de descuento asociado al código.

- Aplica el descuento sobre el subtotal y suma el costo del envío.

### 2. Implementación del repositorio `DescuentoRepository`

- Clase que simula una fuente de datos para descuentos.
- Si el código es `"PROMO10"`, devuelve 10% de descuento.
- Para otros códigos, devuelve 0%.

### 3. Refactorización para inyección de dependencias

- `PedidoService` ahora recibe un objeto `DescuentoRepository` por constructor.
- Esto mejora la separación de responsabilidades y permite testear de forma aislada.

### 4. Pruebas unitarias

- Se escribieron pruebas para verificar distintos escenarios:
  - Pedido sin descuento y envío normal
  - Pedido con descuento y envío express
  - Pedido con descuento y envío normal
  - Pedido sin descuento y envío express

- Uso de **JUnit 5** para organizar y ejecutar las pruebas.

### 5. Uso de **Mocks** con Mockito

- Para pruebas más aisladas, se usó Mockito para simular el repositorio de descuentos.
- Esto permite definir exactamente qué descuento se devuelve sin depender de la lógica real del repositorio.
- Ventajas:
  - Tests más rápidos y estables.
  - Aislamiento de la clase bajo prueba.
  - Control total sobre los datos que se prueban.

### 6. Integración continua con GitHub Actions

- Se creó un workflow `.github/workflows/maven-test.yml` que ejecuta automáticamente las pruebas cada vez que haces push o pull request a la rama principal.
- Esto asegura que cualquier cambio sea validado antes de integrarse.

---

## 🧪 ¿Qué son las pruebas unitarias?

Las pruebas unitarias son pequeños fragmentos de código que verifican que una unidad funcional específica (una función o método) se comporte correctamente ante diferentes condiciones y entradas.  
En este proyecto, las pruebas unitarias validan que `PedidoService` calcule correctamente el total del pedido bajo distintos escenarios.

---

## 🤖 ¿Qué es un Mock?

Un mock es un objeto simulado que imita el comportamiento de una dependencia real para permitir pruebas aisladas.  
En nuestro proyecto, usamos un mock de `DescuentoRepository` para controlar qué porcentaje de descuento devuelve, sin depender de su implementación real.

---

## 🚀 Cómo correr el proyecto y las pruebas

### Requisitos previos

- Java 17 instalado
- Maven instalado

### Ejecutar pruebas localmente

---
##❓ Preguntas frecuentes


¿Qué te ayuda a identificar las pruebas unitarias?
Las pruebas unitarias me ayudan a asegurar que cada parte pequeña del código (como un método o función) haga exactamente lo que debe hacer. Si algo cambia y rompe esa parte, la prueba falla y me avisa rápido, evitando que un error llegue a producción.

¿Cuál fue el beneficio de usar un mock para simular una dependencia?
El mock me permitió probar PedidoService sin depender del repositorio real de descuentos. Así puedo controlar exactamente qué valores devuelve el repositorio y concentrarme en validar solo la lógica del servicio, haciendo las pruebas más rápidas, limpias y confiables.

¿Qué pasaría si se modifica la lógica de descuentos sin actualizar las pruebas?
Si cambio la lógica pero no actualizo las pruebas, puede que las pruebas fallen o, peor, que sigan pasando pero no detecten errores. Esto genera falsos positivos y puede esconder bugs, por eso mantener las pruebas alineadas con la lógica es fundamental.

¿Cómo escalamos esta estrategia para un sistema más grande?
Para sistemas más grandes, mantenemos el mismo enfoque: crear pruebas unitarias para cada componente, usar mocks para aislar dependencias externas y complementar con pruebas de integración y end-to-end. También automatizamos todo con pipelines CI/CD para que cada cambio se valide automáticamente, asegurando calidad continua.
