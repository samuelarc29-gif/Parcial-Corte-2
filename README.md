```md
# Diagrama de Clases

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
    +equiparArma(Arma arma)
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