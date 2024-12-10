# Sistema de Gestión de Pedidos

Este proyecto es un sistema de gestión de pedidos desarrollado en Java, que implementa principios SOLID y patrones de diseño como *Strategy*, *Decorator*, y *Visitor*. El sistema permite gestionar órdenes con múltiples productos, aplicar descuentos dinámicos, generar reportes personalizables y exportar los datos en diferentes formatos como CSV, JSON y XML.

---

## *Características Principales*
1. *Gestión de Órdenes:*
    - Manejo de productos asociados a una orden.
    - Cálculo de totales con y sin descuento.

2. *Descuentos Dinámicos:*
    - Aplicación de diferentes estrategias de descuento:
        - Descuento por temporada.
        - Descuento para clientes frecuentes.
        - Sin descuento.

3. *Reportes Personalizables:*
    - *ReporteSimple:* Muestra solo el total con descuento.
    - *ReporteDetallado:* Incluye un desglose de descuentos.
    - *ReporteExtendido:* Añade estadísticas adicionales como el porcentaje de descuento aplicado.

4. *Exportación de Órdenes:*
    - Exportación en formatos *CSV*, *JSON* y *XML* utilizando el patrón *Visitor*.

---

## *Diagrama de Clases*
![diagramaClase.png](diagramasUML%2FdiagramaClase.png)

Este diagrama muestra las relaciones entre las clases principales del sistema, incluyendo:
- La clase Orden y su relación con Producto y EstrategiaDescuento.
- Los diferentes reportes implementados con el patrón *Decorator*.
- Las exportaciones en diferentes formatos mediante el patrón *Visitor*.

---

## *Diagrama de Secuencia*
![diagramaSecuencia.png](diagramasUML%2FdiagramaSecuencia.png)

Este diagrama describe el flujo de interacción entre el usuario, la clase Orden, y los exportadores cuando se realiza la exportación de datos en diferentes formatos.

---

## *Diagrama de Estados*
![diagramaEstado.png](diagramasUML%2FdiagramaEstado.png)

El diagrama de estados refleja el ciclo de vida de una Orden:
1. Creación de la orden.
2. Agregación de productos.
3. Aplicación de descuentos.
4. Generación de reportes.
5. Exportación de datos.

---

## *Salida esperada*

Al ejecutar el archivo main de este proyecto podras observar tres ordenes generadas de manera aleatoria que muestran el comportamiento completo de la aplicación.
```
*** Orden sin descuento ***
Reporte Simple: 
Total: $179438.19


Reporte Detallado: 
Total: $179438.19
Total de descuentos: $0.00
Descuento aplicado: 0% 


Reporte Extendido: 
Total: $179438.19
Total de descuentos: $0.00
Descuento aplicado: 0% 
Estadisticas adicionales: 
Numero de productos: 8


Exportar CSV: 
Producto,Precio
Smartwatch,44886.22
Cámara,20256.39
Smartwatch,17430.6
Mouse,48698.46
Teclado,7808.84
Teclado,1657.09
Laptop,27062.47
Tablet,11638.12



Exportar JSON: 
{
  "productos" : [ {
    "nombre" : "Smartwatch",
    "precio" : 44886.22
  }, {
    "nombre" : "Cámara",
    "precio" : 20256.39
  }, {
    "nombre" : "Smartwatch",
    "precio" : 17430.6
  }, {
    "nombre" : "Mouse",
    "precio" : 48698.46
  }, {
    "nombre" : "Teclado",
    "precio" : 7808.84
  }, {
    "nombre" : "Teclado",
    "precio" : 1657.09
  }, {
    "nombre" : "Laptop",
    "precio" : 27062.47
  }, {
    "nombre" : "Tablet",
    "precio" : 11638.12
  } ]
}


Exportar XML: 
<ArrayList>
  <item>
    <nombre>Smartwatch</nombre>
    <precio>44886.22</precio>
  </item>
  <item>
    <nombre>Cámara</nombre>
    <precio>20256.39</precio>
  </item>
  <item>
    <nombre>Smartwatch</nombre>
    <precio>17430.6</precio>
  </item>
  <item>
    <nombre>Mouse</nombre>
    <precio>48698.46</precio>
  </item>
  <item>
    <nombre>Teclado</nombre>
    <precio>7808.84</precio>
  </item>
  <item>
    <nombre>Teclado</nombre>
    <precio>1657.09</precio>
  </item>
  <item>
    <nombre>Laptop</nombre>
    <precio>27062.47</precio>
  </item>
  <item>
    <nombre>Tablet</nombre>
    <precio>11638.12</precio>
  </item>
</ArrayList>
```

---

## *Requisitos*
- *Java 17* o superior.
- *Gradle* para la gestión del proyecto.
- Librerías utilizadas:
    - *JUnit 5:* Para pruebas unitarias.
    - *Jackson:* Para manejar formatos JSON y XML.

---