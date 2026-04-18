#  Batalla de Criaturas - Programación II

Proyecto desarrollado para el parcial práctico de Programación II.

##  Integrantes
- Samuel
- [Tu compañero]

##  Objetivo
Implementar un sistema de batalla entre criaturas usando POO.

##  Conceptos usados
- Clases abstractas
- Interfaces
- Polimorfismo
- Composición
- JUnit 5

##  Funcionalidades
- Ataques entre criaturas
- Uso de armas
- Hechizos
- Batallas hasta la muerte

##  Pruebas
Se usó JUnit 5 para validar el comportamiento del sistema.

##  Ejecución

```bash
cd batalla
mvn clean test

- [Nombre del compañero]

---

##  Objetivo
Desarrollar un sistema donde distintas criaturas puedan enfrentarse en batalla aplicando herencia, polimorfismo, interfaces y composición.

---

##  Conceptos aplicados
- Clases abstractas  
- Interfaces  
- Polimorfismo  
- Composición  
- Pruebas unitarias con JUnit 5  

---

##  Funcionalidades principales

- Ataques entre criaturas  
- Reducción de salud (defensa)  
- Uso de armas (composición)  
- Habilidades especiales:
  - Dragón puede volar  
  - Mago puede lanzar hechizos  
- Simulación de batallas hasta que una criatura muere  

---

## Diagrama de clases

```mermaid
classDiagram

class Criatura {
    #String nombre
    #int salud
    #int fuerza
    #Arma arma
    +atacar(Criatura objetivo)
    +defender(int danio)
    +estaViva() boolean
    +equiparArma(Arma arma)s
    +desequiparArma()
}

class Dragon {
    -String escamas
    +atacar(Criatura objetivo)
    +defender(int danio)
    +volar()
    +aterrizar()
}

class Mago {
    -List~String~ hechizos
    +atacar(Criatura objetivo)
    +defender(int danio)
    +lanzarHechizo()
    +aprenderHechizo(String hechizo)
}

class Guerrero {
    +atacar(Criatura objetivo)
    +defender(int danio)
}

class Arma {
    -String nombre
    -int danioAdicional
    +atacarConArma(Criatura objetivo)
    +getDanioAdicional() int
    +getNombre() String
}

class Volador {
    <<interface>>
    +volar()
    +aterrizar()
}

class Magico {
    <<interface>>
    +lanzarHechizo()
    +aprenderHechizo(String hechizo)
}

class Main {
    +simularBatalla(Criatura c1, Criatura c2)
    +main(String[] args)
}

Criatura <|-- Dragon
Criatura <|-- Mago
Criatura <|-- Guerrero

Dragon ..|> Volador
Mago ..|> Magico

Criatura --> Arma
Main --> Criatura