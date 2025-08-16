# dionario com jdbc

```mermaid
classDiagram
    class Dicionario {
        +List<Palavra> palavras
    }

    class Palavra {
        +String nome
        +List<Significado> significados
        +Origem origem
        +List<Frase> frases
    }

    class Significado {
        +String descricao
    }

    class Origem {
        +String tipo
        +String titulo
        +String pag
    }

    class Frase {
        +String frase
    }

    Dicionario "1" *-- "0..*" Palavra
    Palavra "1" *-- "0..*" Significado
    Palavra "1" *-- "1" Origem
    Palavra "1" *-- "0..*" Frase
```

## Banco oracle e flyway

Para conectar o Flyway ao banco Oracle, enfrentei sérios problemas, desde questões de conexão até permissões de usuários. Isso exigiu muita pesquisa, mas foi extremamente benéfico para o meu aprendizado.

Fiz um resumo explicando o motivo de ter tomado determinadas decisões para conseguir dar andamento ao projeto.

[Guia Oracle XEPDB1 Flyway](Guia_Oracle_XEPDB1_Flyway.pdf)
