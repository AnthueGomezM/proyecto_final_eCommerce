# 🛒 Plataforma de Comercio Electrónico Omnicanal

> Proyecto académico desarrollado en Java aplicando patrones de diseño y buenas prácticas de arquitectura para simular una plataforma de e-commerce moderna, extensible y modular.

---
## 🚀 Descripción general

Esta plataforma permite a los clientes realizar compras desde diferentes canales (web, móvil, kiosco), integrando:

- Variantes complejas de productos
- Múltiples pasarelas de pago
- Sistema inteligente de recomendaciones
- Gestión jerárquica de catálogo
- Cupones con condiciones y lógica flexible
- Seguimiento de pedidos y atención al cliente
- Informes analíticos de comportamiento y ventas
- Módulo de devoluciones con restauración de estados
- Simulación de tráfico concurrente con multithreading

---

## 🧩 Patrones de diseño aplicados

| Historia de Usuario                                           | Patrones Aplicados                          |
|---------------------------------------------------------------|---------------------------------------------|
| Creación de productos con variantes                           | Builder + Abstract Factory                  |
| Integración con pasarelas de pago                             | Adapter + Strategy                          |
| Sistema de recomendación de productos                         | Strategy + Observer                         |
| Gestión del catálogo jerárquico                               | Composite                                   |
| Cupones promocionales y condiciones de uso                    | Chain of Responsibility + Command           |
| Seguimiento de pedidos y atención al cliente                  | State + Mediator                            |
| Informes de ventas y comportamiento del usuario               | Visitor + Facade                            |
| Cancelación y devolución de pedidos                           | Memento                                     |
| Simulación de compras concurrentes                            | Thread + Flyweight + Observer               |

---

## ⚙️ Requisitos técnicos

- **Java 17+**
- IDE recomendado: IntelliJ IDEA o Eclipse

---

