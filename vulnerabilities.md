# Vulnerabilities

Este documento describe las vulnerabilidades identificadas en GPSMapApp durante las revisiones de seguridad. 

## Vulnerabilidades Detectadas

### 1. Inyección SQL

- Descripción: La aplicación presentaba riesgos de inyección SQL en los módulos que interactúan con la base de datos, lo que permitía que datos externos afectaran las consultas SQL.
- Impacto: Potencial acceso no autorizado a la base de datos, comprometiendo la integridad de los datos del usuario.
- Solución Implementada: Se cambiaron todas las consultas SQL a sentencias preparadas, lo cual evita la ejecución de comandos maliciosos mediante la inyección de SQL.

### 2. Configuración Incorrecta de TLS

- Descripción: La aplicación no estaba utilizando la configuración TLS más segura, lo que podría haber permitido conexiones menos seguras o ataques de interceptación.
- Impacto: Riesgo de ataque de intermediario (MITM) al permitir conexiones no seguras.
- Solución Implementada: Se actualizó la configuración de TLS en el archivo `network_security_config.xml` para forzar solo conexiones HTTPS y se implementaron certificados válidos.

### 3. Bypass de Pinning de TLS

- Descripción: La aplicación era vulnerable a un bypass de pinning de TLS, lo que permitía que certificados no autorizados fueran aceptados en la conexión de red.
- Impacto: Exposición a posibles ataques de interceptación y acceso a datos sensibles.
- Solución Implementada: Se implementó pinning de certificados, configurando `network_security_config.xml` y un `TrustManager` personalizado para validar los certificados.

### 4. Falta de Validación y Sanitización de Entradas

- Descripción: No se estaban validando correctamente las entradas del usuario en algunos formularios, lo que podría permitir inyecciones de código o entradas maliciosas.
- Impacto: Riesgo de que datos maliciosos afecten la lógica de la aplicación o expongan datos sensibles.
- Solución Implementada: Se añadieron controles de validación y sanitización en todos los campos de entrada de la aplicación, utilizando expresiones regulares para permitir solo datos válidos.


