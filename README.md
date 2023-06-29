# JavaConversionApp-POO-APIs

El aplicatico ***JavaConversionApp-POO-APIs*** es una aplicación de conversión de diferentes medidas, incluyendo moneda, temperatura y longitud. El proyecto fue desarrollado utilizando una arquitectura orientada a objetos (POO) y una interfaz de programación de aplicaciones (API) para garantizar su flexibilidad y escalabilidad. El programa presenta una interfaz gráfica de usuario (GUI) intuitiva y fácil de usar, permitiendo al usuario interactuar de manera sencilla y eficiente con la aplicación. El proyecto fue construido como un proyecto Maven en Java, lo que permite una gestión eficiente de las dependencias y una fácil configuración del proyecto en diferentes entornos de desarrollo.

## Características
> Conversión de monedas: utilizando la API REST [ExchangeRate](https://www.exchangerate-api.com/) para obtener los valores actualizados de las monedas a convertir.

> Conversión de temperaturas: entre diferentes unidades (Celsius, Fahrenheit y Kelvin).

> Conversión de longitudes: entre diferentes unidades (metros, centímetros, kilómetros, millas, pies y pulgadas).

**1. Conversor.java:** Clase padre abstracta que es utilizada como base para los conversores de temperatura y longitud. Contiene un método abstracto ***convertir*** que debe ser implementado por las clases hijas. También tiene métodos para obtener y establecer las unidades de origen y destino.

**2. ConversorMoneda.java:** Clase encargada de realizar la conversión de monedas utilizando la API REST ExchangeRate. Esta clase tiene dos métodos principales:
> ***convertCurrency:*** Acepta como parámetros la moneda base, la moneda objetivo y la cantidad a convertir. Utiliza el método obtenerTipoCambio para obtener la tasa de cambio y realiza la conversión.

> ***ObtenerTipoCambio:*** Realiza una solicitud HTTP GET a la API y devuelve la respuesta en forma de objeto RespuestaTipoCambio.

**3. RespuestaTipoCambio.java:** Clase que almacena la respuesta de la API y facilita la extracción de los tipos de cambio. Se utiliza en conjunto con la clase ***ConversorMoneda*** para almacenar la información de la API y acceder a los datos fácilmente.

**4. ConversorTemperatura.java:** Clase para realizar conversiones entre diferentes unidades de temperatura (Celsius, Fahrenheit y Kelvin). Extiende la clase ***Conversor*** e implementa el método ***convertir*** para realizar las conversiones de temperatura. También contiene una enumeración ***UnidadTemperatura*** que define las unidades de temperatura compatibles.

**5. ConversorLongitud.java:** Clase para realizar conversiones entre diferentes unidades de longitud (metros, centímetros, kilómetros, millas, pies y pulgadas). Extiende la clase ***Conversor*** e implementa el método ***convertir*** para realizar las conversiones de longitud. También contiene una enumeración ***UnidadLongitud*** que define las unidades de longitud compatibles.

**6. ConversorGUI.java:** Clase principal que contiene la interfaz gráfica de usuario para interactuar con los diferentes conversores. Define una ventana principal con tres botones: "Moneda", "Temperatura" y "Longitud". Cada botón tiene un ***ActionListener*** asociado que abre una nueva ventana o muestra un cuadro de diálogo para realizar las conversiones correspondientes. Además, incluye una clase interna ***ConversorDivisasGUI*** que define la ventana de conversión de monedas y su funcionalidad.

**7. pom.xml:** Archivo de configuración de Maven que contiene las dependencias necesarias para el proyecto, incluida la biblioteca para manejar JSON. Se utiliza para gestionar las dependencias del proyecto y facilitar la importación y ejecución del proyecto en diferentes entornos de desarrollo.

## Cómo ejecutar
Clone el repositorio de GitHub en su máquina local.
Importe el proyecto Maven en su IDE de Java preferido (Eclipse, IntelliJ, etc.).
Ejecute la clase ConversorGUI.java para iniciar la aplicación.

## Uso
**1.** Al iniciar la aplicación, se mostrará una ventana con tres botones: "Moneda", "Temperatura" y "Longitud".

**2.** Haga clic en uno de los botones para elegir el tipo de conversión que desea realizar.
- Moneda: Se abrirá una nueva ventana en la que podrá ingresar la moneda base, la moneda objetivo y la cantidad a convertir (ingrese la sigla de la moneda base y objetivo ([Siglas](https://www.easymarkets.com/int/es/learn-centre/discover-trading/currency-acronyms-and-abbreviations/)). Haga clic en "Convertir" para obtener el resultado.
- Temperatura: Se le pedirá que ingrese la cantidad a convertir y seleccione las unidades de origen y destino. El resultado se mostrará en un cuadro de diálogo.
- Longitud: Se le pedirá que ingrese la cantidad a convertir y seleccione las unidades de origen y destino. El resultado se mostrará en un cuadro de diálogo.

**3.** Si desea realizar otra conversión, simplemente haga clic en otro botón o cierre la ventana actual de conversión de monedas y vuelva a hacer clic en "Moneda".

## Resultados
Al desarrollar esta actividad, se lograron varios objetivos y se adquirieron habilidades importantes en diversas áreas del desarrollo de software:

* Comprensión y uso de los principios de la Programación Orientada a Objetos (POO): Este proyecto ayudó a entender y aplicar conceptos clave de la POO, como la herencia, el polimorfismo y la encapsulación, al implementar las clases Conversor, ConversorLongitud y ConversorTemperatura.

* Consumo y solicitud de APIs REST: La elaboración del conversor de divisas requirió el uso de una API REST ([ExchangeRate-API](https://app.exchangerate-api.com)) para obtener la tasa de cambio actualizada. Esto permitió adquirir experiencia en la realización de solicitudes HTTP, el manejo de respuestas y la manipulación de datos en formato JSON.

* Diseño y creación de interfaces gráficas de usuario (GUI) en Java: Al construir la aplicación, se aprendió a diseñar y desarrollar interfaces gráficas de usuario utilizando la biblioteca Swing de Java, lo que incluye la creación y configuración de ventanas, paneles, botones, cuadros de diálogo y otros componentes.

* Gestión de dependencias y uso de proyectos Maven: Este proyecto fue creado como un proyecto Maven en Java, lo que permitió una mejor gestión de las dependencias y una estructura organizada del proyecto.

* Manejo de errores y excepciones: A lo largo del desarrollo, se trabajó en el manejo adecuado de errores y excepciones, mostrando mensajes de error claros y útiles al usuario en caso de que algo no funcionara correctamente.

En general, este proyecto proporcionó una valiosa experiencia en el desarrollo de aplicaciones de software completas y funcionales, utilizando diferentes técnicas y tecnologías para lograr un resultado exitoso y fácil de usar.
