Introducción

Se presenta el enunciado de las prácticas de la asignatura Introducción a la Ingeniería del
Software del Grado de Ingeniería Informática y Grado de Tecnologías de la Información.
También se presentará las condiciones de entrega de los trabajos enunciados a los tutores, las
condiciones de corrección y posterior entrega de calificaciones.
El contenido de estas prácticas integra dos partes progresivas que el alumno irá realizando y
entregando a su tutor para su corrección.


Objetivos

El objetivo de esta práctica es la consolidación de los conocimientos adquiridos con el estudio
de la asignatura mediante un ejercicio que abarca los contenidos del curso. Es importante haber
estudiado con anterioridad los diferentes temas que integran el curso y haber realizado alguno
de los ejercicios propuestos. La práctica está estructurada de tal forma que se puede ir realizando
a medida que se van estudiando los temas y permite al alumno comprobar hasta qué punto ha
asimilado los conocimientos.
Un objetivo secundario de esta práctica es comparar como se aborda la realización de un
proyecto software desde la óptica de la ingeniería frente al ya conocido y realizado desde la
óptica del desarrollador o el programador.


Enunciado

Se desea realizar la formalización del proceso de desarrollo de una aplicación a partir de su
especificación. Como especificación utilizaremos la descripción pormenorizada de la aplicación
del apéndice A. Esta aplicación es un simulador de la expansión de un virus siguiendo un modelo
exponencial.
Adicionalmente habrá que programar, orientado a objetos, la aplicación. El programa deberá
ser totalmente consistente con el diseño realizado, es decir, no vale diseñar algo y programar
otra cosa.

Particularmente se pide

Práctica 1: Elaborar el documento de diseño del proyecto especificado en el apéndice A. El
documento debe seguir el formato establecido en el libro de texto recomendado para la
asignatura, si bien debe utilizar los diagramas de UML que se precisen: casos de uso, clases,
secuencia, colaboración, estado y actividad. Para la representación de los diagramas UML que
se piden se deberá utilizar alguna herramienta software. Se recomienda utilizar Argo, que es de
libre distribución, y puede descargarse en: http://argouml.tigris.org/
Práctica 2: Programar en Java o cualquier otro lenguaje, previo acuerdo con el tutor, la aplicación
de simulación de expansión de un virus siguiendo los documentos de diseño que se han
entregado en la práctica 1. Van a usar sus propios “planos”.
Las decisiones que se han tomado en el diseño, así como las consideraciones que haya hecho el
tutor respecto del diseño deberán verse reflejadas, EXPLICITAMENTE, en una pequeña
memoria justificativa que acompañara la solución codificada. Se trata de ayudar a que el tutor
pueda evaluar fácilmente el trabajo desarrollado y que compruebe que sus recomendaciones se
han tenido en cuenta. Les ha tocado un cliente exigente que supervisa no sólo el producto sino
la ingeniería del producto.


Condiciones de presentación

El calendario de presentación de las prácticas será el que marque el tutor, teniendo en cuenta
que han de entregarse por orden. La práctica 2 estará sujeta a lo comentarios y correcciones que
el tutor indique de la práctica 1.
Las fechas de entrega que aparecen en el enlace de tareas son una restricción mínima que el
tutor del centro asociado puede restringir para favorecer la corrección de éstas.
Las prácticas se entregarán a través de la plataforma de UNED en “tareas”.
La entrega de una sola de las prácticas ya sea la 1 o la 2, no tendrá ningún valor de cara a la nota
final del curso. Se deberán entregar las dos.


APÉNDICE A

Realizar un programa orientado a objetos en Java que simule la expansión de un virus en una
población siguiendo un modelo exponencial.
El número de casos de infectados depende de:
• El número de contactos que en promedio tenga cada infectado con personas no
infectadas, lo llamaremos E.
• La probabilidad de infectarse con un contacto, que llamaremos p.
Si el número de infectados de una comunidad en un día d es Nd, el número de infectados el día
siguiente Nd+1 será:
Nd+1 = Nd + Nd *E*p = Nd * (1+E*p)
Además, debemos pensar que vivimos en comunidades (ya sean países, pueblos o provincias)
con una limitada interrelación unas con otras, lo que limita la expansión del virus de unas a
otras.
Supongamos que V es el número de viajeros diarios de una comunidad a otra, entonces el
número de infectados en una comunidad por culpa de los viajeros Nv sería:
Nv=E*p*V*Nd,origen/Porigen
Donde Nd,origen sería número de infectados en la comunidad de origen del viajero y Porigen sería la
población de la comunidad de origen. El cociente entre estos números representa la
probabilidad de que el viajero esté infectado.
Por lo tanto habrá que sumar Nd+1 y Nv para saber el total de infectados en día d+1 en una
comunidad.
El programa debe permitir introducir los siguientes datos a usuario del programa:
• Número de comunidades y la población de cada una de ellas.
• Porcentaje de habitantes de cada comunidad que viaja diariamente a cada una de las
otras comunidades, igual para todas las comunidades para simiplificar.
• Coeficientes E, p y V.
• Número de días a simular
El programa debe devolver una tabla con los datos de infectados día a día en cada comunidad,
el porcentaje de población infectada de cada comunidad, el número de infectados de la
población total y el porcentaje de población total infectada. La presentación de los datos debe
ser tal que se puedan analizar de forma pausada, apreciándose las representaciones gráficas.
Una vez terminada una simulación, el programa debe permitir modificar cualquiera de los
parámetros y volver a realizar la simulación.
Se supone que el día uno aparece un primer infectado en una de las poblaciones.


